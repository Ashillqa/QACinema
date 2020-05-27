package com.qa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.domain.ShowTime;

@Repository
public interface ShowTimeRepo extends JpaRepository<ShowTime, Long> {

}