package ert;

import java.util.Scanner;

public class RotateArrayLeft {

    public static void rotateArrayLeft(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return;
        }

        int n = nums.length;
        k = k % n;

        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
        reverse(nums, 0, n - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int size = scanner.nextInt();

        int[] nums = new int[size];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.print("Enter the number of steps to rotate the array to the left: ");
        int k = scanner.nextInt();

        System.out.println("Original Array:");
        printArray(nums);

        rotateArrayLeft(nums, k);

        System.out.println("Array after rotating by " + k + " steps to the left:");
        printArray(nums);

        scanner.close();
    }

    private static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
