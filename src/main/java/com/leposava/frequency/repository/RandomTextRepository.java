package com.leposava.frequency.repository;


import com.leposava.frequency.entity.RandomText;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RandomTextRepository extends JpaRepository<RandomText, Integer> {
}

