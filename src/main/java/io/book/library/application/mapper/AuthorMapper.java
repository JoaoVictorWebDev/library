package io.book.library.application.mapper;

import io.book.library.application.dto.AuthorDTO;
import io.book.library.domain.entities.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorDTO authorToDTO(Author author);

    List<AuthorDTO> authorListToDTO(List<Author> author);

    @Mapping(target = "id", ignore = true)
    void updateAuthorFromDTO(AuthorDTO authorDTO, @MappingTarget Author author);

}
