package co.suarez.antonio.ticketcinema.ticket.services.dtos;

import co.suarez.antonio.ticketcinema.movie.persistence.entities.MovieEntity;
import co.suarez.antonio.ticketcinema.movie.services.dtos.CreateMovieDto;
import co.suarez.antonio.ticketcinema.user.persistence.entities.UserEntity;
import co.suarez.antonio.ticketcinema.user.services.dtos.CreateUserDto;
import lombok.*;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateTicketDto {

  private String id;

  private String seat;

  private LocalDateTime startTime;

  private LocalDateTime endTime;

  private String userId ;

  private String movieId;
}

  