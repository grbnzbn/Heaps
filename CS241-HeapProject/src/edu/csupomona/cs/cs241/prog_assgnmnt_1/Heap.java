package edu.csupomona.cs.cs241.prog_assgnmnt_1;

public interface Heap<V extends Comparable<V>> {
	
	public static enum MODE {MAX, MIN};
	
	public void add(V value);

	public V[] toArray(V[] array);

	public V remove();

	public void fromArray(V[] array);

	public V[] getSortedContents(V[] array);
	
	
	
}
