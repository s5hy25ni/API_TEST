package com.min.edu.model.service;

import java.util.List;

import com.min.edu.vo.BoardVo;

public interface IBoardService {
	/**
	 * 글 쓰기
	 * @param content
	 * @return insert 성공시 작성한 글의 seq, 실패시 0
	 */
	public int insertBoard(String content);
	
	/**
	 * 글 목록 조회
	 * @return List 글목록
	 */
	public List<BoardVo> getList();
	
	/**
	 * 글 상세 조회
	 * @param seq
	 * @return content 글 내용
	 */
	public String getDetail(String seq);
	
	/**
	 * 글 수정
	 * @param vo
	 * @return 성공한 row의 개수
	 */
	public int updateBoard(BoardVo vo);
}
