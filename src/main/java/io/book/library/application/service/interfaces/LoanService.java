package io.book.library.application.service.interfaces;

import io.book.library.application.dto.LoanDTO;
import io.book.library.domain.entities.Loan;

import java.util.List;
import java.util.Optional;

public interface LoanService {

     LoanDTO createLoan(Loan Loan);

     void deleteTransactionByID(Long transactionById);

     List<Loan> findAll();

     Optional<Loan> findByID(Long id);

     LoanDTO updateByID(Long id, LoanDTO updateRequest);

     void returnBook(Loan Loan);


}
