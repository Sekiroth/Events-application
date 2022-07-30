package com.afisha.event_service.dao.api;

import com.afisha.event_service.dao.entity.ConcertEvent;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface IConcertEventRepository extends PagingAndSortingRepository<ConcertEvent, UUID> {
}
