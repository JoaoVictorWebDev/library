package io.book.library.application.service;

import io.book.library.application.dto.LoanDTO;
import io.book.library.application.mapper.LoanMapper;
import io.book.library.domain.entities.Loan;
import io.book.library.domain.enums.BookStatus;
import io.book.library.infrastructure.config.EntityNotFoundException;
import io.book.library.infrastructure.repository.ILoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class LoanServiceImpl implements LoanService
{
    @Autowired
    private ILoanRepository repository;

    @Autowired
    private LoanMapper loanMapper;

    public LoanDTO createLoan(Loan Loan)
    {
        Loan savedLoan = repository.save(Loan);
        return loanMapper.userToDTO(savedLoan);
    }

    public LoanDTO deleteTransactionByID(Long transactionById)
    {
        Loan savedLoan = repository.deleteTransactionByID(transactionById);
        return loanMapper.userToDTO(savedLoan);
    }
    public List<Loan> findAll()
    {
        return repository.findAll();
    }
    public Optional<Loan> findByID(Long id)
    {
        return Optional.ofNullable(repository.findById(id).orElse(null));
    }
    public LoanDTO updateByID(Long id, LoanDTO updateRequest)
    {
        Loan existingLoan = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Loan not found"));
        loanMapper.updateLoanFromDTO(updateRequest, existingLoan);
        return loanMapper.userToDTO(repository.save(existingLoan));
    }

    public void returnBook(Loan Loan)
    {
        if(Loan.getReturned().isAfter(Loan.getDueDate()) && Loan.getBookStatus() == BookStatus.RETURNED)
        {
            applicationFine(Loan);
        }
    }

    private void applicationFine(Loan Loan) {
        if (Loan.getReturned() != null && Loan.getDueDate() != null && Loan.getReturned().isAfter(Loan.getDueDate())) {
            BigDecimal amount = new BigDecimal("2.50");
            Long days = ChronoUnit.DAYS.between(Loan.getDueDate() , Loan.getReturnDate());
            BigDecimal fine = amount.multiply(BigDecimal.valueOf(days));
        }
    }

}
