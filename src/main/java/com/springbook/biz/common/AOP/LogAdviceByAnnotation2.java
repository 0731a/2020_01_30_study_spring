package com.springbook.biz.common.AOP;

import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service // ������ �����̳ʿ� ���� ������Ʈ�� �˻� �Ǿ� ������ �� �ְ� �� 
@Aspect // ������ �����̳ʰ� �ش� ��ü�� aspect ��ü�� �ν�, Aspect = PointCut + Advice 
public class LogAdviceByAnnotation2 { // Aspect�� ������ aspect ��ü���� �ݵ�� ����Ʈ �ư� �����̽��� �����ϴ� ������ �־�� �� 
	
	// Ŭ���� ���� �����̽��� PointCutCommon ���� ���� �Ǿ� �ִ� pointCut�� ���� 
	
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))") //����Ʈ �� �޼ҵ� 
	public void allPointcut() {} // ����Ʈ �� �ĺ��� ���� ���� �޼ҵ� 
	
	@Before("PointcutCommon.allPointcut()") // �����̽� �޼ҵ� 
	public void printLog() {
		System.out.println("[���� �α�] Annotation2, adivce�� pointcut �и� ");
	}
}
