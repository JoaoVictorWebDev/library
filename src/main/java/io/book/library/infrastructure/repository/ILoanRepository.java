package io.book.library.infrastructure.repository;

import io.book.library.application.dto.LoanDTO;
import io.book.library.domain.entities.Loan;
import org.mapstruct.MappingTarget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILoanRepository extends JpaRepository<Loan, Long>
{
}
