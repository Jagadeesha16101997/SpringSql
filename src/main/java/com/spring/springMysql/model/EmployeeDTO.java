package com.spring.springMysql.model;

public class EmployeeDTO {

    private String Name;
    private float salary;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
