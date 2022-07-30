package com.afisha.event_service.service.api;

import com.afisha.event_service.dao.entity.Event;
import com.afisha.event_service.dao.entity.enums.Type;
import com.afisha.event_service.dto.CreationEvent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface IEventService<T> {
    void save(T event);
    T findOne(UUID uuid);
    Page<? extends Event> findAll(Pageable pageable);
    void delete(T event);
    void update(T event, Integer dtUpdate, UUID uuid);
}
