package co.suarez.antonio.ticketcinema.user.persistence.mappers;

import co.suarez.antonio.ticketcinema.user.persistence.entities.UserEntity;
import co.suarez.antonio.ticketcinema.user.services.dtos.CreateUserDto;
import co.suarez.antonio.ticketcinema.user.services.dtos.ResponseUserDto;
import co.suarez.antonio.ticketcinema.user.services.dtos.UpdateUserDto;
import co.suarez.antonio.ticketcinema.user.services.dtos.UserDto;


import java.util.List;

public interface UserMapper {

    UserDto toUserDto(UserEntity userEntity);

    ResponseUserDto toResponseUserDto(UserDto userDto);

    UserEntity toUserEntity(CreateUserDto createUserDto);

    UserEntity merge(UpdateUserDto updateUserDto, UserEntity userEntity);

}

  