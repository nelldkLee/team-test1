package org.zerock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageMaker;
import org.zerock.persistence.BoardService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@Log4j
public class BoardController {
	
	@Setter(onMethod_ = { @Autowired })
	private BoardService service;
	
	// localhost:8080/board/list?page=3&type=t-w&keyword="~~"
	@GetMapping("/list")
	public void list(@ModelAttribute("cri")Criteria cri,Model model) {
		
		List<BoardVO> list = service.list(cri);
		model.addAttribute("pageMaker",new PageMaker(cri, service.getTotal(cri)));
		model.addAttribute("list", list);
	}
	@GetMapping("/register")
	public void register() {
		log.info("register.... call");
	}
	
	@PostMapping("/register")
	public String register(BoardVO vo,RedirectAttributes rttr) {
		log.info("register.... call");
		int result = service.register(vo);
		buildRedirectAttribute(rttr, service.register(vo));
		return "redirect:/board/list";
	}
	
	
	@GetMapping("/read")
	public void read(@ModelAttribute("cri")Criteria cri, int bno,Model model) {
		log.info("read.... call");
		BoardVO vo = service.read(bno);
		model.addAttribute("boardVO", vo);
	}
	
	@GetMapping("/modify")
	public void modify(@ModelAttribute("cri")Criteria cri, int bno,Model model) {
		log.info("read.... call");
		model.addAttribute("boardVO", service.read(bno));
	}
	@PostMapping("/modify")
		public String modify(BoardVO vo,RedirectAttributes rttr) {
		log.info("modify........ok");
		int result = service.modify(vo);
		buildRedirectAttribute(rttr, service.register(vo));
		return "redirect:/board/read?bno="+vo.getBno();
		
	}
	
	@PostMapping("/delete")
	public ResponseEntity<String> delete(int bno) {
		log.info("delete good..");
		String msg = service.delete(bno) == 1 ? "success" : "fail";
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	
	public void buildRedirectAttribute(RedirectAttributes rttr,int result) {
		String msg = result == 1 ? "success" : "Fail";
		rttr.addFlashAttribute("msg", msg);
		}
		
	}
	
