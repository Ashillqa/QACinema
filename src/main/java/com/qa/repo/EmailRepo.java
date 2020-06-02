package com.qa.repo;

import com.qa.domain.Email;
import com.qa.domain.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepo extends JpaRepository<Email, Long> {

}