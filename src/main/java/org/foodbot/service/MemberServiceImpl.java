package org.foodbot.service;

import java.util.List;

import javax.inject.Inject;

import org.foodbot.domain.MemberVO;
import org.foodbot.dto.LoginDTO;
import org.foodbot.persistence.MemberDAO;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	MemberDAO dao;
	
	
	@Override
	public void regist(MemberVO vo) throws Exception {
		dao.create(vo);
		
	}

	@Override
	public MemberVO read(Integer mno) throws Exception {
		return dao.read(mno);
	}

	@Override
	public void update(MemberVO vo) throws Exception {
		dao.update(vo);
		
	}

	@Override
	public void delete(Integer mno) throws Exception {
		dao.delete(mno);
	}

	@Override
	public MemberVO login(LoginDTO dto) throws Exception {
		return dao.login(dto);
	}
	
	@Override
	public List<MemberVO> listAll() throws Exception {
		return null;
	}

	

}
