package com.iet.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.iet.bean.User;
import com.iet.dao.UserDAO;
//@Repository
public class UserDAOjdbcTemplate implements UserDAO {
	@Autowired JdbcTemplate jdbcTemplate;
	@Override
	public User save(User user) {
		String q="insert into user(uname,pass,email) values(?,?,?)";
		if(jdbcTemplate.update(q,new Object[] {user.getUname(),user.getPass(),user.getEmail()})>0) {
			q="select * from user where email=?";
			return jdbcTemplate.queryForObject(q, new Object[] {user.getEmail()},new RowMapper<User>() {
				@Override
				public User mapRow(ResultSet rs, int rowNum) throws SQLException {
					User user=new User();
					user.setId(rs.getInt("id"));
					user.setUname(rs.getString("uname"));
					user.setEmail(rs.getString("email"));
					user.setPass(rs.getString("pass"));
					return user;
				}});
		}
		return null;
	}

}
