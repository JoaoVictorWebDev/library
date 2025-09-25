package io.book.library.api;

import io.book.library.application.dto.LoanDTO;
import io.book.library.application.service.interfaces.LoanService;
import io.book.library.domain.entities.Loan;
import io.book.library.infrastructure.repository.ILoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/library/loan")
public class LoanController {

    @Autowired
    private LoanService service;

    @PostMapping("createLoan")
    public ResponseEntity<LoanDTO> createLoan(@RequestBody Loan loan){
        LoanDTO loanDTO = service.createLoan(loan);
        return ResponseEntity.ok(loanDTO);
    }
}
