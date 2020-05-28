import java.util.*;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.io.*;
import java.math.BigInteger;

public class membership extends concessions {

	File phoneNumbers = new File("/Users/abiel/Desktop/JavaReferecedFiles/phoneDb.text");
	File email = new File("/Users/abiel/Desktop/JavaReferecedFiles/emailPromoDb.txt");
	File phoneProviders = new File("/Users/abiel/Desktop/JavaReferecedFiles/phoneProviders.txt");
	File providerNames = new File("/Users/abiel/Desktop/JavaReferecedFiles/phoneProviders Names.txt");



	public void checkMembership() throws IOException, MessagingException {


		Scanner cardHolder = new Scanner(System.in);
		System.out.println("Are you a current card holding member?(yes/no): ");
		memberStatus = cardHolder.nextLine();


		if(memberStatus.equalsIgnoreCase("no") || memberStatus.equalsIgnoreCase("n")) {
			membershipStatus();
		}

		phoneCheck();

	}




	public void phoneCheck() throws IOException, MessagingException {

		Scanner enterPhone = new Scanner(System.in);
		System.out.println("Please enter in your phone number: ");
		phoneNumber = enterPhone.nextLine();

		Scanner scanPhone = new Scanner(phoneNumbers);


		while(scanPhone.hasNext()) {

			if(scanPhone.nextLine().equals(phoneNumber)) {
				System.out.println("Thank you " + name + " for verifying your membership");
				totalCost = totalCost - (totalCost*pastMemberSaving);
				membership = true;
			}

		}

		if (membership == false){
			System.out.println("Sorry we weren't able to verify your membership.");
			membershipStatus();
		}



	}




	public void membershipStatus() throws IOException, MessagingException {

		Scanner signUp = new Scanner(System.in);
		System.out.println("Would you like to sign up for a membership?(yes/no): ");
		String answer = signUp.nextLine();

		if(answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
			membershipSignUp();
			displayTicket();
		}

		else if (answer.equalsIgnoreCase("no") ||  answer.equalsIgnoreCase("n")){
			displayTicket();
		}
	}





	public void membershipSignUp() throws IOException, MessagingException {

		PrintWriter phone = new PrintWriter(new FileWriter(phoneNumbers, true));
		Scanner newMember = new Scanner(System.in);
		System.out.println("Please enter in your phone number");
		BigInteger newMemberPhone = newMember.nextBigInteger();

		phone.println(newMemberPhone + "\n");
		phone.close();

		System.out.println("Welcome to the Dreamers Rewards Club! \n");

		Scanner codeSend = new Scanner(System.in);
		System.out.println("Would you like to receive your frist offer to get exclusive new membership perk now(yes/no): ");
		String send = codeSend.nextLine();		


		if(send.equalsIgnoreCase("yes") || send.equalsIgnoreCase("y")) {
			codeSending();
		}

		else {
			displayTicket();
		}
	}



	public void codeSending() throws IOException, MessagingException {
		Scanner redeem = new Scanner(System.in);
		System.out.println("Would you like to recieve a text, email, or both to redeem your code: ");
		String method = redeem.nextLine();

		if(method.equalsIgnoreCase("email")) {
			emailCode();
		}

		else if(method.equalsIgnoreCase("text")) {
			textCode();
		}

		else {
			emailCode();
			textCode();
		}

	}



	public void codeCreation() {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWYXYZ1234567890!@#$%^&*()";
		int wordLength = 7; 

		Random rand = new Random();

		char[] code = new char[wordLength];

		for(int m = 0; m < wordLength; m ++) {
			code[m] = alphabet.charAt(rand.nextInt(alphabet.length()));
		}

		for(int i  = 0; i < code.length; i++) {
			promoCode += code[i];
		}


		promotion.add(promoCode);
	}




	public void emailCode() throws IOException, MessagingException{

		codeCreation();

		PrintWriter promo = new PrintWriter(new FileWriter(email, true));

		Scanner recepientEmail = new Scanner(System.in);
		System.out.println("Please enter in your email address: ");
		String recepient = recepientEmail.nextLine();


		Properties property = new Properties();

		property.put("mail.smtp.auth", true);
		property.put("mail.smtp.starttls.enable", true);
		property.put("mail.smtp.host", "smtp.gmail.com");
		property.put("mail.smtp.port", "587");


		String myEmail = "aejavadev@gmail.com";
		String password = "Xjff6043";

		Session session = Session.getInstance(property, new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myEmail, password);
			}
		});

		Message msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress(myEmail));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
			msg.setSubject("Hello");
			msg.setText(promoCode);
			Transport.send(msg);

		}catch (MessagingException e){
			e.printStackTrace();
		}

		System.out.println("Message Sent");
		promo.println(promoCode);
		promo.close();

		checkCode();


	}




	public void textCode() throws IOException, MessagingException{
		codeCreation();
		PrintWriter promo = new PrintWriter(new FileWriter(email, true));
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter in your phone number: ");
		String recipents = scan.nextLine();	

		Properties property = new Properties();

		property.put("mail.smtp.auth", true);
		property.put("mail.smtp.starttls.enable", true);
		property.put("mail.smtp.host", "smtp.gmail.com");
		property.put("mail.smtp.port", "587");


		String myEmail = "aejavadev@gmail.com";
		String password = "Xjff6043";






		Scanner scaning = new Scanner(phoneProviders);
		ArrayList<String> providers = new ArrayList();


		Scanner find = new Scanner(providerNames);

		while(scaning.hasNext()) {

			providers.add(scaning.nextLine());

		}


		while(find.hasNext()) {

			System.out.println(find.nextLine());
		}


		Scanner phoneProviders = new Scanner(System.in);
		System.out.println("Please select your cell service provider: ");
		int provider = phoneProviders.nextInt();


		System.out.println(providers.get(provider-1));




		String phoneNum = recipents + providers.get(provider-1); 

		System.out.println(phoneNum);


		Session session = Session.getInstance(property, new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myEmail, password);
			}
		});


		Message msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress(myEmail));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(phoneNum));
			msg.setSubject("Hello");
			msg.setText(promoCode);
			Transport.send(msg);

		}catch (MessagingException e){
			e.printStackTrace();
		}

		System.out.println("Message Sent");
		promo.println(promoCode);
		promo.close();

		checkCode();

	}


	public void checkCode() throws IOException {

		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please enter in your code: ");
		String check = read.readLine();


		Scanner scan = new Scanner(email);


		while(scan.hasNext()) {

			if(scan.nextLine().contains(check) || promotion.contains(check)) {
				System.out.println("Thank you for verifying your code!");
				membership = true;
				totalCost = totalCost - (totalCost*newMemberSaving);
				break;
			}

			else if (!promotion.contains(check)) {
				System.out.println("We are sorry but you have an invalid code");
				break;
			}
		}

	}





	public void displayTicket() {

		finalTicket = (kid*kidTicket) + (adult*adultTicket);
		System.out.println("Here is your Ticket for today: ");
		System.out.println("Movie: " + movie[choice-1]);
		System.out.println("Showtime: " + showTime.get(showTimeSelection));
		System.out.println("Adult(s): " + adult);
		System.out.println("Children(s): " + kid);
		System.out.println("Total Cost: " + finalTicket);
		System.out.println("Membership: " + membership);
	}

	public void runner() throws IOException, MessagingException {
		theaterEnterance();
		displayTicket();
		checkMembership();
		paymentSelection();
		foodOptions();
		paymentSelection(); 


	}
}