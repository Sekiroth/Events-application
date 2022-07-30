package com.afisha.event_service.service.event;

import com.afisha.event_service.dao.api.IConcertEventRepository;
import com.afisha.event_service.dao.entity.ConcertEvent;
import com.afisha.event_service.dao.entity.Event;
import com.afisha.event_service.converter.EventConverter;
import com.afisha.event_service.service.api.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ConcertService implements IEventService<ConcertEvent> {

    @Autowired
    IConcertEventRepository concertEventRepository;
    @Autowired
    EventConverter converter;

    @Override
    public void save(ConcertEvent event) {
        concertEventRepository.save(event);
    }

    @Override
    public ConcertEvent findOne(UUID uuid) {
        Optional<ConcertEvent> optional = concertEventRepository.findById(uuid);
        if (optional.isEmpty()) {
            throw new IllegalArgumentException("The concert was not found");
        } else return optional.get();
    }


    @Override
    public Page<? extends Event> findAll(Pageable pageable) {
        return concertEventRepository.findAll(pageable);
    }

    @Override
    public void delete(ConcertEvent event) {
        concertEventRepository.delete(event);
    }

    @Override
    public void update(ConcertEvent event, Integer dtUpdate, UUID uuid) {
        ConcertEvent before = findOne(uuid);
        ConcertEvent concertEvent = converter.updateConcertEvent(before, event);
        concertEvent.setDtEvent(dtUpdate);
        save(concertEvent);
    }
}
