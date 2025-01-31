package co.suarez.antonio.ticketcinema.movie.persistence.repositories;


import co.suarez.antonio.ticketcinema.movie.persistence.entities.MovieEntity;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface MoviePaginationRepository extends PagingAndSortingRepository <MovieEntity,String>{


}

  