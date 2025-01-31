package co.suarez.antonio.ticketcinema.movie.persistence.mappers;

import co.suarez.antonio.ticketcinema.movie.persistence.entities.MovieEntity;
import co.suarez.antonio.ticketcinema.movie.services.dtos.CreateMovieDto;
import co.suarez.antonio.ticketcinema.movie.services.dtos.MovieDto;
import co.suarez.antonio.ticketcinema.movie.services.dtos.ResponseMovieDto;
import co.suarez.antonio.ticketcinema.movie.services.dtos.UpdateMovieDto;


import java.util.List;

public interface MovieMapper {

    MovieDto toMovieDto(MovieEntity movieEntity);

    ResponseMovieDto toResponseMovieDto(MovieDto userDto);

    MovieEntity toMovieEntity(CreateMovieDto createMovieDto);

    MovieEntity merge(UpdateMovieDto updateMovieDto, MovieEntity movieEntity);

}

  