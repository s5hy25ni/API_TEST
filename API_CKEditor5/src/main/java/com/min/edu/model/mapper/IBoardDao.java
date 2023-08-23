package com.min.edu.model.mapper;

import java.util.List;

import com.min.edu.vo.BoardVo;

public interface IBoardDao{
	public int insertBoard(String content);
	public int getMaxSeq();
	public List<BoardVo> getList();
	public String getDetail(String seq);
}
