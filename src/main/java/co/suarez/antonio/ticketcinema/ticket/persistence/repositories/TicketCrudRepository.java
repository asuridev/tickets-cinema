package co.suarez.antonio.ticketcinema.ticket.persistence.repositories;


import co.suarez.antonio.ticketcinema.ticket.persistence.entities.TicketEntity;
import org.springframework.data.repository.CrudRepository;


public interface TicketCrudRepository extends CrudRepository <TicketEntity,String>{


}

  