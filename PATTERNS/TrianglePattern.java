package PATTERNS;
public class TrianglePattern {

    public static void printTrianle(int n) {
        for (int i = 0; i < n; i++) {

            // Space
            for (int j = 0; j < (n - i + 1); j++) {
                System.out.print(" ");
            }

            // Stars
            for (int j = 0; j < (2 * i + 1); j++) {
                System.out.print("*");
            }

            // Space
            for (int j = 0; j < (n - i + 1); j++) {
                System.out.print(" ");
            }

            System.out.println();
        }

    }

    public static void main(String[] args) {
        TrianglePattern.printTrianle(5);
    }

}
