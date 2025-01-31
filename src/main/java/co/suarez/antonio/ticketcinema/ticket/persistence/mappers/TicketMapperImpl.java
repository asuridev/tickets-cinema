package co.suarez.antonio.ticketcinema.ticket.persistence.mappers;

import co.suarez.antonio.ticketcinema.common.exceptions.BadRequestException;
import co.suarez.antonio.ticketcinema.movie.persistence.entities.MovieEntity;
import co.suarez.antonio.ticketcinema.movie.persistence.mappers.MovieMapper;
import co.suarez.antonio.ticketcinema.movie.services.MovieServiceRepository;
import co.suarez.antonio.ticketcinema.movie.services.dtos.MovieDto;
import co.suarez.antonio.ticketcinema.ticket.persistence.entities.TicketEntity;
import co.suarez.antonio.ticketcinema.ticket.services.dtos.CreateTicketDto;
import co.suarez.antonio.ticketcinema.ticket.services.dtos.ResponseTicketDto;
import co.suarez.antonio.ticketcinema.ticket.services.dtos.TicketDto;
import co.suarez.antonio.ticketcinema.ticket.services.dtos.UpdateTicketDto;
import co.suarez.antonio.ticketcinema.user.persistence.entities.UserEntity;
import co.suarez.antonio.ticketcinema.user.persistence.mappers.UserMapper;
import co.suarez.antonio.ticketcinema.user.services.UserServiceRepository;
import co.suarez.antonio.ticketcinema.user.services.dtos.UserDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TicketMapperImpl implements TicketMapper {
  private final UserServiceRepository userServiceRepository;
  private final MovieServiceRepository movieServiceRepository;


  public TicketMapperImpl(UserServiceRepository userServiceRepository, MovieServiceRepository movieServiceRepository, MovieMapper movieMapper, UserMapper userMapper) {
    this.userServiceRepository = userServiceRepository;
    this.movieServiceRepository = movieServiceRepository;
  }

  @Override
  public TicketDto toTicketDto(TicketEntity ticketEntity) {
    return TicketDto.builder()
            .id(ticketEntity.getId())
            .seat(ticketEntity.getSeat())
            .endTime(ticketEntity.getEndTime())
            .startTime(ticketEntity.getStartTime())
            .movie(ticketEntity.getMovie())
            .user(ticketEntity.getUser())
            .build();
  }

  @Override
  public ResponseTicketDto toResponseTicketDto(TicketDto ticketDto) {
    return ResponseTicketDto.builder()
            .id(ticketDto.getId())
            .seat(ticketDto.getSeat())
            .endTime(ticketDto.getEndTime())
            .startTime(ticketDto.getStartTime())
            .user(ticketDto.getUser())
            .movie(ticketDto.getMovie())
            .build();
  }

  @Override
  public TicketEntity toTicketEntity(CreateTicketDto createTicketDto) {
    UserDto user = this.userServiceRepository.findOneUser(createTicketDto.getUserId()).orElseThrow(()-> new BadRequestException("userId not found"));
    MovieDto movie = this.movieServiceRepository.findOneMovie(createTicketDto.getMovieId()).orElseThrow(()->new BadRequestException("movieId not found"));

    return new TicketEntity(
            null,
            createTicketDto.getSeat(),
            createTicketDto.getStartTime(),
            createTicketDto.getEndTime(),
            new UserEntity(
                 user.getId(),
                 user.getName(),
                 user.getLastname(),
                 user.getEmail(),
                 user.getPhone()
            ),
            new MovieEntity(
                   movie.getId(),
                   movie.getTitle(),
                   movie.getGenre(),
                   movie.getDuration()
            )
    );
  }

  @Override
  public TicketEntity merge(UpdateTicketDto updateTicketDto, TicketEntity ticketEntity) {
    String seat = updateTicketDto.getSeat();
    LocalDateTime startTime = updateTicketDto.getStartTime();
    LocalDateTime endTime =  updateTicketDto.getEndTime();


    if(seat == null){
      seat = ticketEntity.getSeat();
    }
    if(startTime == null){
      startTime = ticketEntity.getStartTime();
    }
    if(endTime == null){
      endTime = ticketEntity.getEndTime();
    }

    return new TicketEntity(
            ticketEntity.getId(),
            seat,
            startTime,
            endTime,
            ticketEntity.getUser(),
            ticketEntity.getMovie()
    );
  }
}
