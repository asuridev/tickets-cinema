package co.suarez.antonio.ticketcinema.common.exceptions;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorMessageShort extends ErrorMessage {
    String message;
    String error;
    int statusCode;
}

  