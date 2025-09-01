package io.book.library.application.mapper;

import io.book.library.application.dto.AuthorDTO;
import io.book.library.domain.entities.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface AuthorMapper {

    @Mapping(source = "authorID", target = "id")
    AuthorDTO authorToDTO(Author author);

    @Mapping(source = "id", target = "authorID")
    Author dtoToAuthor(AuthorDTO authorDTO);

    List<AuthorDTO> authorListToDTO(List<Author> author);

    void updateAuthorFromDTO(AuthorDTO authorDTO, @MappingTarget Author author);

}
