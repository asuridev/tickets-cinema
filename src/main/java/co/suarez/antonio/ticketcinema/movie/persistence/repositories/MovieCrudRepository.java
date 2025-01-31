package co.suarez.antonio.ticketcinema.movie.persistence.repositories;


import co.suarez.antonio.ticketcinema.movie.persistence.entities.MovieEntity;
import org.springframework.data.repository.CrudRepository;


public interface MovieCrudRepository extends CrudRepository <MovieEntity,String>{


}

  