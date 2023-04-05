package com.san4N.PTPShoping.mapper;

import com.san4N.PTPShoping.dto.UserDTO;
import com.san4N.PTPShoping.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserDTOMapper {

    UserDTOMapper INSTANCE = Mappers.getMapper(UserDTOMapper.class);

    UserDTO getUserDTO(User user);
}
