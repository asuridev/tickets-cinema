package co.suarez.antonio.ticketcinema.common.exceptions;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorMessageSimple extends ErrorMessage {
    String message;
    int statusCode;
}
  