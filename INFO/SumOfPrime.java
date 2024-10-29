public class SumOfPrime {

    // Approach 01: This is a brute force approach where we can use normal appraoch
    // to find out prime numbers and then sum up them.z

    // Approach 02: This is a better solution where we can loop upto the sqrt of
    // given number and find out whether the number is prime or not, and if it is
    // them we can add it to the sum.

    // Approach 03: This is a optimal sulution where we can be utilizing the sieve
    // algorithm.

    public static int[] sumOfPrime(int n) {
        int[] hash = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            if (hash[i] == 0) {
                for (int j = i * i; j <= n; j += i) {
                    hash[j] = 1;
                }
            }
        }

        return hash;
    }

    public static void main(String[] args) {
        int n = 100;
        int[] primeNumbers = sumOfPrime(n);
        int sum = 0;
        for (int i = 2; i < primeNumbers.length; i++) {
            if (primeNumbers[i] == 0) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

}
