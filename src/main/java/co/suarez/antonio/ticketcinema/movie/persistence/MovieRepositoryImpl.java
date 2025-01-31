package co.suarez.antonio.ticketcinema.movie.persistence;

import co.suarez.antonio.ticketcinema.movie.persistence.entities.MovieEntity;
import co.suarez.antonio.ticketcinema.movie.persistence.mappers.MovieMapper;
import co.suarez.antonio.ticketcinema.movie.persistence.repositories.MovieCrudRepository;
import co.suarez.antonio.ticketcinema.movie.persistence.repositories.MoviePaginationRepository;
import co.suarez.antonio.ticketcinema.movie.services.MovieServiceRepository;
import co.suarez.antonio.ticketcinema.movie.services.dtos.CreateMovieDto;
import co.suarez.antonio.ticketcinema.movie.services.dtos.UpdateMovieDto;
import co.suarez.antonio.ticketcinema.movie.services.dtos.MovieDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class MovieRepositoryImpl implements MovieServiceRepository {

    private final MovieCrudRepository movieCrudRepository;
    private final MoviePaginationRepository moviePaginationRepository;
    private final MovieMapper movieMapper;

    @Override
    public MovieDto createMovie(CreateMovieDto createMovieDto) {
        MovieEntity newMovie = this.movieMapper.toMovieEntity(createMovieDto);
        MovieEntity responseQuery = this.movieCrudRepository.save(newMovie);
        return movieMapper.toMovieDto(responseQuery);
    }

    @Override
    public Page<MovieDto> findAllMovies(int page, int limit, String sortBy) {
        Pageable pageRequest = PageRequest.of(page, limit, Sort.by(sortBy));
        return this.moviePaginationRepository.findAll(pageRequest).map(this.movieMapper::toMovieDto);
    }

    @Override
    public Optional<MovieDto> findOneMovie(String id) {
        return this.movieCrudRepository.findById(id).map(this.movieMapper::toMovieDto);
    }

    @Override
    public Optional<MovieDto> updateMovie(UpdateMovieDto updateMovieDto, String id) {
        MovieEntity movieEntityById = this.movieCrudRepository.findById(id).orElse(null);
        if(movieEntityById == null) return Optional.empty();;
        MovieEntity movieEntityUpdate = this.movieMapper.merge(updateMovieDto, movieEntityById);
        MovieEntity responseQuery = this.movieCrudRepository.save(movieEntityUpdate);
        return Optional.of(movieMapper.toMovieDto(responseQuery));
    }

    @Override
    public void removeMovie(String id) {
        this.movieCrudRepository.deleteById(id);
    }
}

  