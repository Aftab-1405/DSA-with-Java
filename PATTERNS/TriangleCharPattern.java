package PATTERNS;

public class TriangleCharPattern {
    public static void printPattern(int n) {
        for (int i = 0; i < n; i++) {
            for (char c = 'A'; c <= 'A' + i; c++) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TriangleCharPattern.printPattern(5);
    }

}
