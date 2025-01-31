package co.suarez.antonio.ticketcinema.ticket.persistence;

import co.suarez.antonio.ticketcinema.ticket.persistence.entities.TicketEntity;
import co.suarez.antonio.ticketcinema.ticket.persistence.mappers.TicketMapper;
import co.suarez.antonio.ticketcinema.ticket.persistence.repositories.TicketCrudRepository;
import co.suarez.antonio.ticketcinema.ticket.persistence.repositories.TicketPaginationRepository;
import co.suarez.antonio.ticketcinema.ticket.services.TicketServiceRepository;
import co.suarez.antonio.ticketcinema.ticket.services.dtos.CreateTicketDto;
import co.suarez.antonio.ticketcinema.ticket.services.dtos.UpdateTicketDto;
import co.suarez.antonio.ticketcinema.ticket.services.dtos.TicketDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class TicketRepositoryImpl implements TicketServiceRepository {

    private final TicketCrudRepository ticketCrudRepository;
    private final TicketPaginationRepository ticketPaginationRepository;
    private final TicketMapper ticketMapper;

    @Override
    public TicketDto createTicket(CreateTicketDto createTicketDto) {
        TicketEntity newTicket = this.ticketMapper.toTicketEntity(createTicketDto);
        TicketEntity responseQuery = this.ticketCrudRepository.save(newTicket);
        return ticketMapper.toTicketDto(responseQuery);
    }

    @Override
    public Page<TicketDto> findAllTickets(int page, int limit, String sortBy) {
        Pageable pageRequest = PageRequest.of(page, limit, Sort.by(sortBy));
        return this.ticketPaginationRepository.findAll(pageRequest).map(this.ticketMapper::toTicketDto);
    }

    @Override
    public Optional<TicketDto> findOneTicket(String id) {
        return this.ticketCrudRepository.findById(id).map(this.ticketMapper::toTicketDto);
    }

    @Override
    public Optional<TicketDto> updateTicket(UpdateTicketDto updateTicketDto, String id) {
        TicketEntity ticketEntityById = this.ticketCrudRepository.findById(id).orElse(null);
        if(ticketEntityById == null) return Optional.empty();;
        TicketEntity ticketEntityUpdate = this.ticketMapper.merge(updateTicketDto, ticketEntityById);
        TicketEntity responseQuery = this.ticketCrudRepository.save(ticketEntityUpdate);
        return Optional.of(ticketMapper.toTicketDto(responseQuery));
    }

    @Override
    public void removeTicket(String id) {
        this.ticketCrudRepository.deleteById(id);
    }
}

  