import java.util.*;

public class StringSortingCharcterWise {
    public static String sortedString(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }

    public static void main(String[] args) {
        String sc = "Aftab";
        System.out.println("Original string: " + sc);
        System.out.println("Sorted string: " + sortedString(sc));
    }

}
