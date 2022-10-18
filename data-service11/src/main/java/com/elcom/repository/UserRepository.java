package com.elcom.repository;

import com.elcom.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    User findByUsername(String username);

}
