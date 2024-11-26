package com.example.relationaldataaccess;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;

import java.util.List;

import java.util.stream.Collectors;

@SpringBootApplication

public class RelationalDataAccessApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(RelationalDataAccessApplication.class);

	public static void main(String args[]) {

		SpringApplication.run(RelationalDataAccessApplication.class, args);

	}
	@Autowired

	JdbcTemplate jdbcTemplate;


	@Override

	public void run(String... strings) throws Exception {

		log.info("Creating tables");

		jdbcTemplate.execute("DROP TABLE customers IF EXISTS");

		jdbcTemplate.execute("CREATE TABLE customers(" +

				"id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255), student_id VARCHAR(255))");



		// Добавьте данные

		List<Object[]> customers = Arrays.asList(

				new Object[]{"Josh", "Bloch", "STU001"},

				new Object[]{"Josh", "Long", "STU002"}

		);

		customers.forEach(customer -> log.info(String.format(

				"Inserting customer record for %s %s (ID: %s)", customer[0], customer[1], customer[2])));

		jdbcTemplate.batchUpdate("INSERT INTO customers(first_name, last_name, student_id) VALUES (?,?,?)", customers);

		log.info("Querying for all customer records:");

		jdbcTemplate.query(

						"SELECT id, first_name, last_name, student_id FROM customers",

						(rs, rowNum) -> new Customer(

								rs.getLong("id"),

								rs.getString("first_name"),

								rs.getString("last_name"),

								rs.getString("student_id"))

				)

				.forEach(customer -> log.info(customer.toString()));

	}

}