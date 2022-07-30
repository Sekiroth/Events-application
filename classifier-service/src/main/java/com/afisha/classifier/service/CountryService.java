package com.afisha.classifier.service;

import com.afisha.classifier.controller.exceptions.NoSuchClassifierFoundException;
import com.afisha.classifier.dao.api.CountryClassifierRepository;
import com.afisha.classifier.dao.entity.Country;
import com.afisha.classifier.dto.BaseEssence;
import com.afisha.classifier.service.api.IClassifierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class CountryService implements IClassifierService<Country> {

    @Autowired
    CountryClassifierRepository repository;

    @Override
    public void save(Country classifier) {
        repository.save(classifier);
    }

    @Override
    public Country findOne(UUID uuid) {
        Optional<Country> optional = repository.findById(uuid);
        if(optional.isEmpty()) {
            throw new NoSuchClassifierFoundException("No country found");
        } else return optional.get();
    }

    @Override
    public Page<Country> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void delete(Country classifier) {
        repository.delete(classifier);
    }

    @Override
    public void update(Country classifier, Integer dtUpdate, UUID uuid) {
        Country country = findOne(uuid);
        country.setTitle(classifier.getTitle());
        country.setDescription(classifier.getDescription());
        country.setDtUpdate(dtUpdate);
    }
}
