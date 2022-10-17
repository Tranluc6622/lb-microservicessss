package com.elcom.controller;

import com.elcom.exception.ResourceNotFoundException;
import com.elcom.model.Author;
import com.elcom.model.Category;
import com.elcom.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class CategoryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

   @Autowired
   private CategoryRepository categoryRepository;

    @GetMapping("/category")
    public ResponseEntity<List<Category>> getAllCategorys(@RequestParam(required = false) String categoryName) {
        List<Category> categorys = new ArrayList<Category>();
        if (categoryName == null)
            categoryRepository.findAll().forEach((categorys::add));
        else
            categoryRepository.findByCategoryName(categoryName).forEach(categorys::add);
        if (categorys.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categorys, HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") String id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found category with id = " + id));

        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PostMapping("/category")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
//        Author authors = authorRepository.save(new Author(author.getId(),author.getAuthorName()));
//        return new ResponseEntity<>(author, HttpStatus.OK);
        categoryRepository.save(category);
        return new ResponseEntity<Category>(HttpStatus.OK);
    }

    // xoa theo id
    @DeleteMapping("/category/{id}")
    public ResponseEntity<Category> removeCategory(@PathVariable("id") String id)
    {
        categoryRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
