package AMAZONPROBLEMS;

import java.util.*;

public class TwoSumProblem {

	// Approach 01 (Brute): This approach uses two nested loops to find two numbers
	// that add up to the target. This solutio has time comeplexity of O(n^2) and
	// space complexity of O(1).
	public static int[] findTwoSumBrute(int[] arr, int target) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int currentSum = arr[i] + arr[j];
				if (currentSum == target) {
					return new int[] { i, j };
				}
			}
		}

		return new int[] {};
	}

	// Approach 02 (Better): This approach uses a HashMap to store the numbers and
	// their indices.
	// It iterates through the array, calculating the complement for each number and
	// checking if the complement exists in the map. If it does, it returns the
	// indices.
	// This solution has time complexity of O(n) and space complexity of O(n).
	public static int[] findTwoSumOptimized(int[] arr, int target) {
		Map<Integer, Integer> numsToIndex = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			int complement = target - arr[i];
			if (numsToIndex.containsKey(complement)) {
				return new int[] { i, numsToIndex.get(complement) };
			}
		}

		return new int[] {};
	}

	public static void main(String[] args) {
		int[] arr = { 2, 7, 11, 15 };
		int target = 9;
		int[] targetSumIndexes = findTwoSumBrute(arr, target);
		for (int i = 0; i < targetSumIndexes.length; i++) {
			System.out.print(i + " ");
		}
	}

}