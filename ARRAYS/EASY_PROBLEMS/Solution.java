package ARRAYS.EASY_PROBLEMS;

class Solution {
    static int evenlyDivides(int N) {
        int count = 0;
        int divident = N;

        while (N > 0) {
            int divisor = N % 10;

            // Skip the division if the divisor is zero
            if (divisor != 0 && divident % divisor == 0) {
                count++;
            }

            N /= 10;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(evenlyDivides(2446));
    }
}