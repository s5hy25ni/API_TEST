package com.min.edu.model.mapper;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.BoardVo;

@Repository
public class BoardDaoImpl implements IBoardDao {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public int insertBoard(String content) {
		logger.info("@@@@@@@@@@Repository BoardDaoImpl insertBoard : {}", content);
		return session.insert("com.min.edu.model.mapper.BoardDaoImpl.insertBoard",content);
	}
	
	@Override
	public int getMaxSeq() {		
		logger.info("@@@@@@@@@@Repository BoardDaoImpl getMaxSeq");
		return session.selectOne("com.min.edu.model.mapper.BoardDaoImpl.getMaxSeq");
	}
	
	@Override
	public List<BoardVo> getList() {
		logger.info("@@@@@@@@@@Repository BoardDaoImpl getList");
		return session.selectList("com.min.edu.model.mapper.BoardDaoImpl.getList");
	}
	
	@Override
	public String getDetail(String seq) {
		logger.info("@@@@@@@@@@Repository BoardDaoImpl getDetail : {}", seq);
		return session.selectOne("com.min.edu.model.mapper.BoardDaoImpl.getDetail", seq);
	}
	
	@Override
	public int updateBoard(BoardVo vo) {
		logger.info("@@@@@@@@@@Repository BoardDaoImpl updateBoard : {}", vo);
		return session.update("com.min.edu.model.mapper.BoardDaoImpl.updateBoard",vo);
	}
}
