package edu.csupomona.cs.cs241.prog_assgnmnt_1;

public class NodeHeap<V extends Comparable<V>> implements Heap<V> {

	private Node<V> root = null;
	private Node<V> lastNode = null;
	private int totalNodes = 0;

	public void add(V value) { // TODO
		totalNodes++;
		
		if (root == null) {
			root = new Node<V>(value);
			lastNode = root;
		} else {
			Node<V> newNode = new Node<V>(value); // next
			locate(newNode);


		
		}
	}
	
	public Node<V> locate(Node newNode) {
		
		int location = totalNodes;
		int level = (int) Math.floor(Math.log(location) / Math.log(2));
		int levelCap = (int) Math.pow(2, level);
		int treeCap = (int) Math.pow(2, level + 1) - 1;
		int foundNode = levelCap - (treeCap - location); // node's spot in level (offset)
		
		while (level > 0) {
			if (foundNode % 2 == 1) { // it is left child
				lastNode.left = newNode;
			} else { 				  // it is right child
				lastNode.right = newNode;
			}
			// +====================== WHAT DO I DO HERE
			double percent = foundNode / levelCap;
			levelCap = levelCap / 2;
			foundNode = (int) Math.ceil(percent * levelCap);
			level--;
		}
		
		return newNode;
	}
	
//	public Node<V> findLocation(Node<V> newNode, int location) {
//		int currentNode = location;
//		
//		while(currentNode > 1) {
//			if(currentNode % 2 == 0) { // if cn is even, it is a left child
//				lastNode.left = newNode;
//			} else { // if cn is odd, it is a right child
//				lastNode.right = newNode;
//			}
//			
//			currentNode = (int)Math.floor(currentNode / 2); // sets current node to parent
//		}
//		return null;
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
		
		return removedValue;
	}

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
