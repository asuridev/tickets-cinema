package co.suarez.antonio.ticketcinema.user.services.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUserDto {

  @NotNull
  private String name;

  @NotNull
  private String lastname;

  @NotNull
  private String email;

  @NotNull
  private String phone;

}

  