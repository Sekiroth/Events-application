package com.afisha.classifier.dao.entity;

import com.afisha.classifier.dto.BaseEssence;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "classifier_country", schema = "classifier_service")
public class Country extends Classifier{

    private String description;

    public Country() {
    }

    public Country(BaseEssence essence, String title, String description) {
        super(essence.getUuid(), essence.getDtCreate(), essence.getDtUpdate(), title);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
