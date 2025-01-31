package co.suarez.antonio.ticketcinema.movie.services.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateMovieDto {
  @NotNull
  private String title;
  @NotNull
  private String genre;
  @NotNull
  private Double duration;
}

  