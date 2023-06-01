package com.san4n.ptpshopping.mapper;

import com.san4n.ptpshopping.dto.RegistrationDTO;
import com.san4n.ptpshopping.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RegistrationDTOMapper {

    RegistrationDTOMapper INSTANCE = Mappers.getMapper(RegistrationDTOMapper.class);

    User getUser(RegistrationDTO registrationDTO);

}
