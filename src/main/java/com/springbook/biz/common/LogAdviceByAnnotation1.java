package com.springbook.biz.common;

import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service // ������ �����̳ʿ� ���� ������Ʈ�� �˻� �Ǿ� ������ �� �ְ� �� 
@Aspect // ������ �����̳ʰ� �ش� ��ü�� aspect ��ü�� �ν�, Aspect = PointCut + Advice 
public class LogAdviceByAnnotation1 { // Aspect�� ������ aspect ��ü���� �ݵ�� ����Ʈ �ư� �����̽��� �����ϴ� ������ �־�� �� 
	
	// �� �޼ҵ�( ����Ʈ �� �޼ҵ�, �����̽� �޼ҵ� ) �� ������ ������̼ǿ� ���� ���� ó��
	// ����(weaving) : ����Ʈ ������ ������ �ٽ� ���� �޼ҵ尡 ȣ�� �� ��, �����̽��� �ش��ϴ� Ⱦ�� ���� �޼ҵ尡 ���ԵǴ� ���� 
	// 				   ������ ������ ��Ÿ�� ���� ��� ����
	// -> �����̽� Ŭ���� ���� ����Ʈ �� ���� �ʿ�, ����Ʈ ���� ��Ȱ�� �Ұ� 
	
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))") //����Ʈ �� �޼ҵ� 
	public void allPointcut() {} // ����Ʈ �� �ĺ��� ���� ���� �޼ҵ� 
	
	@Before("allPointcut()") // �����̽� �޼ҵ� 
	public void printLog() {
		System.out.println("[���� �α�] ����Ͻ� ���� ���� �� ����");
	}
}
