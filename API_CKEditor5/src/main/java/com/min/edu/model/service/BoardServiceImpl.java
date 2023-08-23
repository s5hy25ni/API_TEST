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
		dao.insertBoard(content);
		
		return 1;
	}
	
	@Override
	public List<BoardVo> selectList() {
		logger.info("@@@@@@@@@@Service BoardServiceImpl selectList");
		return dao.selectList();
	}
}
