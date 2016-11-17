package org.foodbot.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.foodbot.domain.BoardVO;
import org.foodbot.domain.ChatVO;
import org.springframework.stereotype.Repository;

@Repository
public class ChatDAOImpl implements ChatDAO {
	
	private static String namespace = "org.foodbot.mapper.ChatMapper";

	@Inject
	SqlSession session;
	
	@Override
	public void create(ChatVO vo) throws Exception {
		session.insert(namespace+".create",vo);
	}

	@Override
	public List<ChatVO> read(String uid) throws Exception {
		return session.selectList(namespace+".read",uid);
	}

	@Override
	public void delete(String uid) throws Exception {
		session.delete(namespace+".delete",uid);
	}

	@Override
	public List<ChatVO> listAll() throws Exception {
		return session.selectList(namespace+".listAll");
	}


}
