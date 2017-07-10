package bank;

import java.util.Collection;

import bank.domain.Account;
import bank.domain.AccountEntry;
import bank.domain.Customer;
import bank.service.AccountService;
import bank.service.IAccountService;

public class Application {
	public static void main(String[] args) {
		IAccountService accountService = new AccountService();

		// creating 2 accounts;
		accountService.createAccount(123456, "Rabin Panth");
		accountService.createAccount(789456, "Rakesh Shreevastav");

		// deposit and withdraw on account 1;
		accountService.deposit(123456, 500);
		accountService.deposit(123456, 850);
		accountService.withdraw(123456, 300);
		
		// deposit and transfer on account 2;
		accountService.deposit(789456, 69853);
		accountService.transferFunds(123456, 789456, 200, "mony is transfered");
		
		// showing balances
		Collection<Account> accountlist = accountService.getAllAccounts();
		Customer customer = null;
		for (Account account : accountlist) {
			customer = account.getCustomer();
			System.out.println("Statement for Account: "+ account.getAccountnumber());
			System.out.println("Account Holder: " + customer.getName());
			System.out.println("Date............................."+ "Description............."+ "Amount...............");
			for (AccountEntry entry : account.getaccountEntryList()) {
				System.out.println(entry.getDate()+"   " + entry.getDescription() +"              amount: "+ entry.getAmount());
			}
			
			System.out.println("Current Balance:"+ account.getBalance());
		}
	}

}
