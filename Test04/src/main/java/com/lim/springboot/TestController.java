package com.lim.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private BoardDAO boardDAO;
	
	@RequestMapping("/")
	public @ResponseBody String root() {
		return "JdbcTemplate 실습";
	}
	
	@RequestMapping(value="/memberList",method=RequestMethod.GET)
	public String memberList(Model model) {
		model.addAttribute("datas", memberDAO.selectAll());
		return "memberList";
	}
	
	@RequestMapping("/a")
	public String a(Model model) {
		model.addAttribute("datas", boardDAO.selectAll(null));
		return "a";
	}
	@RequestMapping("/b")
	public String b() {
		return "page";
	}
	@RequestMapping("/c")
	public String c(BoardDTO dto) {
		boardDAO.insert(dto);
		return "redirect:a";
	}
	@RequestMapping("/d")
	public String d(BoardDTO dto) {
		boardDAO.delete(dto);
		return "redirect:a";
	}
	@RequestMapping("/e")
	public String e(BoardDTO dto,Model model) {
		model.addAttribute("data", boardDAO.selectOne(dto));
		return "b";
	}
}
