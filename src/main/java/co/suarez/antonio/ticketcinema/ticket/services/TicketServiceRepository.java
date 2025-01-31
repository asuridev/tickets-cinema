package co.suarez.antonio.ticketcinema.ticket.services;

import co.suarez.antonio.ticketcinema.ticket.services.dtos.CreateTicketDto;
import co.suarez.antonio.ticketcinema.ticket.services.dtos.UpdateTicketDto;
import co.suarez.antonio.ticketcinema.ticket.services.dtos.TicketDto;
import org.springframework.data.domain.Page;
import java.util.Optional;

public interface TicketServiceRepository {

    public TicketDto createTicket(CreateTicketDto createTicketDto);

    public Page<TicketDto> findAllTickets(int page, int limit, String sortBy);

    public Optional<TicketDto> findOneTicket(String id);

    public Optional<TicketDto> updateTicket(UpdateTicketDto updateTicketDto, String id);

    public void removeTicket(String id);
}

  