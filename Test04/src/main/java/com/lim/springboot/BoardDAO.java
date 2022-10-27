package com.lim.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO implements IBoardDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<BoardDTO> selectAll(BoardDTO dto) {
		return jdbcTemplate.query("SELECT * FROM BOARD ORDER BY BID DESC", new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class));
	}

	@Override
	public BoardDTO selectOne(BoardDTO dto) {
		int bid=dto.getBid();
		return jdbcTemplate.queryForObject("SELECT * FROM BOARD WHERE BID="+bid, new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class));
	}

	@Override
	public int insert(BoardDTO dto) {
		String sql="INSERT INTO BOARD VALUES(BOARD_SEQ.nextval,?,?,?)";
		return jdbcTemplate.update(sql,dto.getWriter(),dto.getTitle(),dto.getContent());
	}

	@Override
	public int delete(BoardDTO dto) {
		String sql="DELETE FROM BOARD WHERE BID=?";
		return jdbcTemplate.update(sql,dto.getBid());
	}

}
