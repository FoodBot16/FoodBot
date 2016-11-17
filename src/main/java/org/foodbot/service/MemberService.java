package org.foodbot.service;

import java.util.List;

import org.foodbot.domain.MemberVO;
import org.foodbot.dto.LoginDTO;

public interface MemberService {
	public void regist(MemberVO vo) throws Exception;
	public MemberVO read(Integer mno) throws Exception;
	public void update(MemberVO vo) throws Exception;
	public void delete(Integer mno) throws Exception;
	
	public MemberVO login(LoginDTO dto) throws Exception;
	
	public List<MemberVO> listAll() throws Exception;
}
