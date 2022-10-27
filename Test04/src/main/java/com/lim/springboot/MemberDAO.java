package com.lim.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<MemberDTO> selectAll(){
		String sql="SELECT * FROM MEMBER";
		List<MemberDTO> datas=jdbcTemplate.query(sql, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
		return datas;
	}
}
