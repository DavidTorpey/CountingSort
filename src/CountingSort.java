
public class CountingSort {

	private int[] inputArray;
	
	public CountingSort(int[] inputArray) {
		this.inputArray = inputArray;
	}
	
	public int[] sort() {
		
		int min_ = min(inputArray);
		int max_ = max(inputArray);
		int K = max_ - min_ + 1;
		
		
		int[] index = createIndexArray(K, min_);
		
		int[] count = createCountArray(K, index);

		int[] sumCount = createSumCountArray(K, count);
		
		return createSortedArray(index, sumCount);
	}

	public int[] createSortedArray(int[] index, int[] sumCount) {
		int[] sorted = new int[inputArray.length];
		for (int i = 0; i < sorted.length; i++) {
			sorted[sumCount[key(inputArray[i], index)] - 1] = index[key(inputArray[i], index)];
			sumCount[key(inputArray[i], index)] -= 1;
		}
		return sorted;
	}
	
	public int[] createCountArray(int K, int[] index) {
		int[] count = new int[K];
		for (int i = 0; i < K; i++) {
			int elementToCount = index[i];
			int c = 0;
			for (int j = 0; j < inputArray.length; j++) {
				if (inputArray[j] == elementToCount)
					c++;
			}
			count[i] = c;
		}
		return count;
	}
	
	public int[] createSumCountArray(int K, int[] count) {
		int[] sumCount = new int[K];
		int rollingSum = 0;
		for (int j = 0; j < K; j++) {
			rollingSum += count[j];
			sumCount[j] = rollingSum;
		}
		return sumCount;
	}
	
	public int[] createIndexArray(int K, int min_) {
		int[] index = new int[K];
		for (int i = 0; i < K; i++) {
			index[i] = min_ + i;
		}
		return index;
	}
	
	public int min(int[] a) {
		int minVal = 1000;
		for (int e : a) {
			if (e < minVal) {
				minVal = e;
			}
		}
		return minVal;
	}
	
	public int max(int[] a) {
		int maxVal = -1000;
		for (int e : a) {
			if (e > maxVal) {
				maxVal = e;
			}
		}
		return maxVal;
	}
	
	public int key(int x, int[] a) {
		for (int i = 0; i < a.length; i++) {
			if (x == a[i]) {
				return i;
			}
		}
		return -1;
	}
	
}
