package co.suarez.antonio.ticketcinema.common.exceptions;

public class BadRequestException extends RuntimeException {
    public BadRequestException(){

    }
    public BadRequestException(String message) {
        super(message);
    }
}
  