package co.suarez.antonio.ticketcinema.user.persistence.repositories;


import co.suarez.antonio.ticketcinema.user.persistence.entities.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface UserPaginationRepository extends PagingAndSortingRepository <UserEntity,String>{


}

  