package HASHING;

import java.util.Scanner;

public class CharHash {

    public static void main(String[] args) {
        System.out.print("Enter the size of an hash that you want to create: ");
        Scanner takeInput = new Scanner(System.in);
        int size = takeInput.nextInt();
        int[] hash = new int[size];

        String hashString = "abcdefghijklmnopqrstuvwxyzasetdawgrcyesddgteghyukhwbokslkenelhadskjbnoiwbsowbscobe";
        for (int i = 0; i < hashString.length(); i++) {

            hash[hashString.charAt(i) - 'a']++; // If we want to create only hash of 26 size then we need to minus 'a' with the element that we cant to precompute.

        }
        takeInput.close();
        System.out.println(hash['d' -'a']);
    }

}
