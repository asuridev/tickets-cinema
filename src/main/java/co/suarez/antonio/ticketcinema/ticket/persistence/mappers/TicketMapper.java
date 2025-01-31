package co.suarez.antonio.ticketcinema.ticket.persistence.mappers;

import co.suarez.antonio.ticketcinema.ticket.persistence.entities.TicketEntity;
import co.suarez.antonio.ticketcinema.ticket.services.dtos.CreateTicketDto;
import co.suarez.antonio.ticketcinema.ticket.services.dtos.ResponseTicketDto;
import co.suarez.antonio.ticketcinema.ticket.services.dtos.UpdateTicketDto;
import co.suarez.antonio.ticketcinema.ticket.services.dtos.TicketDto;



public interface TicketMapper {

    TicketDto toTicketDto(TicketEntity ticketEntity);

    ResponseTicketDto toResponseTicketDto(TicketDto userDto);

    TicketEntity toTicketEntity(CreateTicketDto createTicketDto);

    TicketEntity merge(UpdateTicketDto updateTicketDto, TicketEntity ticketEntity);
}

  