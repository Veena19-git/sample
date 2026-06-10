package ATMSimulationSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class ATM {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Welcome to out ATM Machine");
	int password=2004;
	int balance=2000;
	int attempts=3;
	ArrayList<String> a1=new ArrayList<>();
	
	//pin verification loop
	while(attempts>0)
	{
		System.out.println("Enter the pin:");
		int pin;
		try
		{
			pin=sc.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("Invalid pin! Please enter numbers only");
			sc.next();
			continue;
		}
		if(pin==password)
		{
			System.out.println("Your pin is correct");
		
		while(true)
		{
			System.out.println("-------ATM MENU-------");
			System.out.println("1. Check Balance");
			System.out.println("2. Deposit Money");
			System.out.println("3. Withdraw Money");
			System.out.println("4. Bank Statements");
			System.out.println("5. Exit");
			System.out.println("---------------------");
			System.out.println("Enter your choice:");
			int choice;
			try {
				choice=sc.nextInt();
			}
			catch(Exception e)
			{
				System.out.println("Invalid choice! Please enter a number");
				sc.next();
				continue;
			}
			
			//check Balance
			if(choice==1)
			{
				System.out.println("Your current balance is Rs:"+balance);
			}
			
			//deposit money
			else if(choice==2)
			{
				System.out.println("Enter amount to deposit:");
				int deposit=sc.nextInt();
				if(deposit<=0)
				{
					System.out.println("Amount must be greater than 0");
				}
				else {
					balance=balance+deposit;
					a1.add("Deposited amount Rs:"+deposit);
					System.out.println("Deposited amount is Rs:" +deposit+ " New Balance is Rs:" +balance);
				}
				}
			
			//Withdraw money
			else if(choice==3)
			{
				System.out.println("Enter the amount to withdraw:");
				int withdraw=sc.nextInt();
				if(withdraw<=0)
				{
					System.out.println("Amount must be greater than 0");
				}
				else {
					balance=withdraw;
					a1.add("Withdraw Rs:"+withdraw);
					System.out.println("Withdraw amount Rs:" +withdraw+ " 4Remaining Balance is Rs:"+balance);
				}
			}
			
			//Bank Statements
			else if(choice==4)
			{
				System.out.println("Bank Statements:");
				if(a1.isEmpty())
				{
					System.out.println("No recenet transactions");
				}
				else {
					int start=Math.max(a1.size()-5, 0);
					for(int i=start;i<a1.size();i++)
					{
						System.out.println("-" +a1.get(i));
					}
				}
				System.out.println("--------------------");
			}
			else if(choice==5)
			{
				System.out.println("Thank you for using our ATM. Please Visit Again!");
				break;
			}
			else {
				System.out.println("Invalid choice! Please try again");
			}
			}
		break;
		}
		
		//wrong pin logic
		else {
			attempts--;
			System.out.println("Incorrect pin!"+attempts+ "Attempts(s) left"); 
			if(attempts==0)
			{
				System.out.println("Too many incorrect pin attempts. Your card is blocked!");
			}
			
		}
	}
	sc.close();
}
}
