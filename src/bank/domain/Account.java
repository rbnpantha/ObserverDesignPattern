package bank.domain;

import java.util.*;

import bank.service.IObserver;
import bank.service.ISubject;

public class Account implements ISubject {
	long accountnumber;
	private Collection<IObserver> observerlist = new ArrayList<IObserver>();
	Collection<AccountEntry> accountEntryList = new ArrayList<AccountEntry>();
	Customer customer;

	
	public void registerObserver(IObserver observer) {
		observerlist.add(observer);

	}

	
	public void notifyObserver(Account account) {
		for (IObserver observer : observerlist) {

			observer.update(account);

		}

	}

	public Account(long accountnr) {
		this.accountnumber = accountnr;
	}

	public long getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(long accountnumber) {
		this.accountnumber = accountnumber;
	}

	public double getBalance() {
		double balance = 0;
		for (AccountEntry entry : accountEntryList) {
			balance += entry.getAmount();
		}
		return balance;
	}

	public void deposit(double amount) {
		AccountEntry entry = new AccountEntry(new Date(), amount, "deposit",
				"", "");
		accountEntryList.add(entry);
		notifyObserver(this);

	}

	public void withdraw(double amount) {
		AccountEntry entry = new AccountEntry(new Date(), -amount, "withdraw",
				"", "");
		accountEntryList.add(entry);
		notifyObserver(this);

	}

	private void addEntry(AccountEntry entry) {
		accountEntryList.add(entry);
	}

	public void transferFunds(Account toAccount, double amount,
			String description) {
		AccountEntry fromEntry = new AccountEntry(new Date(), -amount,
				description, "" + toAccount.getAccountnumber(), toAccount
						.getCustomer().getName());
		AccountEntry toEntry = new AccountEntry(new Date(), amount,
				description, "" + toAccount.getAccountnumber(), toAccount
						.getCustomer().getName());
		accountEntryList.add(fromEntry);
		toAccount.addEntry(toEntry);
		notifyObserver(this);
		notifyObserver(toAccount);

	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Collection<AccountEntry> getaccountEntryList() {
		return accountEntryList;
	}

}
