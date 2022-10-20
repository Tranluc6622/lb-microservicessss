package com.elcom.controller;

import com.elcom.model.Book;
import com.elcom.model.Borrow;
import com.elcom.repository.BookRepository;
import com.elcom.repository.BorrowRepository;
import com.elcom.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BorrowController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BorrowController.class.getName());

    @Autowired
    BorrowRepository borrowRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public List<Borrow> getAllBorrow()
    {
        return (List<Borrow>) borrowRepository.findAll();
    }
    @GetMapping("/findByBorrowerId")
    public List<Borrow> getByBorrowerId(@RequestParam(value = "id") Long id)
    {
        return borrowRepository.findByUserId(id);
    }
    @GetMapping("/findByBookId")
    public List<Borrow> getByBookId(@RequestParam(value = "bookId") Long id)
    {
        return borrowRepository.findByBookId(id);
    }
    @GetMapping("/id")
    public ResponseEntity<Optional<Borrow>> getBorrowById(@PathVariable(value ="id") Long id)
    {
        Optional<Borrow> borrow = borrowRepository.findById(id);
        return ResponseEntity.ok().body(borrow);
    }
    @PostMapping("/borrow")
    public ResponseEntity<Borrow> addBook(@RequestBody Borrow borrow)
    {
        borrowRepository.save(borrow);
        return new ResponseEntity<Borrow>(HttpStatus.OK);
    }
    @DeleteMapping("/borrow")
    public ResponseEntity<Borrow> deleteById(@PathVariable(value ="id") Long id)
    {
        borrowRepository.deleteById(id);
        return new ResponseEntity<Borrow>(HttpStatus.NO_CONTENT);
    }

//    @PutMapping("/borrow/{id")
//    public Borrow returnBorrow(@RequestBody Borrow borrowBody)
//    {
//        Long id = borrowBody.getId();
//        Borrow borrow = borrowRepository.findById(id).get();
//        Book book = bookRepository.findById(borrow.getBook().getId()).get();
//    }
}
