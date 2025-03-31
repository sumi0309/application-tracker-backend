package com.example.applicationtrackerbackend.controller;

import com.example.applicationtrackerbackend.model.Job;
import com.example.applicationtrackerbackend.services.JobService;
import jakarta.servlet.http.HttpSession;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    JobService jobService;

    @PostMapping("/create")
    public ResponseEntity<Job> createJob(@RequestBody Job job, HttpSession session){
        Long userId = (Long) session.getAttribute("userId");
        if(userId == null){
            return ResponseEntity.status(401).body(null);
        }
        job.setUserId(userId);
        jobService.saveJob(job);
        return ResponseEntity.ok(job);
    }

    @PostMapping("/getjobs")
    public ResponseEntity<List<Job>> fetchJobs(HttpSession session){
        Long userId = (Long) session.getAttribute("userId");
        if(userId == null){
            return ResponseEntity.status(401).body(null);
        }
        List<Job> foundJobs = jobService.getJobDetails(userId);
        return ResponseEntity.ok(foundJobs);
    }

}
