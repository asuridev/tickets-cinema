package co.suarez.antonio.ticketcinema.movie.controller;

import co.suarez.antonio.ticketcinema.movie.services.MovieService;
import co.suarez.antonio.ticketcinema.movie.services.dtos.CreateMovieDto;
import co.suarez.antonio.ticketcinema.movie.services.dtos.UpdateMovieDto;
import co.suarez.antonio.ticketcinema.movie.services.dtos.ResponseMovieDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("movie")
public class MovieController {

    private final MovieService movieService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseMovieDto create(@Valid @RequestBody CreateMovieDto createMovieDto){
       return  this.movieService.create(createMovieDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Page<ResponseMovieDto> findAll(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false,defaultValue = "100") int limit,
            @RequestParam(required = false,defaultValue = "id") String sortBy
    ){
        return this.movieService.findAll(page, limit, sortBy);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ResponseMovieDto findOne(@PathVariable("id") String id){
        return this.movieService.findOne(id);
    }
    
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{id}")
    public ResponseMovieDto update(@Valid @RequestBody UpdateMovieDto updateMovieDto, @PathVariable("id") String id){
        return this.movieService.update(updateMovieDto, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") String id){
        this.movieService.remove(id);
    }

}

  