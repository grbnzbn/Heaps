package edu.csupomona.cs.cs241.prog_assgnmnt_1;

public class HeapSort<V extends Comparable<V>> {
	
	
	public V[] heapSort(V[] array, int count) {

		V[] result = null;
		int end = (count - 1);

		if (count > 0) { // makes sure there are things to sort
			while (end > 0) {
				swap(array, 0, end);
				end--;
				siftDown(array, end);
			}
			result = array;
		}
		return result;
	}

	public void siftDown(V[] array, int end) {

		int bound = end + 1;
		int index = 0;
		int swapIndex;

		while (left(index) < bound || right(index) < bound) {
			if (right(index) < bound) {
				if (array[left(index)].compareTo(array[right(index)]) >= 0) {
					swapIndex = left(index);
				} else {
					swapIndex = right(index);
				}
			} else {
				swapIndex = left(index);
			}
			if (array[index].compareTo(array[swapIndex]) == -1) {
				swap(array, index, swapIndex);
				index = swapIndex;
			} else {
				break;
			}
		}

	}

	private int left(int n) {
		return ((n * 2) + 1);
	}

	private int right(int n) {
		return ((n * 2) + 2);
	}

	private void swap(V[] array, int i, int j) {
		V temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
