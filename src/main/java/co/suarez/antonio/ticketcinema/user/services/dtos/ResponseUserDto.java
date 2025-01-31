package co.suarez.antonio.ticketcinema.user.services.dtos;

import co.suarez.antonio.ticketcinema.ticket.persistence.entities.TicketEntity;
import lombok.*;
import java.util.List;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseUserDto {
  private String id;

  private String name;

  private String lastname;

  private String email;

  private String phone;

  private List<TicketEntity> tickets;
}

  