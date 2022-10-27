package com.lim.springboot;

import java.util.List;

public interface IBoardDAO {
	List<BoardDTO> selectAll(BoardDTO dto);
	BoardDTO selectOne(BoardDTO dto);
	int insert(BoardDTO dto);
	int delete(BoardDTO dto);
}
