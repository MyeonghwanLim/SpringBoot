package com.lim.springboot;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lim.springboot.test.Config;
import com.lim.springboot.test.Leader;
import com.lim.springboot.test.Member;

//@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		//SpringApplication.run(TestApplication.class, args);
		
		// 1. IoC 제공해줄 스프링 컨테이너 생성하기
		ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
		// 싱글톤으로 객체 생성 및 관리됨
		
		// 2. @Bean 등록한 객체 사용해보기
		Leader leader1 = (Leader) ac.getBean("leaderA");
		leader1.hello();

		Leader leader2 = (Leader) ac.getBean("lim");
		leader2.hello();
		
		
		Member member = ac.getBean("memberB",Member.class); // 형변환도 가능하지만 나올 아웃풋을 지정할수도있다.
		member.hello("main에서 작성");
		// 순서작성
		
		// 3. 결과 확인
		if(leader1 == leader2) {
			System.out.println("동일한 객체입니다.");
		}
		else {
			System.out.println("동일하지 않습니다.");
		}
	}

}
