package org.foodbot.persistence;

import java.util.List;

import org.foodbot.domain.ChatVO;


public interface ChatDAO {
	public void create(ChatVO vo) throws Exception;
	public List<ChatVO> read(String uid) throws Exception;
	public void delete(String uid) throws Exception;
	public List<ChatVO> listAll() throws Exception;
	
}
