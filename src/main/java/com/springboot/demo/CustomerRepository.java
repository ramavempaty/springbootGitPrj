package com.springboot.demo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

public class CustomerRepository {
	@Autowired
    private JdbcTemplate jdbcTemplate;

	// Find all customers, thanks Java 8, you can create a custom RowMapper like this : 
    public List<Customer> findAll() {

        List<Customer> result = jdbcTemplate.query(
                "SELECT id, name, email, created_date FROM customer",
                (rs, rowNum) -> new Customer(rs.getInt("id"),
                        rs.getString("name"), rs.getString("email"), rs.getDate("created_date"))
        );

        return result;

    }

	// Add new customer
    public void addCustomer(String name, String email) {

        jdbcTemplate.update("INSERT INTO customer(name, email, created_date) VALUES (?,?,?)",
                name, email, new Date());

    }

}
