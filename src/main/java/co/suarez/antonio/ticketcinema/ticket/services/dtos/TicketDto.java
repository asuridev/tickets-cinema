package co.suarez.antonio.ticketcinema.ticket.services.dtos;

import co.suarez.antonio.ticketcinema.movie.persistence.entities.MovieEntity;
import co.suarez.antonio.ticketcinema.user.persistence.entities.UserEntity;
import lombok.*;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketDto {
  private String id;

  private String seat;

  private LocalDateTime startTime;

  private LocalDateTime endTime;

  private UserEntity user;

  private MovieEntity movie;

}

  