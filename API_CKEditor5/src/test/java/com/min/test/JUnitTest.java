package com.min.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.edu.model.service.IBoardService;
import com.min.edu.vo.BoardVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class JUnitTest {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private IBoardService service;
	
//	@Test
	public void session() {
		assertNotNull(sqlSession);
	}
	
	@Test
	public void dao() {
//		int n = service.insertBoard("test content");
//		assertEquals(1, n);
		
		List<BoardVo> list = service.selectList();
		assertNotNull(list);
	}

}
