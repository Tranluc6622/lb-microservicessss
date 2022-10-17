package com.elcom.repository;

import com.elcom.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, String> {
    List<Category> findByCategoryName(String categoryName);

    List<Category> findCategoryById(String id);
}
