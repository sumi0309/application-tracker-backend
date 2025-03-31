package com.example.applicationtrackerbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.applicationtrackerbackend.repository.JobRepository;
import com.example.applicationtrackerbackend.model.Job;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    JobRepository jobRepository;

     public Job saveJob(Job job){
         return jobRepository.save(job);
     }

//     public List<Job> getJobDetails(Integer userId){
//         List<Job> foundJobs = jobRepository.findAll(userId);
//         if(!foundJobs.isEmpty()){
//             return foundJobs;
//         }
//         return null;
//     }
}
