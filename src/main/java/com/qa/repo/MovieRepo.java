package com.qa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.domain.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Long> {

}