package com.elcom.repository;

import com.elcom.model.Borrow;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BorrowRepository extends PagingAndSortingRepository<Borrow,Long> {
}
