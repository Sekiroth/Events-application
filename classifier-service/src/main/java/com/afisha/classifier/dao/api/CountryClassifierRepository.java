package com.afisha.classifier.dao.api;

import com.afisha.classifier.dao.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CountryClassifierRepository extends PagingAndSortingRepository<Country, UUID> {
}
