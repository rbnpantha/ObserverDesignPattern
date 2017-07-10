package email;

import java.util.Date;
import bank.domain.Account;
import bank.service.IObserver;

public class EmailSender implements IObserver {


	public void sendEmail(String msg) {
		System.out.println("Sending email..."  + msg + "by date" + new Date());
	}

	public void update(Account account) {
		// check if account is new
		if (account.getBalance() == 0.0) {
			String msg = "new account " + account.getAccountnumber()
					+ " is created ";
			sendEmail(msg);
		}
	}

}
