package co.suarez.antonio.ticketcinema.common.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(){

    }
    public NotFoundException(String message) {
        super(message);
    }
}
  