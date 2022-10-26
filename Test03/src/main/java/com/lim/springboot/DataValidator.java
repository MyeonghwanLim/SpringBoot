package com.lim.springboot;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class DataValidator implements Validator { // 유효성 검사 객체

	@Override
	public boolean supports(Class<?> clazz) {  // 8~12 라인 건드리면 앙대
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) { 
		// Object target : 사용자의 입력 값(커맨드 객체)을 검증하기위해, 파라미터로 받을 수 있게 구현한 부분
		// -> 디자인 패턴을 활용한 예: 부오에게 자식을 대입 가능
		
		DataDTO dto = (DataDTO)target; // DataDTO 타입으로 캐스팅
		
		// 커맨드 객체에 저장된 값을 추출
		String writer = dto.getWriter();
		// null 은 할당을 못받은 것이고 isEmpty 는 공백값이 들어온 것이다.
		if(writer==null || writer.trim().isEmpty()) { // ★ null 체크 순서 유의!!! 
			System.out.println("로그: DataValidator: validate 메서드 : 작성자 null or empty");
			errors.rejectValue("writer", "error");
		}
		
		String content = dto.getContent();
		if(content==null || content.trim().isEmpty()) { // ★ null 체크 순서 유의!!! 
			System.out.println("로그: DataValidator: validate 메서드 : 작성자 null or empty");
			errors.rejectValue("writer", "error");
		}
		
	} 

}
