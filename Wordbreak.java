package ert;


import java.util.*;

public class Wordbreak {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get the input string
        System.out.print("Enter the string: ");
        String s = scanner.nextLine();
        
        // Get the dictionary
        System.out.print("Enter the dictionary (space-separated words): ");
        String[] words = scanner.nextLine().split(" ");
        Set<String> wordDict = new HashSet<>(Arrays.asList(words));
        
        // Perform word break
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        // Check if the string can be broken into words
        if (dp[s.length()]) {
            System.out.println("The string can be broken into words.");
        } else {
            System.out.println("The string cannot be broken into words.");
        }
    }
}