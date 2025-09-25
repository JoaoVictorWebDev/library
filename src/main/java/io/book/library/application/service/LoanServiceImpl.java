package io.book.library.application.service;

import io.book.library.application.dto.LoanDTO;
import io.book.library.application.mapper.LoanMapper;
import io.book.library.application.service.interfaces.LoanService;
import io.book.library.domain.entities.Book;
import io.book.library.domain.entities.Loan;
import io.book.library.domain.entities.User;
import io.book.library.domain.enums.BookStatus;
import io.book.library.infrastructure.config.exceptions.EntityNotFoundException;
import io.book.library.infrastructure.repository.IBookRepository;
import io.book.library.infrastructure.repository.ILoanRepository;
import io.book.library.infrastructure.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private ILoanRepository loanRepository;

    @Autowired
    private IBookRepository bookRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private LoanMapper loanMapper;

    public LoanDTO createLoan(Loan loan) {
        Book book = bookRepository.findById(loan.getBook().getId())
                .orElseThrow(() -> new EntityNotFoundException("Book não encontrado com ID: " + loan.getBook().getId()));

        User user = userRepository.findById(loan.getUser().getUserID())
                .orElseThrow(() -> new EntityNotFoundException("User não encontrado com ID: " + loan.getUser().getUserID()));

        loan.setBook(book);
        loan.setUser(user);

        if (!book.getBookStatus().equals(BookStatus.RETURNED)) {
            throw new IllegalStateException("O livro não está disponível para empréstimo");
        }

        book.setBookStatus(BookStatus.RENTED);
        bookRepository.save(book);

        Loan savedLoan = loanRepository.save(loan);

        return loanMapper.userToDTO(savedLoan);
    }

    public void deleteTransactionByID(Long transactionById) {
        loanRepository.deleteById(transactionById);
    }

    public List<Loan> findAll() {
        return loanRepository.findAll();
    }

    public Optional<Loan> findByID(Long id) {
        return Optional.ofNullable(loanRepository.findById(id).orElse(null));
    }

    public LoanDTO updateByID(Long id, LoanDTO updateRequest) {
        Loan existingLoan = loanRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Loan not found"));
        loanMapper.updateLoanFromDTO(updateRequest, existingLoan);
        return loanMapper.userToDTO(loanRepository.save(existingLoan));

    }

    public void returnBook(Loan Loan) {
        if (Loan.getReturned().isAfter(Loan.getDueDate()) && Loan.getBookStatus() == BookStatus.RETURNED) {
            applicationFine(Loan);
        }
    }

    private void applicationFine(Loan Loan) {

        if (Loan.getReturned() != null && Loan.getDueDate() != null && Loan.getReturned().isAfter(Loan.getDueDate())) {
            BigDecimal amount = new BigDecimal("2.50");
            long days = ChronoUnit.DAYS.between(Loan.getDueDate(), Loan.getReturnDate());
            BigDecimal fine = amount.multiply(BigDecimal.valueOf(days));
        }

    }

}
