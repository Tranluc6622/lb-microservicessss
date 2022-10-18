package com.elcom.controller;

import com.elcom.model.Borrow;
import com.elcom.repository.BookRepository;
import com.elcom.repository.BorrowRepository;
import com.elcom.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
