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
	
//	public static void main(String[] args) {
//		NodeHeap<Integer> nh = new NodeHeap<Integer>();
//		nh.add(7);
//		nh.add(5);
//		nh.add(23);
//		nh.add(21);
//		nh.add(42);
//		nh.add(41);
//		nh.add(36);
//		nh.add(11);
//	}
	
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
			V tempValue = node.parent.value;
			node.parent.value = node.value;
			node.value = tempValue;
			
			node = node.parent; // THERE IS A GOD. SWAP THE VALUES but UPDATE THE NODE
			//siftUp(node.parent);
		}
	}
	
	
	public void siftDown(Node<V> node) { // starts at root (POV of parent)
		
		boolean modified = false;
		node = root;
		Node<V> tempNode;
		V tempValue;
		
		while (!modified) {
			if (!isLeaf(node)) { // (node.left == null) && (node.right == null)
				if (node.value.compareTo(node.left.value) == -1) { // if the node value < left value
					if (node.right != null) { // if there is a right 
						if (node.left.value.compareTo(node.right.value) == 1) { // compare if left > right
							tempValue = node.value;
							node.value = node.left.value;
							node.left.value = tempValue;
							modified = true;
						} else {
							tempValue = node.value;
							node.value = node.right.value;
							node.left.value = tempValue;
							modified = true;
						}
					}
					// swap node value and left value
				}
			}
		}
		
		
		
		
		
		
		
		
//		while (!isLeaf(node)) {
//			if (nodeValue.compareTo(leftValue) == -1) { // checks max heap property
//				if (leftValue.compareTo(rightValue) == 1) { // if left > right
//					tempValue = nodeValue;
//					nodeValue = leftValue;
//					leftValue = tempValue;
//				} else { // else if right > left
//					tempValue = nodeValue;
//					nodeValue = rightValue;
//					rightValue = tempValue;
//				}
//				
//			}
//			siftDown(node);
//		}
	}
	
	
	private void heapify() { // uses stack?
		
	}

	
	@SuppressWarnings("unchecked")
	public V[] toArray(V[] array) { // Turns the heap into an array implementation of a heap
		
		V[] result = (V[]) java.lang.reflect.Array.newInstance(array.getClass().getComponentType(), totalNodes);
		Node<V> tempNode;
		
		if (root != null) {
			heapQueue.add(root);
			
			for (int i = 0; i < totalNodes; i++) {
				tempNode = heapQueue.poll();
				result[i] = tempNode.value;
				
				if (tempNode.left != null) {
					heapQueue.add(tempNode.left);
					
					if (tempNode.right != null) {
						heapQueue.add(tempNode.right);
					}
				}
			} // end for loop
		}
		return result;
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
		// call toArray (array version of heap)
		// make a new array that stores the sorted contents
		// from least to greatest
		
		V[] result = null;
		
		for (int i = 0; i < totalNodes; i++) {
			// perform heapsort?
		}
		
		return result;
	}

	
	public V peek() {
		return root.value;
	}
	
	
	public boolean isLeaf(Node<V> node) {
		return (node.left == null) && (node.right == null);
	}


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
