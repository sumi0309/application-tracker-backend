# Job Application Tracker Backend

## Introduction
The backend component of the Job Application Tracker, this project is designed to handle and secure user data with Spring Boot and MySQL. It is an essential part of a full-stack application that helps users efficiently track their job applications.

## Features
- **Secure Authentication**: Implements Spring Security and uses Argon2 for password hashing to protect user data.
- **Database Integration**: Utilizes MySQL to store and manage job application data securely.

## Technical Stack
- **Framework**: Spring Boot
- **Database**: MySQL
- **Security**: Spring Security, Argon2 hasher

## Getting Started
1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourgithub/repo.git

2. **Navigate to project directory**:
   ```bash
   cd job-application-tracker-backend

3. **Configure MySQL: Ensure MySQL is running on your system. Update application.properties with your MySQL user credentials and database URL.**

4. **Build the project**
   ```bash
   ./gradlew build

5. **Run the application** 
   ```bash
   java -jar build/libs/jobapptracker-backend-0.1.0.jar
