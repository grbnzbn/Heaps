package edu.csupomona.cs.cs241.prog_assgnmnt_1;

public interface Heap<V extends Comparable<V>> {
	
	public static enum MODE {MAX, MIN}; // FIXME
  
	public void add(V value);

	public V[] toArray(V[] array);

	public void remove();

	public void fromArray(V[] array);

	public V[] getSortedContents(V[] array);
	
	public V[] getSortedContents(); // FIXME
	
	public MODE getMode(); //FIXME
	
	public void setMode(MODE mode); //FIXME

}
