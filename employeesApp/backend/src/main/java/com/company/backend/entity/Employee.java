package com.company.backend.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EMPLOYEE_ID")
    private long EmployeeId;

    @Column(name = "FIRST_NAME")
    private  String FirstName;

    @Column(name = "LAST_NAME")
    private  String LastName;

    @Column(name = "EMAIL")
    private  String Email;

    @Column(name = "ADDRESS")
    private  String Address;

    @Column(name = "MOBILE")
    private  String Mobile;

    public Employee() {

    }

    public Employee(long employeeId, String firstName, String lastName, String email, String address, String mobile) {
        EmployeeId = employeeId;
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        Address = address;
        Mobile = mobile;
    }

    public long getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.EmployeeId = employeeId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        this.FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        this.Mobile = mobile;
    }
}

