public class SelectionSort {

    public static void sortArray(int[] arr) {
        for (int i = 0; i <= arr.length - 2; i++) {
            int mini = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[mini]) {
                    mini = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[mini];
            arr[mini] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 2, 3, 1 };
        sortArray(arr);
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }

}
