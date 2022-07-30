package com.afisha.event_service.dao.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name="event_concert", schema="event_service")
public class ConcertEvent extends Event {

//    @OneToOne(targetEntity = Concert.class, cascade = CascadeType.ALL)
    private UUID category;

    public ConcertEvent() {
    }

    public UUID getCategory() {
        return category;
    }

    public void setCategory(UUID category) {
        this.category = category;
    }
}
