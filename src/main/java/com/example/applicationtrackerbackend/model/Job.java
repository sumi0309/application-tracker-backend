package com.example.applicationtrackerbackend.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Job {

    private Integer jobId;
    private String title;
    private String company;
    private String location;
    private Long pay;
    private Date datePosted;
    private Date dateApplied;
    private String jobLink;

    @Id
    private Integer userId;

    public Job() {}

    public Job(Integer jobId, String title, String company, String location, Long pay, Date datePosted, Date dateApplied, String jobLink, Integer userId) {
        this.jobId = jobId;
        this.title = title;
        this.company = company;
        this.location = location;
        this.pay = pay;
        this.datePosted = datePosted;
        this.dateApplied = dateApplied;
        this.jobLink = jobLink;
        this.userId = userId;
    }

    public Integer getJobId() {
        return jobId;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getLocation() {
        return location;
    }

    public Long getPay() {
        return pay;
    }

    public Date getDatePosted() {
        return datePosted;
    }

    public Date getDateApplied() {
        return dateApplied;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPay(Long pay) {
        this.pay = pay;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }

    public void setDateApplied(Date dateApplied) {
        this.dateApplied = dateApplied;
    }

    public void setJobLink(String jobLink) {
        this.jobLink = jobLink;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getJobLink() {
        return jobLink;
    }

    public Integer getUserId() {
        return userId;
    }
}
