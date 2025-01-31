package co.suarez.antonio.ticketcinema.ticket.persistence.repositories;


import co.suarez.antonio.ticketcinema.ticket.persistence.entities.TicketEntity;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface TicketPaginationRepository extends PagingAndSortingRepository <TicketEntity,String>{


}

  