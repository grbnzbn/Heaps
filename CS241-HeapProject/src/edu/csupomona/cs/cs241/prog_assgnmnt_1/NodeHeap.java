package edu.csupomona.cs.cs241.prog_assgnmnt_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class NodeHeap<V extends Comparable<V>> implements Heap<V> {

	private MODE mode;
	private Queue<Node<V>> heapQueue;
	private Stack<Node<V>> heapStack;
	
	private Node<V> root;
	private int totalNodes = 0;
	
	public NodeHeap() {
		mode = Heap.MODE.MAX;
		heapQueue = new LinkedList<Node<V>>();
		heapStack = new Stack<Node<V>>();
	}
	
	
	public void add(V value) { // TODO
		
		boolean modified = false;
		
		totalNodes++;
		
		if (root == null) {
			root = new Node<V>(value);
		} else {
			heapQueue.add(root);
			Node<V> newNode = new Node<V>(value); // incoming node & value
			Node<V> tempNode; // place holder node
			
			while (!modified) {
				
				tempNode = heapQueue.poll(); // poll removes and returns the value of the removed
				// the temp node hold the node that is currently being serviced
				
				if(tempNode.left == null) {
					tempNode.left = newNode;
					newNode.parent = tempNode;
					modified = true;
				} else if(tempNode.right == null) {
					tempNode.right = newNode;
					newNode.parent = tempNode;
					modified = true;
				} else if(tempNode.left != null) {
					heapQueue.add(tempNode.left);
					
					if(tempNode.right != null) {
						heapQueue.add(tempNode.right);
					}
				} 
			}// end while loop
			heapQueue.clear();
			siftUp(newNode);
		}
	}
	
	
	public V remove() { // TODO
		
		V removedValue = null;
		
		if (root != null) { // checks if a tree exists
			
			removedValue = root.value;
			root.value = null;
			
			while (root.value == null) {
				
				V tempValue;
				
			} // end swap
			// siftDown(root);
		} // end procedure
		return removedValue;
	}
	
	
	public void siftUp(Node<V> node) { // starts at leaf (POV of child)
		
		while (node.value.compareTo(node.parent.value) == 1) {
			Node<V> tempNode = node.parent;
			node.parent = node;
			node = tempNode;
		}
	}
	
	
	public void siftDown() { // starts at root (POV of parent)
		
		Node<V> node = root;
		Node<V> left = root.left;
		Node<V> right = root.right;
		Node<V> temp;
		
		if (node.value.compareTo(left.value) == -1) {
			if (left.value.compareTo(right.value) == 1) {
				temp = node;
				node = left;
				left = temp;
			} else {
				temp = node;
				node = right;
				right = temp;
			}
		}
	}
	
	
	private void heapify() { // uses stack?
		
	}

	
	public V[] toArray(V[] array) {
		return null;
	}

	
	public void fromArray(V[] array) { // Turns array into a heap by using the add method
		
		for (int i = 0; i < array.length; i++) {
			add(array[i]);
		}
	}

	
	/* - Internally transforms the heap into array representation
	 * - Performs Heap-Sort on the array
	 * - Returns resultant array.
	 */
	public V[] getSortedContents(V[] array) {
		return null;
	}

	
	public V peek() {
		return root.value;
	}
	
	
	public boolean isLeaf(Node<V> node) {
		return (node.left == null) && (node.right == null);
	}

	// Nested Class
	@SuppressWarnings("hiding")
	private class Node<V extends Comparable<V>> {

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
