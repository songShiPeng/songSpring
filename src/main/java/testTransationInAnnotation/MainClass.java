package testTransationInAnnotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	/**测试主类
	 * @author 宋世鹏
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext appCon=new AnnotationConfigApplicationContext(TransactionConfigInTemplate.class);
		AccountService accountService=appCon.getBean(AccountService.class);
		accountService.transferMoney(2,1, 150);
	}

}
