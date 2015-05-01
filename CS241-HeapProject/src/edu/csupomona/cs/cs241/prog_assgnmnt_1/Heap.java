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

public interface Heap<V extends Comparable<V>> {
	
	public static enum MODE {MAX, MIN};
	
	public void add(V value);

	public V[] toArray(V[] array);

	public V remove();

	public void fromArray(V[] array);

	public V[] getSortedContents(V[] array);
	
}
