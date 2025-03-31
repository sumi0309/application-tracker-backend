package com.example.applicationtrackerbackend.controller;

import com.example.applicationtrackerbackend.model.Job;
import com.example.applicationtrackerbackend.services.JobService;
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
    public Job createJob(@RequestBody Job job){
        return jobService.saveJob(job);
    }
}
