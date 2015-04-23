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

	public void add(V value) { // TODO
		
		boolean modified = false;
		
		totalNodes++;
		
		if (root == null) {
			root = new Node<V>(value);
			lastNode = root;
		} else {
			heapQueue.add(root);
			Node<V> newNode = new Node<V>(value); // next
			Node<V> tempNode;
			
			while (!modified) {
				tempNode = heapQueue.poll();
				
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
			}
			heapQueue.clear();
//			siftUp(newNode);
		}
	}
	
//	public Node<V> locate(Node newNode) {
//		
//		int location = totalNodes;
//		int level = (int) Math.floor(Math.log(location) / Math.log(2));
//		int levelCap = (int) Math.pow(2, level);
//		int treeCap = (int) Math.pow(2, level + 1) - 1;
//		int foundNode = levelCap - (treeCap - location); // node's spot in level (offset)
//		
//		while (level > 0) {
//			if (foundNode % 2 == 1) { // it is left child
//				lastNode.left = newNode;
//			} else { 				  // it is right child
//				lastNode.right = newNode;
//			}
//			
//			
//			// +====================== WHAT DO I DO HERE
//			double percent = foundNode / levelCap;
//			levelCap = levelCap / 2;
//			foundNode = (int) Math.ceil(percent * levelCap);
//			level--;
//		}
//		
//		return newNode;
//	}

	/*
	 * Returns component type
	 */
	public V[] toArray(V[] array) {
		return null;
	}

	
	public V remove() {
		V removedValue = root.value;
		root = null;
		
		// search for lastElem
		// root = lastElem
		// siftDown(root);
		
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
