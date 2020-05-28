import java.util.*;
import java.io.*;

public class payment extends boxOffice {

	
	public void paymentSelection() throws IOException {
		Scanner payment = new Scanner(System.in);
		System.out.println("Please enter in your method of payment: ");
		paymentMethod = payment.nextLine();
		
		if(paymentMethod.equalsIgnoreCase("credit")) {
			credit();
		}
		
		if(paymentMethod.equalsIgnoreCase("debit")) {
			debit();
		}
		
		if(paymentMethod.equalsIgnoreCase("cash")) {
			
		}
	}
	
	
	public void credit() throws IOException {
		
	PrintWriter writer = new PrintWriter(new FileWriter(paymentInformation, true));
	
	Scanner credit = new Scanner(System.in);
	System.out.println("Please enter in your card number");	
	cardNumber = credit.nextBigInteger();
	
	Scanner CCV = new Scanner(System.in);
	System.out.println("Please enter in your card CCV number(3 Digits): ");
	ccv = CCV.nextInt();
	
	Scanner expire = new Scanner(System.in);
	System.out.println("Please enter in the expiration date: ");
	expirationDate = expire.nextLine();

	writer.println(name);
	writer.println(paymentMethod);
	writer.println(cardNumber);
	writer.println(expirationDate);
	writer.println(ccv);
	writer.close();
	  
	}
	
	public void debit() throws IOException {
		
		PrintWriter writer = new PrintWriter(new FileWriter(paymentInformation, true));
		Scanner credit = new Scanner(System.in);
		System.out.println("Please enter in your card number");	
		cardNumber = credit.nextBigInteger();
		
		Scanner CCV = new Scanner(System.in);
		System.out.println("Please enter in your card CCV number(3 Digits): ");
		ccv = CCV.nextInt();
		
		Scanner securityCode = new Scanner(System.in);
		System.out.println("Please enter in your security code: ");
		securityCodes = securityCode.nextInt();
		
		
		Scanner expire = new Scanner(System.in);
		System.out.println("Please enter in the expiration date: ");
		expirationDate = expire.nextLine();
		
		writer.println(name);
		writer.println(paymentMethod);
		writer.println(cardNumber);
		writer.println(expirationDate);
		writer.println(ccv);
		writer.println(securityCodes);
		writer.close();
		
	}
	
	
}
