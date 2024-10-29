/*

 * This algorithm takes:
 * 1. Comarisons = n -1 (max to max)
 * 2. Swaps = n -1 (max to max)
 * 3. Adaptive = By nature it is not adaptive bu by inroducing flag we can make it adaptive.
 * 4. Stable = Yes, In case of duplicate elemets it dont change their positions.

 */

public class BubbleSort {

	public static int[] sortElements(int[] arr, int n) {

		for (int i = n - 1; i >= 1; i--) {
			int didSwap = 0;

			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {

					arr[j] = arr[j] ^ arr[j + 1];
					arr[j + 1] = arr[j] ^ arr[j + 1];
					arr[j] = arr[j] ^ arr[j + 1];
					didSwap = 1;

				}
			}

			if (didSwap == 0) {
				break;
			}
		}

		return arr;

	}

	public static void main(String[] args) {
		int[] arr = { 12, 43, 22, 56, 44, 96, 88 };
		int l = arr.length;
		for (int x : sortElements(arr, l)) {
			System.out.print(x + " ");
		}
	}

}
