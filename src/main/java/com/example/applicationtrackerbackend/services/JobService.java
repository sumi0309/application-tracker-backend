package com.example.applicationtrackerbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.applicationtrackerbackend.repository.JobRepository;
import com.example.applicationtrackerbackend.model.Job;

import java.util.List;

@Service
public class JobService {

    @Autowired
    JobRepository jobRepository;

     public Job saveJob(Job job){
         return jobRepository.save(job);
     }

     public List<Job> getJobDetails(Long userId){
         return jobRepository.findByUserId(userId);
     }
}
