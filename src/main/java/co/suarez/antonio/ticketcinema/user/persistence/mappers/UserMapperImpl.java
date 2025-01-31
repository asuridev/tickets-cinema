package co.suarez.antonio.ticketcinema.user.persistence.mappers;

import co.suarez.antonio.ticketcinema.user.persistence.entities.UserEntity;
import co.suarez.antonio.ticketcinema.user.services.dtos.CreateUserDto;
import co.suarez.antonio.ticketcinema.user.services.dtos.ResponseUserDto;
import co.suarez.antonio.ticketcinema.user.services.dtos.UpdateUserDto;
import co.suarez.antonio.ticketcinema.user.services.dtos.UserDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserMapperImpl implements UserMapper{
  @Override
  public UserDto toUserDto(UserEntity userEntity) {
    return UserDto.builder()
            .id(userEntity.getId())
            .phone(userEntity.getPhone())
            .email(userEntity.getEmail())
            .name(userEntity.getName())
            .lastname(userEntity.getLastname())
            .tickets(userEntity.getTickets())
            .build();
  }

  @Override
  public ResponseUserDto toResponseUserDto(UserDto userDto) {
    return ResponseUserDto.builder()
            .id(userDto.getId())
            .phone(userDto.getPhone())
            .email(userDto.getEmail())
            .name(userDto.getName())
            .lastname(userDto.getLastname())
            .tickets(userDto.getTickets())
            .build();
  }

  @Override
  public UserEntity toUserEntity(CreateUserDto createUserDto) {
    return new UserEntity(
            null,
            createUserDto.getName(),
            createUserDto.getLastname(),
            createUserDto.getEmail(),
            createUserDto.getPhone(),
            new ArrayList<>()
    );
  }

  @Override
  public UserEntity merge(UpdateUserDto updateUserDto, UserEntity userEntity) {
    String name = updateUserDto.getName();
    String lastname = updateUserDto.getLastname();
    String email =  updateUserDto.getEmail();
    String phone = updateUserDto.getPhone();

    if(name == null){
      name = userEntity.getName();
    }
    if(lastname == null){
      lastname = userEntity.getLastname();
    }
    if(email == null){
      email = userEntity.getEmail();
    }
    if(phone == null){
      phone = userEntity.getPhone();
    }
    return new UserEntity(
            userEntity.getId(),
            name,
            lastname,
            email,
            phone,
            userEntity.getTickets()
    );
  }

}
