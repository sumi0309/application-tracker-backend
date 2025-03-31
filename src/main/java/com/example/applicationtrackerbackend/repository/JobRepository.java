package com.example.applicationtrackerbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.applicationtrackerbackend.model.Job;
import java.util.List;

import java.util.Optional;

@Repository
public interface JobRepository extends JpaRepository <Job, Long> {
    List<Job> findByUserId(Long userId);
}
