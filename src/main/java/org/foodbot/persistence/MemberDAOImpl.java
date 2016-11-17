package org.foodbot.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.foodbot.domain.MemberVO;
import org.foodbot.dto.LoginDTO;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	@Inject
	SqlSession session;
	
	private static String namespace = "org.foodbot.mapper.MemberMapper";

	@Override
	public void create(MemberVO vo) throws Exception {
		session.insert(namespace+".create",vo);
	}

	@Override
	public MemberVO read(Integer mno) throws Exception {
		return session.selectOne(namespace+".read",mno);
	}

	@Override
	public void update(MemberVO vo) throws Exception {
		session.update(namespace+".update",vo);
		
	}

	@Override
	public void delete(Integer mno) throws Exception {
		session.delete(namespace+".delete",mno);
		
	}

	@Override
	public MemberVO login(LoginDTO dto) throws Exception {
		return session.selectOne(namespace + ".login",dto);
	}
	
	@Override
	public List<MemberVO> listAll() throws Exception {
		return null;
	}

	

}
