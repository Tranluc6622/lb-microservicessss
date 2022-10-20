package com.elcom.repository;

import com.elcom.model.Borrow;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BorrowRepository extends PagingAndSortingRepository<Borrow,Long> {
    List<Borrow> findByUserId (Long id);

    List<Borrow> findByBookId (Long id);

}
