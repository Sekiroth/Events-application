package com.afisha.event_service.converter;

import com.afisha.event_service.dao.entity.ConcertEvent;
import com.afisha.event_service.dao.entity.Event;
import com.afisha.event_service.dao.entity.FilmEvent;
import com.afisha.event_service.dao.entity.enums.Status;
import com.afisha.event_service.dao.entity.enums.Type;
import com.afisha.event_service.dto.BaseEssence;
import com.afisha.event_service.dto.CreationEvent;
import org.springframework.stereotype.Service;

@Service
public class EventConverter {

    public EventConverter() {
    }

    public FilmEvent convertToFilm(CreationEvent event) {
        FilmEvent filmEvent = new FilmEvent();
        filmEvent.setUuid(BaseEssence.getInstance().getUuid());
        filmEvent.setDtCreate(BaseEssence.generateTime());
        filmEvent.setDtUpdate(BaseEssence.generateTime());
        filmEvent.setDescription(event.getDescription());
        filmEvent.setDtEvent(event.getDtEvent());
        filmEvent.setTitle(event.getTitle());
        filmEvent.setStatus(Status.DRAFTS);
        filmEvent.setType(Type.FILMS);
        filmEvent.setDtEndOfSale(event.getDtEndOfSale());
        filmEvent.setCountry(event.getCountry());
        filmEvent.setDuration(event.getDuration());
        filmEvent.setReleaseDate(event.getReleaseDate());
        filmEvent.setReleaseYear(event.getReleaseYear());
        return filmEvent;
    }

    public ConcertEvent convertToConcert(CreationEvent event) {
        ConcertEvent concertEvent = new ConcertEvent();
        concertEvent.setUuid(BaseEssence.getInstance().getUuid());
        concertEvent.setDtCreate(BaseEssence.generateTime());
        concertEvent.setDtUpdate(BaseEssence.generateTime());
        concertEvent.setDescription(event.getDescription());
        concertEvent.setDtEvent(event.getDtEvent());
        concertEvent.setTitle(event.getTitle());
        concertEvent.setCategory(event.getCategory());
        concertEvent.setStatus(Status.DRAFTS);
        concertEvent.setType(Type.CONCERTS);
        concertEvent.setDtEndOfSale(event.getDtEndOfSale());
        return concertEvent;
    }

    public ConcertEvent updateConcertEvent(ConcertEvent oldOne, ConcertEvent newOne) {
        oldOne.setDtUpdate(BaseEssence.generateTime());
        oldOne.setDtEvent(newOne.getDtEvent());
        oldOne.setStatus(newOne.getStatus());
        oldOne.setDtEndOfSale(newOne.getDtEndOfSale());
        oldOne.setTitle(newOne.getTitle());
        oldOne.setDescription(newOne.getDescription());
        oldOne.setCategory(newOne.getCategory());
        return oldOne;
    }

    public FilmEvent updateFilmEvent(FilmEvent oldOne, FilmEvent newOne) {
        oldOne.setDtUpdate(BaseEssence.generateTime());
        oldOne.setDtEvent(newOne.getDtEvent());
        oldOne.setStatus(newOne.getStatus());
        oldOne.setDtEndOfSale(newOne.getDtEndOfSale());
        oldOne.setTitle(newOne.getTitle());
        oldOne.setDescription(newOne.getDescription());
        oldOne.setReleaseYear(newOne.getReleaseYear());
        oldOne.setDuration(newOne.getDuration());
        oldOne.setReleaseDate(newOne.getReleaseDate());
        oldOne.setCountry(newOne.getCountry());
        return oldOne;
    }
}
