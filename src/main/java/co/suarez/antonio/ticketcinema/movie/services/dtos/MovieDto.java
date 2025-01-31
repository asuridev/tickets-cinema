package co.suarez.antonio.ticketcinema.movie.services.dtos;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieDto {
  private String id;

  private String title;

  private String genre;

  private Double duration;


}

  