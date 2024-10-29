package RECURSION;

public class Recursion {

    public static void printNumber(int i, int n) {
        if (i > n) {
            return;
        }
        printNumber(i + 1, n);
        System.out.println(i);
    }

    public static void main(String[] args) {

        printNumber(1, 3);

    }
}