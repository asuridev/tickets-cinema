package co.suarez.antonio.ticketcinema.ticket.controller;

import co.suarez.antonio.ticketcinema.ticket.services.TicketService;
import co.suarez.antonio.ticketcinema.ticket.services.dtos.CreateTicketDto;
import co.suarez.antonio.ticketcinema.ticket.services.dtos.UpdateTicketDto;
import co.suarez.antonio.ticketcinema.ticket.services.dtos.ResponseTicketDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("ticket")
public class TicketController {

    private final TicketService ticketService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseTicketDto create(@Valid @RequestBody CreateTicketDto createTicketDto){
       return  this.ticketService.create(createTicketDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Page<ResponseTicketDto> findAll(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false,defaultValue = "100") int limit,
            @RequestParam(required = false,defaultValue = "id") String sortBy
    ){
        return this.ticketService.findAll(page, limit, sortBy);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ResponseTicketDto findOne(@PathVariable("id") String id){
        return this.ticketService.findOne(id);
    }
    
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{id}")
    public ResponseTicketDto update(@Valid @RequestBody UpdateTicketDto updateTicketDto, @PathVariable("id") String id){
        return this.ticketService.update(updateTicketDto, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") String id){
        this.ticketService.remove(id);
    }

}

  