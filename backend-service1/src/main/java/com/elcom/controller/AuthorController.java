package com.elcom.controller;

import com.elcom.exception.ResourceNotFoundException;
import com.elcom.model.Author;
import com.elcom.repository.AuthorRepository;
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
public class AuthorController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorController.class);

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("/author")
    public ResponseEntity<List<Author>> getAllAuthors(@RequestParam(required = false) String authorName)
    {
        List<Author> authors = new ArrayList<Author>();
        if(authorName == null)
            authorRepository.findAll().forEach((authors::add));
        else
            authorRepository.findByAuthorName(authorName).forEach(authors::add);
        if(authors.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(authors,HttpStatus.OK);
    }
    @GetMapping("/author/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable("id") String id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found author with id = " + id));

        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @PostMapping("/author")
    public ResponseEntity<Author> addAuthor(@RequestBody Author author) {
//        Author authors = authorRepository.save(new Author(author.getId(),author.getAuthorName()));
//        return new ResponseEntity<>(author, HttpStatus.OK);
        authorRepository.save(author);
        return new ResponseEntity<Author>(HttpStatus.OK);
    }

    // xoa theo id
    @DeleteMapping("/author/{id}")
    public ResponseEntity<Author> removeAuthor(@PathVariable("id") String id)
    {
        authorRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
