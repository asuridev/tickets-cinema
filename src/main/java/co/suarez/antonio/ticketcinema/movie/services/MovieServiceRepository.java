package co.suarez.antonio.ticketcinema.movie.services;

import co.suarez.antonio.ticketcinema.movie.services.dtos.CreateMovieDto;
import co.suarez.antonio.ticketcinema.movie.services.dtos.UpdateMovieDto;
import co.suarez.antonio.ticketcinema.movie.services.dtos.MovieDto;
import org.springframework.data.domain.Page;
import java.util.Optional;

public interface MovieServiceRepository {

    public MovieDto createMovie(CreateMovieDto createMovieDto);

    public Page<MovieDto> findAllMovies(int page, int limit, String sortBy);

    public Optional<MovieDto> findOneMovie(String id);

    public Optional<MovieDto> updateMovie(UpdateMovieDto updateMovieDto, String id);

    public void removeMovie(String id);
}

  