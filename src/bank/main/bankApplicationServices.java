package bank.main;

public interface bankApplicationServices {
	
	void mainMenu();
	void checkBalance(bankApplicationSetUp bank);
	void deposit(bankApplicationSetUp bank);
	void withdrawal(bankApplicationSetUp bank);

}
