package edu.csupomona.cs.cs241.prog_assgnmnt_1;

public class HeapSort<V extends Comparable<V>> {
	
	
	public V[] heapSort(V[] array, int count) {
		
		V[] result = null;
		final int lastIndex = (count - 1);
		int end = (count - 1);
		
		if (count > 0) { // makes sure there are things to sort
			while (end > 0) {
				swap(array, 0, end);
				end--;
				siftDown(array, 0, end);
			}
			result = array;
		}
		return result;
	}
	
	public void siftDown(V[] array, int index, int end) {

		int left;
		int right;
		int swapIndex = 0;

		if (index <= ((end - 1) / 2)) {
			left = 2 * index + 1;

			if (index <= end) {
				right = 2 * index + 2;

				if (((V) array[index]).compareTo((V) array[left]) == -1	|| ((V) array[index]).compareTo((V) array[right]) == -1) {
					if (((V) array[left]).compareTo((V) array[right]) >= 0) {
						swap(array, index, left);
						swapIndex = left;
					} else {
						swap(array, index, right);
						swapIndex = right;
					}
				}

			} else if (((V) array[index]).compareTo((V) array[left]) == -1) {
				swap(array, index, left);
				swapIndex = left;
			}
			siftDown(array, swapIndex, end);
		}
	} // end top if
	

	private void swap(V[] array, int i, int j) {
		V temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
}
