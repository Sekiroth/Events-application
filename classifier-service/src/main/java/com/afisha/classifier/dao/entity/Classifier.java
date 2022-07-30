package com.afisha.classifier.dao.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;
@MappedSuperclass
public class Classifier {
    @Id
    @Column(nullable = false, updatable = false)
    private UUID uuid;
    @Column(nullable = false, updatable = false)
    private int dtCreate;
    @Column(nullable = false)
    private int dtUpdate;
    private String title;

    public Classifier(UUID uuid, int dtCreate, int dtUpdate, String title) {
        this.uuid = uuid;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.title = title;
    }

    public Classifier() {
    }

    public int getDtUpdate() {
        return dtUpdate;
    }

    public void setDtUpdate(int dtUpdate) {
        this.dtUpdate = dtUpdate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UUID getUuid() {
        return uuid;
    }

    public int getDtCreate() {
        return dtCreate;
    }
}
