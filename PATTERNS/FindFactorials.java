package PATTERNS;

public class FindFactorials {

    public static void find(int n) {

        int factorial = 1;
        int i = 1;

        while (factorial < n) {
            System.out.println(i++);
            factorial *= i;
        }
    }

    public static void main(String[] args) {

        find(10);
    }

}
