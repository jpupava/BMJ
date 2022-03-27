package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowingRepository extends CrudRepository<BorrowingEntity, Long> {
    @Override
    List<BorrowingEntity> findAll();
}