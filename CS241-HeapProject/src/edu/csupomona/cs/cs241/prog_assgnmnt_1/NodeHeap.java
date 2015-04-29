package edu.csupomona.cs.cs241.prog_assgnmnt_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class NodeHeap<V extends Comparable<V>> implements Heap<V> {

	private MODE mode;
	private Queue<Node> heapQueue;
	private Stack<Node> heapStack;
	
	private Node<V> root = null;
	private Node<V> lastNode = null;
	private int totalNodes = 0;
	
	public NodeHeap() {
		mode = Heap.MODE.MAX;
		heapQueue = new LinkedList<Node>();
		heapStack = new Stack<Node>();
	}

//	public static void main(String[] args) {
//		NodeHeap nh = new NodeHeap();
//		nh.add(1);
//		nh.add(2);
//	}
	
	public void add(V value) { // TODO
		
		boolean modified = false;
		
		totalNodes++;
		
		if (root == null) {
			root = new Node<V>(value);
			lastNode = root;
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
//			siftUp(newNode);
		}
	}
	
	public Node<V> visit() { // Locates last element via BFS
		
		boolean visited = false;
		Node<V> foundNode = null;
		Node<V> tempNode = null;
		
		heapQueue.add(root);
		Node<V> currentNode = heapQueue.poll();
		
		while (!visited) {
			
			if (!isLeaf(currentNode)) {
				
				if (currentNode.left != null) {
					heapQueue.add(currentNode.left);
					
					if (currentNode.right != null) { // not all non leaves have two children
						heapQueue.add(currentNode.right);
						tempNode = currentNode.right; // save this node just in case its the last node
						currentNode = heapQueue.poll();
					} else { // if currentNode has no RIGHT child
						foundNode = currentNode.left;
						visited = true;
					}
				} else { // if currentNode has no LEFT child
					foundNode = tempNode;
					visited = true;
				}
			} 	
		}
		heapQueue.clear();
		return foundNode;
	}
	
	public void siftUp(Node<V> node) { // starts at leaf (POV of child)
		
		boolean modified =  false;
		Node<V> tempNode = node;
		
		while (!modified) {
			if (tempNode.parent.value.compareTo(tempNode.value) == 0) {
				
			}
		}
	}
	
	public void siftDown() { // starts at root (POV of parent)
			
		boolean modified = false;
		Node<V> tempNode = root;
		V tempValue;
		
		while (!isLeaf(tempNode)) {
			if (tempNode.left.value.compareTo(tempNode.value) > 0) { // compares parent to left child
				if (tempNode.left.value.compareTo(tempNode.right.value) < 0) { // if left value < right value
					tempValue = tempNode.value;
					tempNode.value = tempNode.right.value; // parent value = right child value
					tempNode.right.value = tempValue; // right child value = parent value
				} else { // if left value > right
					tempValue = tempNode.value;
					tempNode.value = tempNode.left.value;
					tempNode.left.value =  tempValue;
				}
			} else if (tempNode.right.value.compareTo(tempNode.value) > 0) { // compares parent to right child
				
			}
		}
	}
	
	public boolean isLeaf(Node<V> node) {
		return node.left == null && node.right == null;
	}
	
	private void heapify() { // uses stack?
		
	}

	/*
	 * Returns component type
	 */
	public V[] toArray(V[] array) {
		return null;
	}

	
	public V remove() {
		
		V removedValue = root.value;
		
		if (root != null) { // checks if a tree exists
			root.value = null;
			
			while (root.value == null) {
				//Node<V> tempNode = visit();
				V tempValue = visit().value;
				root.value = tempValue;
				visit().parent.right = null;
				
				if (visit().parent.left != null) {
					if (visit().parent.right != null) {
						visit().parent.right = null;
					} else {
						visit().parent.left = null;
					}
				} // end check for which child is the last node
			} // end swap
			// siftDown(root);
		} // end procedure
		return removedValue;
	}

	// Turns array into the heap
	public void fromArray(V[] array) {
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
