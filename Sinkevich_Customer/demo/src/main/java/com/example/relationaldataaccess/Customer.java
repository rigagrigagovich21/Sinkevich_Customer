package com.example.relationaldataaccess;

public class Customer {
    private long id;

    private String firstName, lastName;

    private String studentId;

    public Customer(long id, String firstName, String lastName, String studentId) {

        this.id = id;

        this.firstName = firstName;

        this.lastName = lastName;

        this.studentId = studentId;

    }


    @Override

    public String toString() {

        return String.format(

                "Customer[id=%d, firstName='%s', lastName='%s', studentId='%s']",

                id, firstName, lastName, studentId);

    }


    // Getters and setters

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

    public String getStudentId() {

        return studentId;

    }

    public void setStudentId(String studentId) {

        this.studentId = studentId;

    }

}