package sms;


import bank.domain.Account;
import bank.service.IObserver;

public class SMSSender implements IObserver {


	public void sendSMS(String msg) {
		System.out.println("Sending SMS..." + msg);
	}

	public void update(Account account) {
		String msg = "your account "+account.getAccountnumber()+" is changed, your current balance is :"+account.getBalance();
		sendSMS(msg);

	}

}

