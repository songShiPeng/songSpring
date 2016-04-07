package testAOP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class TestBeforeAcvice {
	@Autowired
	//static Reception rec;spring不支持static
	/**测试前置通知
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ApplicationContext ctx=new ClassPathXmlApplicationContext("/applicationContext.xml");
		Reception rec=(Reception) ctx.getBean("reception");
		rec.sayHelllow("李三","宋世鹏");
		//rec.throwException();
		System.out.println("我继续执行");
	}

}
