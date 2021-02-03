package com.springbook.biz.common.AOP;

import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Aspect;

// ����Ʈ ���� ��Ȱ���� ���Ͽ� ����Ʈ ���� ��� ���� ������ Ŭ���� 
@Aspect
public class PointcutCommon {
	
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))") //����Ʈ �� �޼ҵ� 
	public void allPointcut() {} // ����Ʈ �� �ĺ��� ���� ���� �޼ҵ� 
	
	@Pointcut("execution(* com.springbook.biz..*Impl.get*(..))") //����Ʈ �� �޼ҵ� 
	public void getPointcut() {} // ����Ʈ �� �ĺ��� ���� ���� �޼ҵ� 
	
}
