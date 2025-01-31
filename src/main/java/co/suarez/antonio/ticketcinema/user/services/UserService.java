package co.suarez.antonio.ticketcinema.user.services;

import co.suarez.antonio.ticketcinema.common.exceptions.NotFoundException;
import co.suarez.antonio.ticketcinema.user.persistence.mappers.UserMapper;
import co.suarez.antonio.ticketcinema.user.services.dtos.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class UserService {

    private final UserServiceRepository userServiceRepository;
    private final UserMapper userMapper;

    public ResponseUserDto create(CreateUserDto createUserDto){
        UserDto user = userServiceRepository.createUser(createUserDto);
        return this.userMapper.toResponseUserDto(user);
    }

    public Page<ResponseUserDto> findAll(int page, int limit, String sortBy){
        Page<UserDto> users = userServiceRepository.findAllUsers(page, limit ,sortBy);
        return  users.map(userMapper::toResponseUserDto);
    }

    public ResponseUserDto findOne(String id){
        UserDto user = userServiceRepository.findOneUser(id).orElseThrow(NotFoundException::new);
        return this.userMapper.toResponseUserDto(user);
    }

    public ResponseUserDto update(UpdateUserDto updateUserDto, String id){
        UserDto user = userServiceRepository.updateUser(updateUserDto, id).orElseThrow(NotFoundException::new);
        return this.userMapper.toResponseUserDto(user);
    }

    public void remove(String id){
        this.findOne(id);
        userServiceRepository.removeUser(id);
    }
}

  