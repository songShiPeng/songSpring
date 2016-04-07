package testTransationInAnnotation;
/**
 * 顶级转账接口
 * @author 14642
 *
 */
public interface AccountService {
	public void transferMoney(long sourceAccountId, long targetAccountId,
			double amount) throws Exception;
}
