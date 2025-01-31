package co.suarez.antonio.ticketcinema.movie.persistence.mappers;

import co.suarez.antonio.ticketcinema.movie.persistence.entities.MovieEntity;
import co.suarez.antonio.ticketcinema.movie.services.dtos.CreateMovieDto;
import co.suarez.antonio.ticketcinema.movie.services.dtos.MovieDto;
import co.suarez.antonio.ticketcinema.movie.services.dtos.ResponseMovieDto;
import co.suarez.antonio.ticketcinema.movie.services.dtos.UpdateMovieDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MovieMapperImpl implements MovieMapper {
  
  @Override
  public MovieDto toMovieDto(MovieEntity movieEntity) {
    return MovieDto.builder()
            .id(movieEntity.getId())
            .title(movieEntity.getTitle())
            .genre(movieEntity.getGenre())
            .duration(movieEntity.getDuration())
            .build();
  }

  @Override
  public ResponseMovieDto toResponseMovieDto(MovieDto movieDto) {
    return ResponseMovieDto.builder()
            .id(movieDto.getId())
            .title(movieDto.getTitle())
            .genre(movieDto.getGenre())
            .duration(movieDto.getDuration())
            .build();
  }

  @Override
  public MovieEntity toMovieEntity(CreateMovieDto createMovieDto) {
    return new MovieEntity(
            null,
            createMovieDto.getTitle(),
            createMovieDto.getGenre(),
            createMovieDto.getDuration()
    );
  }

  @Override
  public MovieEntity merge(UpdateMovieDto updateMovieDto, MovieEntity movieEntity) {
    String title = updateMovieDto.getTitle();
    String genre = updateMovieDto.getGenre();
    Double duration =  updateMovieDto.getDuration();


    if(title == null){
      title = movieEntity.getTitle();
    }
    if(genre == null){
      genre = movieEntity.getGenre();
    }
    if(duration == null){
      duration = movieEntity.getDuration();
    }

    return new MovieEntity(
            movieEntity.getId(),
            title,
            genre,
            duration
    );
  }
}
