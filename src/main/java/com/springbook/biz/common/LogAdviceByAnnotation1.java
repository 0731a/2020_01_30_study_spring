package com.springbook.biz.common;

import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service // 스프링 컨테이너에 의해 컴포넌트가 검색 되어 생성될 수 있게 함 
@Aspect // 스프링 컨테이너가 해당 객체를 aspect 객체로 인식, Aspect = PointCut + Advice 
public class LogAdviceByAnnotation1 { // Aspect가 설정된 aspect 객체에는 반드시 포인트 컷과 어드바이스를 결합하는 설정이 있어야 함 
	
	// 두 메소드( 포인트 컷 메소드, 어드바이스 메소드 ) 에 설정된 어노테이션에 의해 위빙 처리
	// 위빙(weaving) : 포인트 컷으로 지정된 핵심 관심 메소드가 호출 될 때, 어드바이스에 해당하는 횡단 관심 메소드가 삽입되는 과정 
	// 				   스프링 에서는 런타임 위빙 방식 지원
	// -> 어드바이스 클래스 마다 포인트 컷 설정 필요, 포인트 컷의 재활용 불가 
	
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))") //포인트 컷 메소드 
	public void allPointcut() {} // 포인트 컷 식별을 위한 참조 메소드 
	
	@Before("allPointcut()") // 어드바이스 메소드 
	public void printLog() {
		System.out.println("[공통 로그] 비즈니스 로직 수행 전 동작");
	}
}
