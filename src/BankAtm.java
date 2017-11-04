/*This is simple bank application where user can withdraw and deposit funds based on account balance
 *Account balance is the criteria which is considered over here. If funds to withdraw are more than 
 *account balance then error is thrown same is the case if amount to withdraw is more than balance
 *Application has been illustrated as follows*/

import java.util.Scanner;

class BankATMException extends Exception{    //user defined exception class has been extended from Exception
	
	public String toString()                 //toString() method is overridden in user defined exception which displays exception 
	{
		return "Sorry! Amount cannot be withdrawn as your balance may be less than 10000 or you may be having insufficient funds"; //error message
	}
	
}


public class BankAtm {            //main class where all operations take place

	Scanner sc = new Scanner(System.in);
	
	private static double finalbal,amt;   //double variables declared
	
	private static String location, bankName;  //string variables declared
	
	public static int withdraw (double wamt) throws BankATMException  //withdraw is the method of class that throws user-defined exception
	{
		if(finalbal<10000)              //first check is if bal is less than 10000 
		{
			throw new BankATMException();  //if so then error is displayed saying amount cannot be withdrawn
		}
		
		else if(wamt>finalbal)           //if witdraw amount is greater than final balance then exception has to occur
		{
			throw new BankATMException();     //exception handling
		}
		
		else
		{ 
			finalbal=finalbal-wamt;     //if all the above cases fail then final balance is subtracted from amount which is withdrawn
			System.out.println("Updated Balance : "+finalbal);
			System.out.println("Transaction Successful !\n");  //success message
		}
		
		return 0;
	}
	
	public static int deposit()  //method to deposit money
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter amount to be deposited : ");   //amount to be deposited
		amt=sc.nextInt();                                      //input from user
		finalbal=finalbal+amt;                                 //final balance is updated where amount deposited is added
		System.out.println("Account Balance : "+finalbal);  //final account balance printed
		System.out.println("Transaction Successful !\n");  //success message
		if(finalbal>10000)     // as to withdraw account should have greater than 10k funds
		{
			System.out.println("You can now perform withdraw operation");
		}
		else
		{
			double add;
			add=10000-finalbal;  //this much funds more are required to perform withdraw operation
			System.out.println("Add "+add+" to enable withdraw transactions");
		}
		return 0;
	}
	 
	public static int details() //method to store bank details
	{
		Scanner sca = new Scanner(System.in);
		System.out.print("Enter Bank Name : ");  //enter bank name
		bankName=sca.nextLine();  //bank name stored
		System.out.print("Enter Bank Location : ");  //bank location to be entered
		location=sca.nextLine();  //location stored
		return 0;
	}
	
	public static void accdetails() {  //method to display account details
		
		System.out.println("Bank Name : "+bankName);   //display bank name
		System.out.println("Bank Location : "+location); //display location
		System.out.println("Bank Balance : "+finalbal);  //display balance
		System.out.println("Thank You For Transaction !\n");  //success message
	}
	
	public static void main(String[] args) throws BankATMException {  //main method 
	
		Scanner scan = new Scanner(System.in);
		int choice;
		double withamt;
		System.out.println("Note : Account Balance should be greater than 10k to withdraw funds");
		while(true) 
		{                   //loop runs till switch case has been exit
		System.out.println("\n1.Enter Details");
		System.out.println("2.Deposit Amount");
		System.out.println("3.Withdraw Amount");
		System.out.println("4.View Account Details");
		System.out.println("5.Exit");
		
		
		System.out.print("Select your choice : ");  //choice from above options
		choice=scan.nextInt();  //choice stored
		
		switch(choice)  //using switch case
		{
		case 1 : details();    //to store details
				 break;
		
		case 2 : deposit(); //to deposit funds
				 break;
		
		case 3 : System.out.print("Enter amount to withdraw : "); 
				 withamt = scan.nextDouble();
				 withdraw(withamt);  //to withdraw money
				 break;
		
		case 4 : accdetails(); //to display details
				 break;
				 
		case 5 : System.out.println("\nThank You for Transacting with us !");
				 System.exit(0);  //terminate
				 
		default : System.out.println("Wrong Choice !");
				  break;
		
		}//end of switch

		}//end of while loop
	}//end of main

}//end of class
