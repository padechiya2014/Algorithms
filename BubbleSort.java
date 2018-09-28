package basicAlgo;

public class BubbleSort {

	/*public static void main(String args[]) {
		// Create complete binary tree
		int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
		//BubbleSortAlgo(arr);
		BubbleSortAlgo1(arr);
	}*/

	// technique 1
	private static void BubbleSortAlgo(int[] arr) {

		for (int i = 0; i < arr.length; i++) {

			for (int j = i + 1; j < arr.length; j++) {

				if (arr[i] > arr[j]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}

		for (int i : arr) {
			System.out.println(i);
		}
	}

	// technique 2
	private static void BubbleSortAlgo1(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (arr[j] > arr[j + 1]) {
					// swap temp and arr[i]
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
		for (int i : arr) {
			System.out.println(i);
		}
	}

}
