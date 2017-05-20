
public class Program {

	public static void main(String[] args) {
		
		int[] input = {10, 7, 12, 4, 9, 13};
		int min_ = min(input);
		int max_ = max(input);
		int K = max_ - min_ + 1;
		
		int[] index = new int[K];
		for (int i = 0; i < K; i++) {
			index[i] = min_ + i;
		}
		
		int[] count = new int[K];
		for (int i = 0; i < K; i++) {
			int elementToCount = index[i];
			int c = 0;
			for (int j = 0; j < input.length; j++) {
				if (input[j] == elementToCount)
					c++;
			}
			count[i] = c;
		}

		int[] sumCount = new int[K];
		int rollingSum = 0;
		for (int j = 0; j < K; j++) {
			rollingSum += count[j];
			sumCount[j] = rollingSum;
		}
		
		int[] sorted = new int[input.length];
		for (int i = 0; i < sorted.length; i++) {
			sorted[sumCount[key(input[i], index)] - 1] = index[key(input[i], index)];
			sumCount[key(input[i], index)] -= 1;
		}
		
		for (int i = 0; i < sorted.length; i++)
			System.out.print(sorted[i] + " ");
		System.out.println("");
		
	}

	public static int min(int[] a) {
		int minVal = 1000;
		for (int e : a) {
			if (e < minVal) {
				minVal = e;
			}
		}
		return minVal;
	}
	
	public static int max(int[] a) {
		int maxVal = -1000;
		for (int e : a) {
			if (e > maxVal) {
				maxVal = e;
			}
		}
		return maxVal;
	}
	
	public static int key(int x, int[] a) {
		for (int i = 0; i < a.length; i++) {
			if (x == a[i]) {
				return i;
			}
		}
		return -1;
	}
	
}
