package edu.csupomona.cs.cs241.prog_assgnmnt_1;

import java.util.Scanner;

public class UserInterface {

	Scanner sc = new Scanner(System.in);
	
	public void welcome() {
		System.out.println(" -- Table Manager -- ");
	}
	
	public void displayMenu() {
		System.out.println("\n+=====+");
		System.out.println("[1] Add Entry"); // Add New Customer
		System.out.println("[2] Remove Entry"); // Remove Customer
		System.out.println("[3] Search Entries"); // Find Next Customer
		System.out.println("[4] Display Entries"); // List Customers By Priority
		System.out.println("[5] Exit.");
		System.out.print("\nEnter a command: ");
	}
	
	public void chooseMenuOption() {
		int choice = 0;

		System.out.println();
		//addEntries(registry);

		while (choice == 0) {
			displayMenu();
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				//addEntries(registry);
				//save();
				choice = 0;
				break;
			case 2:
				//removeEntries(registry);
				//save();
				choice = 0;
				break;
			case 3:
				//searchEntries(registry);
				choice = 0;
				break;
			case 4:
				//sortEntries(registry);
				choice = 0;
				break;
			case 5:
				//save();
				System.out.println(" -- Application Closed -- ");
				System.exit(0);
			default:
				choice = 0;
				System.out.println("Invalid Input.");
				break;
			}
		}
	}
}
