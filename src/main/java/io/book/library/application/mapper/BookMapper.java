package io.book.library.application.mapper;

import io.book.library.application.dto.BookDTO;
import io.book.library.domain.entities.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDTO bookToDTO(Book book);

    @Mapping(target = "id", ignore = true)
    void updateBookFromDTO(BookDTO bookDTO, @MappingTarget Book book);
}
