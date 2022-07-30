package com.afisha.event_service.dao.api;

import com.afisha.event_service.dao.entity.FilmEvent;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IFilmEventRepository extends PagingAndSortingRepository<FilmEvent, UUID> {
}
