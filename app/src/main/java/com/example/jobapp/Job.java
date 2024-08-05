package com.example.jobapp;

public class Job {
    private String title;
    private String location;
    private String salary;
    private String phone;

    public Job(String title, String location, String salary, String phone) {
        this.title = title;
        this.location = location;
        this.salary = salary;
        this.phone = phone;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public String getSalary() {
        return salary;
    }

    public String getPhone() {
        return phone;
    }
}
