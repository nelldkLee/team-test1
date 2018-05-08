package org.zerock.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Setter(onMethod_ = { @Autowired })
	private BoardMapper mapper;
	
	@Test
	public void testList() {
		Criteria cri = new Criteria(1);
		cri.setType("t");
		cri.setKeyword("gkgk");
		
		List<BoardVO> list = mapper.list(cri);
		list.forEach(vo -> log.info(vo));
		
	}
	@Test
	public void testInsert() {
		BoardVO vo = new BoardVO();
		vo.setTitle("gkgk");
		vo.setContent("contenttest");
		vo.setWriter("testwriter");
		
		mapper.insert(vo);
	}
	
	@Test
	public void testRead() {
		mapper.read(10);
		
	}
	@Test
	public void testUpdate() {
		BoardVO vo = mapper.read(10);
		vo.setTitle("set");
		vo.setContent("setset");
		vo.setWriter("수정완료");
		mapper.update(vo);
		mapper.read(10);
	}
	@Test
	public void testDelete() {
		mapper.delete(10);
	}
	
	@Test
	public void testGetTotal() {
		Criteria cri = new Criteria();
		//cri.setType("t-c-w");
		cri.setKeyword("title3");
		log.info(mapper.getTotal(cri));
	}

	

}
