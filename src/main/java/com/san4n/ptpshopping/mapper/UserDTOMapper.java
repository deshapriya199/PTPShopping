package com.san4n.ptpshopping.mapper;

import com.san4n.ptpshopping.dto.UserDTO;
import com.san4n.ptpshopping.entity.core.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserDTOMapper {

    UserDTOMapper INSTANCE = Mappers.getMapper(UserDTOMapper.class);


    @Mapping(source = "username", target = "userName")
    UserDTO getUserDTOFromUser(User user);

    @Mapping(target = "id", ignore = true)
    void getUserFromUserDTO(UserDTO userDTO, @MappingTarget User user);
}
