package interviewPractices;

import java.util.*;

public class HeightPrinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the heights of Ashok, Ram, Sita, and Ali:");
        int[] heights = new int[4];
        for (int i = 0; i < 4; i++) {
            heights[i] = scanner.nextInt();
        }
        
        System.out.println("The heights in decreasing order:");
        printHeights(heights);
        
        scanner.close();
    }
    
    public static void printHeights(int[] heights) {
        // Sort the heights in decreasing order
        Arrays.sort(heights);
        for (int i = heights.length - 1; i >= 0; i--) {
            System.out.print(heights[i] + " ");
        }
        System.out.println();
    }
}
