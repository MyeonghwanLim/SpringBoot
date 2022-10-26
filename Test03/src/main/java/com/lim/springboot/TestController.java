package com.lim.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	
	@RequestMapping("/")
	public @ResponseBody String root() {
		return "Validator 실습";
	}
	
	@RequestMapping("/insertPage")
	public  String insertPage() {
		return "insertPage";
	}
	
	@RequestMapping("/insert")
	public  String insert(DataDTO dto, BindingResult result) {
		//null 값이 들어올수도있어 insert page에 받은정보를 다시보내주기위해 모델어트리뷰트 사용
		String viewName = "boardPage";
		
		System.out.println("로그: TestController: insert 메서드: dto: "+ dto);
		DataValidator validator = new DataValidator();
		validator.validate(dto, result); // result는 참조변수 ★ 
		
		
		if(result.hasErrors()) { // 에러가 발견되었다면, 
			viewName="insertPage"; // 다시 작성페이지로 이동
		}
		return viewName;
	}
	
	
	
}
