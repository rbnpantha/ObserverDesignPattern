package logger;

import java.util.Date;
import bank.domain.Account;
import bank.service.*;

public class Logger implements IObserver {


	public void log(String msg) {
		System.out.println("doing log..."  + msg + "by date" + new Date());
	}

	public void update(Account account) {
		String msg = "Account "+account.getAccountnumber()+" is changed, new balance = "+account.getBalance();
		log(msg);

	}

}
