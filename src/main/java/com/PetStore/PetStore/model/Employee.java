package com.PetStore.PetStore.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


    @Entity
    @Table(name ="employees")
    public class Employee {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(name ="firstname")
        private String firstName;

        @Column(name ="lastname")
        private String lastName;

        @Column(name ="email")
        private String emailId;

        @Column(name ="phone_number")
        private String phoneNumber;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
        @Column(name ="hire_date")
        private LocalDate HireDate;

        @Column(name ="job_title")
        private String JobTitle;

        @Column(name ="salary")
        private double Salary;

        public Employee() {

        }

        public Employee(long id, String firstName, String lastName, String emailId, String phoneNumber, LocalDate hireDate, String jobTitle, double salary) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.emailId = emailId;
            this.phoneNumber = phoneNumber;
            HireDate = hireDate;
            JobTitle = jobTitle;
            Salary = salary;
        }

        public long getId() {
            return id;
        }
        public void setId(long id) {
            this.id = id;
        }
        public String getFirstName() {
            return firstName;
        }
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmailId() {
            return emailId;
        }

        public void setEmailId(String emailId) {
            this.emailId = emailId;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public LocalDate getHireDate() {
            return HireDate;
        }

        public void setHireDate(LocalDate hireDate) {
            HireDate = hireDate;
        }

        public String getJobTitle() {
            return JobTitle;
        }

        public void setJobTitle(String jobTitle) {
            JobTitle = jobTitle;
        }

        public double getSalary() {
            return Salary;
        }

        public void setSalary(double salary) {
            Salary = salary;
        }
    }
