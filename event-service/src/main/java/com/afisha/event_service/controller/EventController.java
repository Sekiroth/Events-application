package com.afisha.event_service.controller;

import com.afisha.event_service.config.response.ResponseHandler;
import com.afisha.event_service.dao.entity.ConcertEvent;
import com.afisha.event_service.dao.entity.FilmEvent;
import com.afisha.event_service.dto.CreationEvent;
import com.afisha.event_service.dao.entity.Event;
import com.afisha.event_service.dao.entity.enums.Type;
import com.afisha.event_service.service.event.ConcertService;
import com.afisha.event_service.converter.EventConverter;
import com.afisha.event_service.service.event.FilmService;
import com.afisha.event_service.service.pagination.ResponsePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/afisha/event")
public class EventController {

    @Autowired
    ConcertService concertService;
    @Autowired
    FilmService filmService;
    @Autowired
    EventConverter converter;

    @PostMapping("/{type}")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody CreationEvent event, @PathVariable Type type) {
        switch(type) {
            case FILMS -> {
                FilmEvent filmEvent = converter.convertToFilm(event);
                filmService.save(filmEvent);
            }
            case CONCERTS -> {
                ConcertEvent concertEvent = converter.convertToConcert(event);
                concertService.save(concertEvent);
            }
            default -> throw new IllegalArgumentException("Such type does not exist");
        }
    }

    @GetMapping("/{type}")
    public ResponseEntity<?> getALl(@PathVariable Type type,
                                         @RequestParam(defaultValue = "0") Integer page,
                                         @RequestParam(defaultValue = "25") Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        ResponsePage responsePage;
        switch(type) {
            case FILMS -> {
                Page<? extends Event> all = filmService.findAll(pageRequest);
                responsePage = new ResponsePage(page, size, all.getTotalPages(), (int) all.getTotalElements(),
                                all.isFirst(), all.getNumberOfElements(), all.isLast(), all.stream().toList());
            }
            case CONCERTS -> {
                Page<? extends Event> all = concertService.findAll(pageRequest);
                responsePage = new ResponsePage(page, size, all.getTotalPages(), (int) all.getTotalElements(),
                        all.isFirst(), all.getNumberOfElements(), all.isLast(), all.stream().toList());
            }
            default -> throw new IllegalArgumentException("Such type does not exist");
        }
        return ResponseHandler.generateResponse(responsePage);
    }

    @GetMapping("/{type}/{uuid}")
    public ResponseEntity<?> findOne(@PathVariable Type type, @PathVariable UUID uuid) {
        return switch(type) {
            case FILMS -> ResponseEntity.ok(filmService.findOne(uuid));
            case CONCERTS -> ResponseEntity.ok(concertService.findOne(uuid));
            default -> throw new IllegalArgumentException("Such type does not exist");
        };
    }

    @PutMapping("/{type}/{uuid}/dt_update/{dt_update}")
    public void update(@PathVariable Type type, @PathVariable UUID uuid, @PathVariable Integer dt_update,
                        @RequestBody CreationEvent event) {
        switch(type) {
            case FILMS -> filmService.update(converter.convertToFilm(event), dt_update, uuid);
            case CONCERTS -> concertService.update(converter.convertToConcert(event), dt_update, uuid);
            default -> throw new IllegalArgumentException("Such type does not exist");
        }
    }
}
