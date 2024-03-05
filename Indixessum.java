package ert;




import java.util.*;

public class Indixessum {
    public static int[] findTwoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] numbers = {5, 7, 3, 15};
        int target = 8;
        int[] result = findTwoSum(numbers, target);
        if (result.length == 2) {
            System.out.println("Indices: " + result[0] + " and " + result[1]);
        } else {
            System.out.println("No two numbers found that add up to the target.");
        }
    }
}
