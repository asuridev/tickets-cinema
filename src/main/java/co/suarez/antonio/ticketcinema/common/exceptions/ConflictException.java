package co.suarez.antonio.ticketcinema.common.exceptions;

public class ConflictException extends RuntimeException {
    public ConflictException(){

    }
    public ConflictException(String message) {
        super(message);
    }
}
  