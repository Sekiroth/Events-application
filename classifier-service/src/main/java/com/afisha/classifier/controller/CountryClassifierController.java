package com.afisha.classifier.controller;

import com.afisha.classifier.config.response.ResponseHandler;
import com.afisha.classifier.dao.entity.Category;
import com.afisha.classifier.dao.entity.Country;
import com.afisha.classifier.dto.BaseEssence;
import com.afisha.classifier.dto.classifiers.CreationCategory;
import com.afisha.classifier.dto.classifiers.CreationCountry;
import com.afisha.classifier.service.CountryService;
import com.afisha.classifier.service.pagination.ResponsePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/classifier/country")
public class CountryClassifierController {

    @Autowired
    CountryService service;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public void save(@Valid @RequestBody CreationCountry country) {
        service.save(new Country(BaseEssence.getInstance(), country.getTitle(), country.getDescription()));
    }

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam(defaultValue = "0") Integer page,
                                     @RequestParam(defaultValue = "20") Integer size) {
        Page<Country> all = service.findAll(PageRequest.of(page, size));
        ResponsePage responsePage = new ResponsePage(page, size, all.getTotalPages(), (int) all.getTotalElements(), all.isFirst(), all.getNumberOfElements(), all.isLast(), all.stream().toList());
        return ResponseEntity.ok(ResponseHandler.generateResponse(responsePage));
    }
}
