package testTransationInAnnotation;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;
/**
 * 使用编程式事务的配置类
 * @author 宋世鹏
 *
 */
@Configuration
public class TransactionConfigInTemplate {
	
	/**
	 * 配置DataSource以便注入
	 * @return
	 */
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource =new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost/testSpring?useUnicode=true&characterEncoding=Utf-8");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}
	
	/**
	 * 配置bean
	 * @return
	 */
	@Bean
	public PlatformTransactionManager transactionManager(){
		DataSourceTransactionManager transactionManager=new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource());
		return transactionManager;
	}
	
	/**
	 * 配置bean
	 * @return
	 */
	@Bean
	public AccountService accountService(){
		AccountServiceImpInTemplate ac=new AccountServiceImpInTemplate();
		ac.setDataSource(dataSource());
		ac.setTransactionTemplate(transactionTemplate());
		return ac;
	}
	
	/**
	 * 配置bean
	 * @return
	 */
	@Bean
	public TransactionTemplate transactionTemplate(){
		TransactionTemplate ttp=new TransactionTemplate();
		ttp.setTransactionManager(transactionManager());
		return ttp;
	}
}
