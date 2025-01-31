package co.suarez.antonio.ticketcinema.user.services.dtos;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateUserDto {
  private String name;

  private String lastname;

  private String email;

  private String phone;

}

  