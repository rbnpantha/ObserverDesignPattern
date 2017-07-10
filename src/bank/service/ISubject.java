package bank.service;

import bank.domain.Account;

public interface ISubject {

	public void registerObserver(IObserver observer);

	public void notifyObserver(Account account);

}