package com.afisha.classifier.service.api;

import com.afisha.classifier.dao.entity.Classifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface IClassifierService<T> {
    void save(T classifier);
    T findOne(UUID uuid);
    Page<T> findAll(Pageable pageable);
    void delete(T classifier);
    void update(T classifier, Integer dtUpdate, UUID uuid);
}
