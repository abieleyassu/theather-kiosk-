import java.util.*;
import java.io.*;
import java.math.*;

public class boxOffice {

	File showing = new File("/Users/abiel/Desktop/JavaReferecedFiles/showTime.txt");
	File movies = new File("/Users/abiel/Desktop/JavaReferecedFiles/movies.txt");
	File seating = new File("/Users/abiel/Desktop/JavaReferecedFiles/seatingChart.txt");
	File seatingSelect = new File("/Users/abiel/Desktop/JavaReferecedFiles/seatingSelections.txt");
	File seatingRecord = new File("/Users/abiel/Desktop/JavaReferecedFiles/seatingSelection.txt");
	File paymentInformation = new File("/Users/abiel/Desktop/JavaReferecedFiles/paymentInformation.txt");
	
	ArrayList<String> showTime = new ArrayList(); 
	//Holds all of the show times to select from when read from the local file database
	//Helps make the selection easier to make and helps return the user selection quicker 

	String[] movie = new String[14];
	//Holds the movies that are stored in the local movies.txt database
	String[] menu = new String[14];

	ArrayList<String> promotion = new ArrayList();
	
	double[] concessionCost = {5.20, 8.30, 11.45, 4.15, 3.45, 2.20, 4.50, 6.12, 2.17, 3.99, 1.99, 3.99};
	
	ArrayList<String> seats= new ArrayList();
	
	double pastMemberSaving = .20;
	double newMemberSaving = .15;

	int adult = 0;
	//Number of adult tickets
	int kid = 0;
	//Number of tickets for children
	double adultTicket = 11.30;
	double kidTicket = 8.45;
	int showTimeSelection = 0;
	double finalTicket = 0; 
	int choice = 0;
	String name = "";
	String memberStatus = "";
	String phoneNumber;
	boolean membership;
	String promoCode = "";
	String paymentMethod = "";
	BigInteger cardNumber;
	int ccv = 0;
	String expirationDate = "";
	int securityCodes = 0; 
	String seater = "";
	
	public static final String ANSI_RED = "\u001B[31m";
	
	

	public void theaterEnterance() throws IOException { 

		Scanner enterance = new Scanner(System.in);
		System.out.println("Welcome to Dreamland Theater!");
		System.out.println("\n" + "Would you like to buy a ticket?(yes/no): ");
		String answer = enterance.nextLine();

		if(answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
			showTime();
		}

		else {
			
			System.out.println("Thank you for visiting The Dream Land Theaters");
			System.exit(1);
		}

	}
	
	
	
	public void showTime() throws IOException {

		Scanner show = new Scanner (showing); //Scanner used to scan line by line through local file
		Scanner selectShowTime = new Scanner(System.in);
		Scanner find = new Scanner(showing);
		//Scanner used to take in user input regarding their show time choice


		while(show.hasNext()) { //Loops through the file until there isn't a line
			showTime.add(show.nextLine()); 
			// Adds each line of the file to the showTime ArrayList
		}


		for(int z = 0; z < showTime.size(); z++) {
			System.out.println("\n" + find.nextLine());
			//Loops through the local file to print out the contents of the file 
		}

		System.out.println("Please select a show time (Select the number): \n");
		//System.out.println();
		showTimeSelection = selectShowTime.nextInt(); 
		//User input prompt


		movies();
	}

	
	

	public void movies() throws IOException{

		Scanner scan = new Scanner (movies);
		Scanner screening = new Scanner(movies); 

		int r = 0;
		while(scan.hasNext()) {
			movie[r] = scan.nextLine();
			r++;
		}

		while(screening.hasNext()) {
			System.out.println("\n" + screening.nextLine());
		}


		Scanner movieChoice = new Scanner(System.in);
		System.out.println("Please select the movie you want to watch (Input #): ");
		choice = movieChoice.nextInt();


		guestInfo();
	}




	public void guestInfo() throws IOException {
		
		Scanner nameEntery = new Scanner(System.in);
		System.out.println("Please enter in your name: ");
		name = nameEntery.nextLine();

		Scanner adults = new Scanner(System.in);
		System.out.println("How many adult guest(s) are attending today?: ");
		adult = adults.nextInt();

		Scanner kids = new Scanner(System.in);
		System.out.println("How many children guest(s) are attending today?");
		kid = kids.nextInt();
		
		System.out.println("\n");
		seatingChart();
	}




	public void seatingChart() throws IOException {

		PrintWriter print = new PrintWriter(new FileWriter(seatingRecord,true));
		Scanner seaters = new Scanner(seating);

		while(seaters.hasNext()) {
			System.out.println(seaters.nextLine());
		}
		
		Scanner seat = new Scanner(seatingSelect);
		
		while(seat.hasNext()) {
			seats.add(seat.nextLine());
		}
		
		
		Scanner sit = new Scanner(System.in);
		
		
		
		for(int m = 0; m < adult; m++) {
			System.out.println("Please select a seating option: ");
			seater = sit.nextLine();
			
			print.println(seater);
		}
		
		for(int z = 0; z < kid; z++) {
			System.out.println("Please select a seating option: ");
			seater = sit.nextLine();
			
			print.println(seater);
		}
		
		print.close();

	}
	
	


}
