/**
 * CS 241: Data Structures and Algorithms II
 * Professor: Edwin Rodr&iacute;guez
 *
 * Programming Assignment #1: Heaps 
 *
 * <description-of-assignment>
 * The purpose of this assignment is helping you understand 
 * the nuances of the heap data structure studied in class. 
 *
 * Daniel Gamboa
 *    
 */
package edu.csupomona.cs.cs241.prog_assgnmnt_1;

/* Priority (Descending)
 * 1. VIP
 * 2. Reservation
 * 3. Senior
 * 4. Veteran
 * 5. Large Group (>4)
 * 6. Family with children
 * 7. Everyone else
 */
public class Customer implements Comparable<Customer> {

	private String name;
	private int priority;

	public Customer(String initName, int initPriority) {
		this.name = initName;
		this.priority = initPriority;
	}

	public int compareTo(Customer customer) {
		
		int result = 0;
		int x = this.getPriority();
		int y = customer.getPriority();
		
		if (x > y) {
			result = 1;
		} else if (x == y) {
			result =  0;
		} else if (x < y) {
			result = -1;
		}
		
		return result;
	}

	public String toString(Customer customer) {
		return ("Name: " + name + " -- " + "Priority: " + priority);
	}

	public String getName() {
		return name;
	}

	public int getPriority() {
		return priority;
	}

}
