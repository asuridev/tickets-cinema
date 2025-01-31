package co.suarez.antonio.ticketcinema.movie.services;

import co.suarez.antonio.ticketcinema.common.exceptions.NotFoundException;
import co.suarez.antonio.ticketcinema.movie.persistence.mappers.MovieMapper;
import co.suarez.antonio.ticketcinema.movie.services.dtos.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class MovieService {

    private final MovieServiceRepository movieServiceRepository;
    private final MovieMapper movieMapper;

    public ResponseMovieDto create(CreateMovieDto createMovieDto){
        MovieDto movie = movieServiceRepository.createMovie(createMovieDto);
        return this.movieMapper.toResponseMovieDto(movie);
    }

    public Page<ResponseMovieDto> findAll(int page, int limit, String sortBy){
        Page<MovieDto> movies = movieServiceRepository.findAllMovies(page, limit ,sortBy);
        return  movies.map(movieMapper::toResponseMovieDto);
    }

    public ResponseMovieDto findOne(String id){
        MovieDto movie = movieServiceRepository.findOneMovie(id).orElseThrow(NotFoundException::new);
        return this.movieMapper.toResponseMovieDto(movie);
    }

    public ResponseMovieDto update(UpdateMovieDto updateMovieDto, String id){
        MovieDto movie = movieServiceRepository.updateMovie(updateMovieDto, id).orElseThrow(NotFoundException::new);
        return this.movieMapper.toResponseMovieDto(movie);
    }

    public void remove(String id){
        this.findOne(id);
        movieServiceRepository.removeMovie(id);
    }
}

  