package com.example.relationaldataaccess;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired

    private JdbcTemplate jdbcTemplate;

    @GetMapping("/customers")

    public List<Customer> getCustomersByFirstName(@RequestParam String firstName) {

        return jdbcTemplate.query(

                "SELECT id, first_name, last_name, student_id FROM customers WHERE first_name = ?",

                (rs, rowNum) -> new Customer(

                        rs.getLong("id"),

                        rs.getString("first_name"),

                        rs.getString("last_name"),

                        rs.getString("student_id")),

                firstName

        );

    }

}