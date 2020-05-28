import java.util.*;
import java.io.*;

public class concessions extends payment {

	double totalCost = 0;

	File foodOptions = new File("/Users/abiel/Desktop/JavaReferecedFiles/foodMenuDb.txt");


	public void foodOptions() throws IOException {

		System.out.println("Welcome to Dream Concessions!");
		Scanner foodScan = new Scanner(System.in);
		System.out.println("Would you like to purchase any concessions?(yes/no): ");
		String purchase = foodScan.nextLine();


		if(purchase.equalsIgnoreCase("no")) {
			System.out.println("Thank you for visitng Dream Concessions. Enjoy the Movie!");
			System.exit(1);
		}


		else if(purchase.equalsIgnoreCase("yes") || purchase.equalsIgnoreCase("y")) {
			printFood();
		}
	}


	public void printFood() throws IOException {

		Scanner scaning = new Scanner(foodOptions);
		Scanner scan = new Scanner(foodOptions);

		for(int m = 0; m < menu.length; m++) {
			menu[m]	= scaning.nextLine();
		}

		while(scan.hasNext()) {
			System.out.println(scan.nextLine());
		}

		selectFood();
	}


	public void selectFood() throws IOException {


		Scanner foodSelection = new Scanner(System.in);
		System.out.println("Please select the item you want to purchase");
		int foodPurchase = foodSelection.nextInt();

		System.out.println("You have selected: " + menu[foodPurchase+1]);

		totalCost += concessionCost[foodPurchase-1];

		System.out.println("your total cost is: " + totalCost);

		Scanner again = new Scanner(System.in);
		System.out.println("Would you like to purchase any other conesssions?: ");
		String another = again.nextLine();

		if(another.equalsIgnoreCase("yes") || another.equalsIgnoreCase("y")) {
			printFood();
		}

		else {
			paymentSelection();
			System.out.println("Thank you for your purchase of concession");
			System.exit(1);
		}

	}



}