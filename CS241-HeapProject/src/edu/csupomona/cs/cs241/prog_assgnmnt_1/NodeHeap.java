package edu.csupomona.cs.cs241.prog_assgnmnt_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class NodeHeap<V extends Comparable<V>> implements Heap<V> {

	private MODE mode;
	private Queue<Node<V>> heapQueue;
	private Stack<Node<V>> heapStack;
	
	private Node<V> root;
	private Node<V> insert; // last inserted node
	private Node<V> last; // last node
	private int count = 0;
	
	public NodeHeap() {
		mode = Heap.MODE.MAX;
		heapQueue = new LinkedList<Node<V>>();
		heapStack = new Stack<Node<V>>();
	}
	
	public static void main(String[] args) {
		NodeHeap<Integer> nh = new NodeHeap<Integer>();
		nh.add(7);
		nh.add(5);
		nh.add(23);
		nh.add(21);
		nh.add(42);
		nh.add(41);
		nh.add(36);
		nh.add(11);
		
//		Integer test[] = {80,39,38,65,36,95,14,80,6,10,41,27,35,75,83,97,56,71,36,53,91,73,18,3,67};
//		nh.fromArray(test);
		
		Integer[] array = new Integer[1];
		array = nh.toArray(array);

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " - ");
		}
		
		System.out.println();
		System.out.println("-- removal process --");
		
		nh.remove();
		array = nh.toArray(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " - ");
		}
		
		System.out.println();
		System.out.println("-- removal process --");
		
		nh.remove();
		array = nh.toArray(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " - ");
		}
	}
	
	// +====================================================================
	
	public void add(V value) { 
		
		boolean modified = false;
		
		count++;
		
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
	
	
	public V remove() {
		
		count --; // FIXME
		
		V removedValue = null;
		Node<V> currentNode;
		Node<V> tempNode = null;
		
		if (root != null) { // checks if a tree exists

			removedValue = root.value;
			heapQueue.add(root);
			root.value = null;
			
			while (root.value == null) { 			
				
				if (!heapQueue.isEmpty()) {
					currentNode = heapQueue.poll();
				
					if (currentNode.left != null) {
						heapQueue.add(currentNode.left);
						
						if (currentNode.right != null) {
							heapQueue.add(currentNode.right);
							tempNode = currentNode.right;
						} else {
							tempNode = currentNode.left;
						}
					}
				} else {
					root.value = tempNode.value;
					tempNode = null; // FIXME
				}
			} // end swap
			heapQueue.clear();
			siftDown();
		} // end procedure
		return removedValue;
	}
	
	
	public void siftUp(Node<V> node) { // starts at leaf (POV of child)

		boolean modified = false;
		
			while (!modified) {
				
				if (node.value.compareTo(node.parent.value) == 1) {
					V tempValue = node.parent.value;
					node.parent.value = node.value;
					node.value = tempValue;
					
					node = node.parent; // THERE IS A GOD. SWAP THE VALUES but UPDATE THE NODE
					
					if (node.parent == null) {
						modified = true;
					}
				} else {
					modified = true;
				}
			}
	}
	
	
	public void siftDown() { // starts at root (POV of parent)
		
		boolean modified = false;
		Node<V> node = root;
		V tempValue;
		
		if (root != null && !isLeaf(node)) {
			
			while (!modified) {
				
				if (node.left != null) {
					if (node.right != null) {
						if (node.value.compareTo(node.left.value) == -1 || node.value.compareTo(node.right.value) == -1) { // if both exists
							if (node.left.value.compareTo(node.right.value) >= 0) { // if left > right, swap left
								tempValue = node.value;
								node.value = node.left.value;
								node.left.value = tempValue;

								node = node.left;
							} else { // else right > left, swap right
								tempValue = node.value;
								node.value = node.right.value;
								node.right.value = tempValue;

								node = node.right;
							}
						} // end 
					} else if (node.value.compareTo(node.left.value) == -1) { // if there is no right child, check if its greater
						tempValue = node.value;
						node.value = node.left.value;
						node.left.value = tempValue;
					} else {
						modified = true;
					}
				} else {
					modified = true;
				}
			} // end while loop
		}
	}

	
	@SuppressWarnings("unchecked")
	public V[] toArray(V[] array) { // Turns the heap into an array implementation of a heap
		
		V[] result = (V[]) java.lang.reflect.Array.newInstance(array.getClass().getComponentType(), count);
		Node<V> tempNode;
		
		if (root != null) {
			heapQueue.add(root);
			
			for (int i = 0; i < count; i++) {
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
		heapQueue.clear();
		return result;
	}

	
	public void fromArray(V[] array) { // Turns array into a heap by using the add method
		
		for (int i = 0; i < array.length; i++) {
			add(array[i]);
		}
	}

	
	// call toArray (array version of heap)
	// make a new array that stores the sorted contents
	// from least to greatest
	public V[] getSortedContents(V[] array) { // TODO
		
		V[] result = null;
		
		HeapSort<V> hs = new HeapSort<V>();
		V[] arrayHeap = toArray(array);
		result = hs.heapSort(arrayHeap, count);
		
		return result;
	}

	
	public V peek() {
		return root.value;
	}
	
	
	public boolean isLeaf(Node<V> node) {
		return (node.left == null) && (node.right == null);
	}
	
	public int getTotalNodes() {
		return count;
	}
	
	
	public Node<V> getLast() { // TODO
		// this is important for obtaining O(logn)
		return null;
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
