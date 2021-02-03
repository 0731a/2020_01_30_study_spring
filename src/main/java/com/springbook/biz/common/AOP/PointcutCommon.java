package com.springbook.biz.common.AOP;

import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Aspect;

// 포인트 컷의 재활용을 위하여 포인트 컷을 모아 놓은 독립된 클래스 
@Aspect
public class PointcutCommon {
	
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))") //포인트 컷 메소드 
	public void allPointcut() {} // 포인트 컷 식별을 위한 참조 메소드 
	
	@Pointcut("execution(* com.springbook.biz..*Impl.get*(..))") //포인트 컷 메소드 
	public void getPointcut() {} // 포인트 컷 식별을 위한 참조 메소드 
	
}
