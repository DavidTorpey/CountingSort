
public class Program {
	
	public static void main(String args[]) {
		int[] input = {10, 7, 12, 4, 9, 13};
		
		CountingSort sorter = new CountingSort(input);
		int[] sorted = sorter.sort();
		
		for (int i = 0; i < sorted.length; i++)
			System.out.print(sorted[i] + " ");
	}
	
}
