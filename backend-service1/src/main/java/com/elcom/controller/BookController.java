package com.elcom.controller;

import com.elcom.dto.CountAuthor;
import com.elcom.dto.CountCategory;
import com.elcom.dto.CountFirstLetter;
import com.elcom.model.Book;
import com.elcom.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class BookController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private BookRepository bookRepository;
    @GetMapping("/book")
    public List<Book> getAllBook(){
        List<Book> allBook = (List<Book>) bookRepository.findAll();
        return allBook;
    }
    @PostMapping("/book")
    public ResponseEntity<Book> addBook(@RequestBody Book book)
    {
        bookRepository.save(book);
        return new ResponseEntity<Book>(HttpStatus.OK);
    }
    @DeleteMapping("/book/{id}")
    public ResponseEntity<Book> deleteById(@PathVariable("id") UUID id)
    {

        bookRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


//    // thống kê số lượng sách theo chữ cái
//    @RequestMapping(value = "/bookFirstLetter", method = RequestMethod.GET)
//    public ResponseEntity<List<CountFirstLetter>> countFirstLetter()
//    {
//        List<CountFirstLetter> lst = bookCustomizeRepository.countFirstLetter();
//        return new ResponseEntity<>(lst, HttpStatus.OK);
//    }
//
//    // thống kê số lượng sách theo tac gia
//    @RequestMapping(value = "/bookAuthor", method = RequestMethod.GET)
//    public ResponseEntity<List<CountAuthor>> countAuthor()
//    {
//        List<CountAuthor> lst = bookCustomizeRepository.countAuthor();
//        return new ResponseEntity<>(lst, HttpStatus.OK);
//    }
//
//    // thống kê số lượng sách theo chuyen muc
//    @RequestMapping(value = "/bookCategory", method = RequestMethod.GET)
//    public ResponseEntity<List<CountCategory>>countCategory()
//    {
//        List<CountCategory> lst = bookCustomizeRepository.countCategory();
//        return new ResponseEntity<>(lst, HttpStatus.OK);
//    }


}
