package testAOP;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.aop.MethodBeforeAdvice;

public class BeforeAcvise implements MethodBeforeAdvice{
	
	/**
	 * 为所有的招待者添加前置通知，在与客户商量事情之前先问候
	 */
	@Override
	public void before(Method arg0, Object[] arg1, Object arg2)
			throws Throwable {
		System.out.println("见到你真高兴！");
	}
	
	/**
	 * 在Reception执行之前执行
	 * @param point 给Reception的参数会传入
	 * 
	 */
	public void before2(JoinPoint point){
		Object args[]=point.getArgs();
		System.out.println("方法名："+point.getSignature().getName()+"见到你真高兴！"+String.valueOf(args[1]));
	}
	
	
	/**
	 * 抛出异常之后
	 * @param point
	 */
	public void afterThrow(JoinPoint point){
		Object args[]=point.getArgs();
		System.out.println("抛出了异常：");
		try{
			throw new Exception();
		}
		catch(Exception e){
			System.out.println("我我我");
		}
	}
	
	public void arroundTest(ProceedingJoinPoint jp) throws Throwable{
		System.out.println("开始执行");
		long startTime=System.currentTimeMillis();
		String className=jp.getTarget().getClass().getCanonicalName();
		String methodName=jp.getSignature().getName();
		jp.proceed();
		System.out.println("结束执行");
		long endTime=System.currentTimeMillis();
		System.out.println("花费时间"+(startTime-endTime));
	}
}
