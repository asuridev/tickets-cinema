package co.suarez.antonio.ticketcinema.ticket.services;

import co.suarez.antonio.ticketcinema.common.exceptions.NotFoundException;
import co.suarez.antonio.ticketcinema.ticket.persistence.mappers.TicketMapper;
import co.suarez.antonio.ticketcinema.ticket.services.dtos.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class TicketService {

    private final TicketServiceRepository ticketServiceRepository;
    private final TicketMapper ticketMapper;

    public ResponseTicketDto create(CreateTicketDto createTicketDto){
        TicketDto ticket = ticketServiceRepository.createTicket(createTicketDto);
        return this.ticketMapper.toResponseTicketDto(ticket);
    }

    public Page<ResponseTicketDto> findAll(int page, int limit, String sortBy){
        Page<TicketDto> tickets = ticketServiceRepository.findAllTickets(page, limit ,sortBy);
        return  tickets.map(ticketMapper::toResponseTicketDto);
    }

    public ResponseTicketDto findOne(String id){
        TicketDto ticket = ticketServiceRepository.findOneTicket(id).orElseThrow(NotFoundException::new);
        return this.ticketMapper.toResponseTicketDto(ticket);
    }

    public ResponseTicketDto update(UpdateTicketDto updateTicketDto, String id){
        TicketDto ticket = ticketServiceRepository.updateTicket(updateTicketDto, id).orElseThrow(NotFoundException::new);
        return this.ticketMapper.toResponseTicketDto(ticket);
    }

    public void remove(String id){
        this.findOne(id);
        ticketServiceRepository.removeTicket(id);
    }
}

  