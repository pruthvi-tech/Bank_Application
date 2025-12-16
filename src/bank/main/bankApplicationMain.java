package bank.main;
import java.util.InputMismatchException;
import java.util.Scanner;

public class bankApplicationMain implements bankApplicationServices {

	  static Scanner sc = new Scanner(System.in);
	  static int userChoice =0;
	  
	public void mainMenu() {
		System.out.println("1.Check Balance");
		System.out.println("2.Deposit");
		System.out.println("3.Withdrawal");
		System.out.println("4.Exit");
		System.out.println();
		userChoice =sc.nextInt();
	}
	//deposit Method
  public void deposit( bankApplicationSetUp bank) {
	  while(true) {
	  try {
		  System.out.println("Enter The Amout :");
	  double depositAmount = sc.nextDouble();
	  bank.setCurrentBalance(bank.getCurrentBalance()+ depositAmount);
	  System.out.println("Deposit Successful");
	  break;
	  }catch(InputMismatchException inputMismatch) {
		  System.out.println("Enter the Amount in Numbers Only-- Please Provide");
		  sc.nextLine();
	  }
	  }
  }
  public void withdrawal(bankApplicationSetUp bank) {
	  while(true) {
	  try {
		 System.out.println("Enter The Amount To Withdrawal");
		 double amount = sc.nextDouble();
		 if(amount > bank.getCurrentBalance()) {
			 System.out.println("Insufficient Balance");
		 } else {
			 bank.setCurrentBalance(bank.getCurrentBalance()-amount);
			 System.out.println("Successfully Withdrawal");
		 }
		 break;
	  }catch(InputMismatchException inputMismatch) {
		  System.out.println("Please Provide Amount in Numbers Only ---");
		  sc.nextLine();
		  
	  }
	  }
  }
  public void checkBalance(bankApplicationSetUp bank) {
	  System.out.println("The Balance:"+bank.getCurrentBalance());
	  
  }
	
	public static void main(String[] args) {
		
		bankApplicationSetUp bankRun = new bankApplicationSetUp();
		bankApplicationServices bankServices = new bankApplicationMain();
		try {
		do {
			bankServices.mainMenu();
			switch(userChoice) {
			
			case 1: {
				bankServices.checkBalance(bankRun);
				break;
			}
			case 2 : {
				bankServices.deposit(bankRun);
				break;
			}
			case 3: {
				bankServices.withdrawal(bankRun);
				break;
			}
			default: System.out.println("Thank You For Using Our Services Vist Again!!");
			}
		}while(userChoice !=4);
		
		}finally {
			sc.close();
		}
	}

}