package io.book.library.application.service.interfaces;

import io.book.library.application.dto.LoanDTO;
import io.book.library.domain.entities.Loan;

import java.util.List;
import java.util.Optional;

public interface LoanService {

    public LoanDTO createLoan(Loan Loan);

    public void deleteTransactionByID(Long transactionById);

    public List<Loan> findAll();

    public Optional<Loan> findByID(Long id);

    public LoanDTO updateByID(Long id, LoanDTO updateRequest);

    public void returnBook(Loan Loan);


}
