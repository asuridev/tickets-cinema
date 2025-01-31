package co.suarez.antonio.ticketcinema.user.persistence.repositories;


import co.suarez.antonio.ticketcinema.user.persistence.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;


public interface UserCrudRepository extends CrudRepository <UserEntity,String>{


}

  