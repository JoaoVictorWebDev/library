package io.book.library.application.mapper;

import io.book.library.application.dto.BookDTO;
import io.book.library.domain.entities.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface BookMapper {

    default Optional<BookDTO> map(Optional<Book> optionalBook) {
        return optionalBook.map(this::bookToDTO);
    }

    @Mapping(source = "id", target = "id")
    BookDTO bookToDTO(Book book);

    @Mapping(target = "id", ignore = true)
    void updateBookFromDTO(BookDTO bookDTO, @MappingTarget Book book);

    @Mapping(source = "id", target = "id")
    Book toEntity(BookDTO bookDTO);

}
