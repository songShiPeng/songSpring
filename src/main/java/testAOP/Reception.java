package testAOP;
/**
 * 招待者类
 * @author 宋世鹏
 *
 */
public class Reception implements ReceptionInterface{
	
	/**
	 *招待者与客户谈论事情
	 * @throws Exception 
	 */
	public void sayHelllow(String rec,String name) throws Exception{
		System.out.println("咱们谈事情吧"+rec);
		
		
	}
	
	public String throwException() throws Exception{
		System.out.println("我要扔异常了");
		if(1==1){
			try{
				throw new Exception("aasd");
			}catch(Exception e){
				
			}
		}
		return "你好";	
	}
}
