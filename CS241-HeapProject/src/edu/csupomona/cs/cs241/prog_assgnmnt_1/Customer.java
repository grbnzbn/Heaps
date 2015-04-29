package edu.csupomona.cs.cs241.prog_assgnmnt_1;

public class Customer {

	private String name;
	private int priority;
	
	/* Priority (Descending)
	 * 1. VIP
	 * 2. Reservation
	 * 3. Senior
	 * 4. Veteran
	 * 5. Large Group (>4)
	 * 6. Family with children
	 * 7. Everyone else
	 */
	public Customer(String initName, int initPriority) {
		this.name = initName;
		this.priority = initPriority;
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
