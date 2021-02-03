package com.springbook.biz.common.AOP;

import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service // 스프링 컨테이너에 의해 컴포넌트가 검색 되어 생성될 수 있게 함 
@Aspect // 스프링 컨테이너가 해당 객체를 aspect 객체로 인식, Aspect = PointCut + Advice 
public class LogAdviceByAnnotation2 { // Aspect가 설정된 aspect 객체에는 반드시 포인트 컷과 어드바이스를 결합하는 설정이 있어야 함 
	
	// 클래스 내의 어드바이스는 PointCutCommon 내에 설정 되어 있는 pointCut을 참조 
	
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))") //포인트 컷 메소드 
	public void allPointcut() {} // 포인트 컷 식별을 위한 참조 메소드 
	
	@Before("PointcutCommon.allPointcut()") // 어드바이스 메소드 
	public void printLog() {
		System.out.println("[공통 로그] Annotation2, adivce와 pointcut 분리 ");
	}
}
