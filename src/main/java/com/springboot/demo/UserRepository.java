package com.springboot.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

public class UserRepository {

	
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
 
    @Transactional(readOnly=true)
    
    public List<User> findAll() {
        return jdbcTemplate.query("select * from users", 
                new UserRowMapper());
    }
}
