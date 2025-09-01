package io.book.library.application.mapper;

import io.book.library.application.dto.UserDTO;
import io.book.library.domain.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")

public interface UserMapper {
    UserDTO userToDTO(User user);

    List<UserDTO> userListToDTO(List<User> user);

    void updateUserFromDTO(UserDTO userDTO, @MappingTarget User user);
}
