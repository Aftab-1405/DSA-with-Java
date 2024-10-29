public class SwapTwoArray {

    public static void swapArrays(int[] array1, int[] array2) {
        // Use Math.min to ensure it works even if arrays have different lengths
        int length = Math.min(array1.length, array2.length);

        for (int i = 0; i < length; i++) {
            int temp = array1[i];
            array1[i] = array2[i];
            array2[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array1 = { 11, 12, 13, 14 };
        int[] array2 = { 15, 16, 17, 18 };

        swapArrays(array1, array2);

        System.out.println("Array 1: ");
        for (int x : array1) {
            System.out.print(x + " ");
        }
        System.out.println();

        System.out.println("Array 2: ");
        for (int x : array2) {
            System.out.print(x + " ");
        }
    }
}
