package basicAlgo;

public class SelectionSort {

	public static void main(String args[]) {
		// Create complete binary tree
		int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
		SelectionSort(arr);
	}
	
	private static void SelectionSort(int[] arr) {
		
		for(int i = 0; i < arr.length - 1; i++) {
			
			int minIndx = i;
			for(int j = i; j < arr.length-1; j++) {
				if(arr[j] > arr[j+1]) {
					minIndx = j+1;
				}
			}
			
			int temp = arr[i];
			arr[i] = arr[minIndx];
			arr[minIndx] = temp;
			
		}
		
		for(int i: arr) {
			System.out.println(i);
		}
	}
}
