package com.afisha.classifier.dao.api;

import com.afisha.classifier.dao.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryClassifierRepository extends PagingAndSortingRepository<Category, UUID> {
}
