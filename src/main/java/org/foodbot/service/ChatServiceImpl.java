package org.foodbot.service;

import java.util.List;

import javax.inject.Inject;

import org.foodbot.domain.ChatVO;
import org.foodbot.persistence.ChatDAO;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService {

	@Inject
	ChatDAO dao;
	
	@Override
	public void create(ChatVO vo) throws Exception {
		dao.create(vo);
	}

	@Override
	public List<ChatVO> read(String uid) throws Exception {
		return dao.read(uid);
	}

	@Override
	public void delete(String uid) throws Exception {
		dao.delete(uid);
	}

	@Override
	public List<ChatVO> listAll() throws Exception {
		return dao.listAll();
	}

}
