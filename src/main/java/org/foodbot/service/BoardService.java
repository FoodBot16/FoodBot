package org.foodbot.service;

import java.util.List;

import org.foodbot.domain.BoardVO;
import org.foodbot.domain.Criteria;
import org.foodbot.domain.SearchCriteria;


public interface BoardService {
	public void regist(BoardVO vo) throws Exception;

	public BoardVO read(Integer bno) throws Exception;

	public void modify(BoardVO vo) throws Exception;

	public void remove(Integer bno) throws Exception;

	public List<BoardVO> listAll() throws Exception;

	public List<BoardVO> listCriteria(Criteria cri) throws Exception;

	public int listCountCriteria(Criteria cri) throws Exception;
	
	public List<BoardVO> listSearchCriteria(SearchCriteria cri) throws Exception;
	
	public int listSearchCount(SearchCriteria cri) throws Exception;
}
