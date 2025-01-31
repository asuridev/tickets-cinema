package co.suarez.antonio.ticketcinema.ticket.services.dtos;

import co.suarez.antonio.ticketcinema.movie.persistence.entities.MovieEntity;
import co.suarez.antonio.ticketcinema.movie.services.dtos.CreateMovieDto;
import co.suarez.antonio.ticketcinema.user.persistence.entities.UserEntity;
import co.suarez.antonio.ticketcinema.user.services.dtos.CreateUserDto;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateTicketDto {

  @NotNull
  private String seat;

  @NotNull
  private LocalDateTime startTime;

  @NotNull
  private LocalDateTime endTime;

  @NotNull
  private String userId ;

  @NotNull
  private String movieId;
}

  