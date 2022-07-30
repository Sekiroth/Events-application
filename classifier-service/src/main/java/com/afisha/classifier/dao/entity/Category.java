package com.afisha.classifier.dao.entity;

import com.afisha.classifier.dto.BaseEssence;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "classifier_category", schema = "classifier_service")
public class Category extends Classifier{

    public Category() {
    }

    public Category(BaseEssence essence, String title) {
        super(essence.getUuid(), essence.getDtCreate(), essence.getDtUpdate(), title);
    }

}
