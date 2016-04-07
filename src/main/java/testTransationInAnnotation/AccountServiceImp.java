package testTransationInAnnotation;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

public class AccountServiceImp implements AccountService{
	
	private DataSource dataSource;
	
	/**
	 *转账
	 *@param sourceAccountId 源账户
	 *@param targetAccountId 目标账户
	 *@param amount 金额
	 * @throws Exception 
	 */
	@Override
	@Transactional (rollbackFor=Exception.class)
	public void transferMoney(long sourceAccountId, long targetAccountId,
			double amount) throws Exception {
		Connection connection=DataSourceUtils.getConnection(dataSource);
		try{
			Statement statement=connection.createStatement();
			statement.executeUpdate("UPDATE moneyinfo SET moneyNum=moneyNum-"+amount+" where id='"+sourceAccountId+"'");
			//测试事务是否起作用
			//if(1==1)
			//throw new SQLException("000");
			statement.executeUpdate("UPDATE moneyinfo SET moneyNum=moneyNum+"+amount+" where id='"+targetAccountId+"'");
			//即使没有异常也可以通过以下代码回滚
			//TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			System.out.println("转账成功！");
		}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			DataSourceUtils.releaseConnection(connection, dataSource);
		}
	}
	
	/**
	 * 注入dataSource
	 * @param dataSource
	 */
	
	public void setDataSource(DataSource dataSource){
		this.dataSource=dataSource;
	}
}
