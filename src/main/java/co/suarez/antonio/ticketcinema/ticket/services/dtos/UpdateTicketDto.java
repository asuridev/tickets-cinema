package co.suarez.antonio.ticketcinema.ticket.services.dtos;


import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateTicketDto {

  private String seat;

  private LocalDateTime startTime;

  private LocalDateTime endTime;

}

  