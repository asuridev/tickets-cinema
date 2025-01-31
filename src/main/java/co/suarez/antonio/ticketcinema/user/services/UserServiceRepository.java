package co.suarez.antonio.ticketcinema.user.services;

import co.suarez.antonio.ticketcinema.user.services.dtos.CreateUserDto;
import co.suarez.antonio.ticketcinema.user.services.dtos.UpdateUserDto;
import co.suarez.antonio.ticketcinema.user.services.dtos.UserDto;
import org.springframework.data.domain.Page;
import java.util.Optional;

public interface UserServiceRepository {

    public UserDto createUser(CreateUserDto createUserDto);

    public Page<UserDto> findAllUsers(int page, int limit, String sortBy);

    public Optional<UserDto> findOneUser(String id);

    public Optional<UserDto> updateUser(UpdateUserDto updateUserDto, String id);

    public void removeUser(String id);
}

  