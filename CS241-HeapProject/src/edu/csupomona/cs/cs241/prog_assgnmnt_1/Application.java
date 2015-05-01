package edu.csupomona.cs.cs241.prog_assgnmnt_1;

import java.util.Scanner;

/*
 *  The application takes as input customer data as they arrive and outputs the next person to be seated. 
 *  When a table becomes available, the seating host ask the program for the next customer to be seated. 
 *  The restaurant has the following class of customers, listed in order of priority: 
 *  
 *  When the host inputs a new customer it is inserted into the heap. 
 *  When the host asks for the next to be seated, the next customer is 
 *  extracted from the heap based on their priority class. 
 */
public class Application {

	NodeHeap<Customer> pq = new NodeHeap();
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		Application app = new Application();
		app.run();
	}
	
	public void run() {
		chooseMenuOption();
	}
	
	public void displayMenu() {
		System.out.println();
		System.out.println("[-- Table Manager --] ");
		System.out.print("[--   MAIN MENU   --] ");
		System.out.println("\n+=====+");
		System.out.println("[1] Queue Customer");
		System.out.println("[2] Seat Customer");
//		System.out.println("[3] Sort Customer");
//		System.out.println("[4] Display Customers");
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
				addEntry();
				choice = 0;
				break;
			case 2:
				removeEntry();
				choice = 0;
				break;
			case 3:
				nextEntry();
				choice = 0;
				break;
			case 4:
				displayEntry();
				choice = 0;
				break;
			case 5:
				System.out.println(" -- Application Closed -- ");
				System.exit(0);
			default:
				choice = 0;
				System.out.println("Invalid Input.");
				break;
			}
		}
	}
	
	public void addEntry() {
		System.out.print("Enter Customer Name: ");
		String name = sc.nextLine();
		System.out.println("\n+=====+");
		int priority = choosePriority();
		Customer customer = new Customer(name, priority);
		pq.add(customer);
	}
	
	public int choosePriority() {
		int choice = 0;
		int priority = 0;
		
		while (choice == 0) {
			System.out.println("[-- Table Manager --] ");
			System.out.print("[--    PRIORITY   --] ");
			System.out.println("\n+=====+");
			System.out.println("[1] VIP");
			System.out.println("[2] Reservation");
			System.out.println("[3] Senior Citizen");
			System.out.println("[4] Veteran");
			System.out.println("[5] Large Group (>4)");
			System.out.println("[6] Family with Children");
			System.out.println("[7] Everyone else");
			System.out.println();
			System.out.print("Enter Customer Priority: ");
			choice = sc.nextInt();
			sc.nextLine();
			
			switch (choice) {
			case 1:
				priority = 7;
				break;
			case 2:
				priority = 6;
				break;
			case 3:
				priority = 5;
				break;
			case 4:
				priority = 4;
				break;
			case 5:
				priority = 3;
				break;
			case 6:
				priority = 2;
				break;
			case 7:
				priority = 1;
				break;
			default:
				System.out.println("Invalid Input.");
				choice = 0;
				break;
			}
		}
		
		return priority;
	}
	
	public void removeEntry() {
		Customer customer = pq.remove();
		System.out.println(customer.getName() + " is ready to be seated.");
		
	}
	
	public void nextEntry() {
		
	}
	
	public void displayEntry() {
		Customer[] customers = new Customer[1];
		customers = pq.toArray(customers);

		for (int i = 0; i < customers.length; i++) {
			System.out.println("#" + (i + 1) + "/" + customers[i].getName() + "/" + customers[i].getPriority());
		}
	}
}
