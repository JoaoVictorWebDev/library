package io.book.library.application.mapper;

import io.book.library.application.dto.LoanDTO;
import io.book.library.domain.entities.Loan;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface LoanMapper
{
    LoanDTO userToDTO(Loan loan);
    void updateLoanFromDTO(LoanDTO loanDTO, @MappingTarget Loan loan);
}
