package com.san4N.PTPShoping.mapper;

import com.san4N.PTPShoping.dto.RegistrationDTO;
import com.san4N.PTPShoping.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RegistrationDTOMapper {

    RegistrationDTOMapper INSTANCE = Mappers.getMapper(RegistrationDTOMapper.class);

    User getUser(RegistrationDTO registrationDTO);

}
