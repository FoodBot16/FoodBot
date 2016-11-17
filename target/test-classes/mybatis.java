

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"}
		)
public class mybatis {

	@Inject
	SqlSessionFactory sf;
	@Inject
	SqlSession ss;
	@Test
	public void test() throws Exception{
		
//		BoardVO vo = new BoardVO();
//		vo.setContent("11111");
//		vo.setTitle("1111");
//		vo.setWriter("22aerhaerh");
//		dao.create(vo);
		//System.out.println(sf);
		System.out.println(ss);
	}
}
