package com.afisha.event_service.dto;

import com.afisha.event_service.dao.entity.ConcertEvent;
import com.afisha.event_service.dao.entity.Event;
import com.afisha.event_service.dao.entity.FilmEvent;
import com.afisha.event_service.dao.entity.enums.Status;
import com.afisha.event_service.dao.entity.enums.Type;
import com.sun.istack.NotNull;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.UUID;

public class CreationEvent {

    private UUID uuid;
    private Integer dtCreate;
    private Integer dtUpdate;

    @NotBlank(message = "Title must not be blank")
    private String title;
    private String description;
    private Integer dtEvent;
    private Integer dtEndOfSale;
    private Type type;
    private Status status;

    private UUID country;
    private Integer releaseYear;
    private LocalDate releaseDate;
    private Integer duration;

    private UUID category;

    public CreationEvent() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDtEvent() {
        return dtEvent;
    }

    public void setDtEvent(Integer dtEvent) {
        this.dtEvent = dtEvent;
    }

    public Integer getDtEndOfSale() {
        return dtEndOfSale;
    }

    public void setDtEndOfSale(Integer dtEndOfSale) {
        this.dtEndOfSale = dtEndOfSale;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public UUID getCountry() {
        return country;
    }

    public void setCountry(UUID country) {
        this.country = country;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public UUID getCategory() {
        return category;
    }

    public void setCategory(UUID category) {
        this.category = category;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Integer getDtCreate() {
        return dtCreate;
    }

    public void setDtCreate(Integer dtCreate) {
        this.dtCreate = dtCreate;
    }

    public Integer getDtUpdate() {
        return dtUpdate;
    }

    public void setDtUpdate(Integer dtUpdate) {
        this.dtUpdate = dtUpdate;
    }
}
