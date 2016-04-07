package testAOP;
/**
 * 抛出异常后通知
 * @author 宋世鹏
 */
import org.springframework.aop.ThrowsAdvice;

public class AfterException implements ThrowsAdvice{
	
	/**
	 * 抛出异常后通知
	 * @param ex
	 */
	public void afterThrowing(Exception ex){
		System.out.println(ex.getMessage());
		try{
			throw new Exception();
		}
		catch(Exception e){
			System.out.println("我我我");
		}
	}
}
