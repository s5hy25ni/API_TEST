package com.min.edu.model.service;

import java.util.List;

import com.min.edu.vo.BoardVo;

public interface IBoardService {
	public int insertBoard(String content);
	public List<BoardVo> getList();
	public String getDetail(String seq);
	public int updateBoard(BoardVo vo);
}
