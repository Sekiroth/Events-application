package com.afisha.event_service.service.event;

import com.afisha.event_service.dao.api.IFilmEventRepository;
import com.afisha.event_service.dao.entity.Event;
import com.afisha.event_service.dao.entity.FilmEvent;
import com.afisha.event_service.converter.EventConverter;
import com.afisha.event_service.service.api.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class FilmService implements IEventService<FilmEvent> {
    @Autowired
    IFilmEventRepository filmEventRepository;
    @Autowired
    EventConverter converter;

    @Override
    public void save(FilmEvent event) {
        filmEventRepository.save(event);
    }

    @Override
    public FilmEvent findOne(UUID uuid) {
        Optional<FilmEvent> optional = filmEventRepository.findById(uuid);
        if (optional.isEmpty()) {
            throw new IllegalArgumentException("The film was not found");
        } else return optional.get();
    }


    @Override
    public Page<? extends Event> findAll(Pageable pageable) {
        return filmEventRepository.findAll(pageable);
    }

    @Override
    public void delete(FilmEvent event) {
        filmEventRepository.delete(event);
    }

    @Override
    public void update(FilmEvent event, Integer dtUpdate, UUID uuid) {
        FilmEvent before = findOne(uuid);
        FilmEvent filmEvent = converter.updateFilmEvent(before, event);
        filmEvent.setDtUpdate(dtUpdate);
        save(filmEvent);
    }
}
