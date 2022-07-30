package com.afisha.event_service.dao.entity;

import com.afisha.event_service.dao.entity.enums.Status;
import com.afisha.event_service.dao.entity.enums.Type;
import com.afisha.event_service.dto.BaseEssence;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.UUID;
@MappedSuperclass
public class Event {
    @Id
    @NotNull
    private UUID uuid;
    @NotNull
    private Integer dtCreate;
    @NotNull
    private Integer dtUpdate;
    private String title;
    private String description;
    private Integer dtEvent;
    private Integer dtEndOfSale;
    @Enumerated(value = EnumType.STRING)
    private Type type;
    @Enumerated(value = EnumType.STRING)
    private Status status;

    public Event() {
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

    @Override
    public String toString() {
        return "Event{" +
                "uuid=" + uuid +
                ", dtCreate=" + dtCreate +
                ", dtUpdate=" + dtUpdate +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dtEvent=" + dtEvent +
                ", dtEndOfSale=" + dtEndOfSale +
                ", type=" + type +
                ", status=" + status +
                '}';
    }
}
