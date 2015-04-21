package edu.csupomona.cs.cs241.prog_assgnmnt_1;

public class NodeHeap<V extends Comparable<V>> implements Heap<V> {

	private MODE mode;
	private Node<V> root = null;
	private Node<V> lastNode = null;
	private int size;

	
	public void add(V value) { // TODO
		if (root == null) {
			root = new Node<V>(value);
			lastNode = root;
		} else if(lastNode.left == null) {
			lastNode.left = new Node<V>(value);
		} else {
			lastNode.right = new Node<V>(value);
		}
		size ++;
	}

	// Why is this needed?
	public V[] toArray(V[] array) {
		return null;
	}

	public void remove() {
	}

	public void fromArray(V[] array) {
	}

	public V[] getSortedContents(V[] array) {
		return null;
	}
	
	public V peek(MODE mode) {
		// find min
		// find max
		return null;
	}

	// +======================================
	
	public V[] getSortedContents() { // FIXME
		return null;
	}

	public Heap.MODE getMode() {
		return mode;
	}

	public void setMode(Heap.MODE initMode) {
		mode = initMode;
	}

	// Nested Class
	private class Node<V> {
		
		protected V value;
		protected Node<V> parent;
		protected Node<V> left;
		protected Node<V> right;
		
		Node(V initValue) {
			value = initValue;
			parent = null;
			left = null;
			right = null;
		}
	}
	
}
