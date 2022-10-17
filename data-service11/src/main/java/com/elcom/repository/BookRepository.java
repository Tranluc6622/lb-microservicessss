package com.elcom.repository;

import com.elcom.model.Book;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, UUID> {
    List<Book> findByBookName(String bookName);

    List<Book> findAuthorById(String  id);

    List<Book> findCategoryById(String id);
}
