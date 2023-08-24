package com.min.edu.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.model.mapper.IBoardDao;
import com.min.edu.vo.BoardVo;

@Service
public class BoardServiceImpl implements IBoardService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IBoardDao dao;

	@Override
	public int insertBoard(String content) {
		logger.info("@@@@@@@@@@Service BoardServiceImpl insertBoard {}", content);
		int n =dao.insertBoard(content);
		int m = (n>0)?dao.getMaxSeq():0;
		return m;
	}
	
	@Override
	public List<BoardVo> getList() {
		logger.info("@@@@@@@@@@Service BoardServiceImpl getList");
		return dao.getList();
	}
	
	@Override
	public String getDetail(String seq) {
		logger.info("@@@@@@@@@@Service BoardServiceImpl getDetail : {}", seq);
		return dao.getDetail(seq);
	}
	
	@Override
	public int updateBoard(BoardVo vo) {
		logger.info("@@@@@@@@@@Service BoardServiceImpl updateBoard : {}", vo);
		return dao.updateBoard(vo);
	}
}
