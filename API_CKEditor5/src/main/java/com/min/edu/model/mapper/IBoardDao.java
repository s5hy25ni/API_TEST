package com.min.edu.model.mapper;

import java.util.List;

import com.min.edu.vo.BoardVo;

public interface IBoardDao{
	/**
	 * 글쓰기
	 * @param content editor에 쓴 내용
	 * @return 성공한 쿼리 개수
	 */
	public int insertBoard(String content);
	
	/**
	 * max(seq) 조회
	 * @return seq
	 */
	public int getMaxSeq();
	
	/**
	 * 글 목록 조회
	 * @return List 게시글목록
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
	 * @return 성공한 쿼리 개수
	 */
	public int updateBoard(BoardVo vo);
}
