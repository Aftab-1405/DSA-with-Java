public class DecimalToBinary {

    public static String binaryNum(int N) {
        StringBuilder sb = new StringBuilder();

        while (N > 0) {
            int rem = N % 2;
            sb.append(rem);
            N /= 2;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(binaryNum(n));
    }
}
