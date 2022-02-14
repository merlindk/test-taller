/**
 * Write a function that takes in a non-empty array of distinct integers and an integer representing a target sum. The function should find all quadruplets in the array that sum up to the target sum and return a two-dimensional array of all these quadruplets in no particular order.
 * <p>
 * If no four numbers sum up to the target sum, the function should return an empty array.
 * <p>
 * Sample Input array: [7 , 6, 4, -1, 1 ,2] targetSum = 16 Sample Output [[7, 6, 4, -1], [7, 6, 1, 2]] // the quadruplets could be ordered differently
 **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    //Test cases data
    private static final Integer[] inputTestCase1 = new Integer[]{7, 6, 4, -1, 1, 2};
    private static final int targetSum1 = 16;
    private static final Integer[][] outputTestCase1 = new Integer[][]{{7, 6, 4, -1}, {7, 6, 1, 2}};
    private static final Integer[] inputTestCase2 = new Integer[]{1, 2, 3, 4, 5, 6, 7};
    private static final int targetSum2 = 10;
    private static final Integer[][] outputTestCase2 = new Integer[][]{{1, 2, 3, 4}};
    private static final Integer[] inputTestCase3 = new Integer[]{1, 2, 3, 4, 5, -5, 6, -6};
    private static final int targetSum3 = 5;
    private static final Integer[][] outputTestCase3 = new Integer[][]{{2, 3, 5, -5}, {1, 4, 5, -5}, {2, 4, 5,
            -6}, {1, 3, -5, 6}, {2, 3, 6, -6}, {1, 4, 6, -6}};
    private static final Integer[] inputTestCase4 = new Integer[]{5, -5, -2, 2, 3, -3};
    private static final int targetSum4 = 0;
    private static final Integer[][] outputTestCase4 = new Integer[][]{{5, -5, -2, 2}, {5, -5, 3, -3},
            {-2, 2, 3, -3}};
    private static final Integer[] inputTestCase5 = new Integer[]{-2, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    private static final int targetSum5 = 4;
    private static final Integer[][] outputTestCase5 = new Integer[][]{{-2, -1, 1, 6}, {-2, 1, 2, 3},
            {-2, -1, 2, 5}, {-2, -1, 3, 4}};
    private static final Integer[] inputTestCase6 = new Integer[]{-1, 22, 18, 4, 7, 11, 2, -5, -3};
    private static final int targetSum6 = 30;
    private static final Integer[][] outputTestCase6 = new Integer[][]{{-1, 22, 7, 2}, {22, 4, 7, -3},
            {-1, 18, 11, 2}, {18, 4, 11, -3}, {22, 11, 2, -5}};
    private static final Integer[] inputTestCase7 = new Integer[]{-10, -3, -5, 2, 15, -7, 28, -6, 12, 8, 11, 5};
    private static final int targetSum7 = 20;
    private static final Integer[][] outputTestCase7 = new Integer[][]{{-5, 2, 15, 8}, {-3, 2, -7, 28},
            {-10, -3, 28, 5}, {-10, 28, -6, 8}, {-7, 28, -6, 5}, {-5, 2, 12, 11}, {-5, 12, 8, 5}};
    private static final Integer[] inputTestCase8 = new Integer[]{1, 2, 3, 4, 5};
    private static final int targetSum8 = 100;
    private static final Integer[][] outputTestCase8 = new Integer[][]{};

    public static List<Integer[]> fourNumberSum(Integer[] array, int targetSum) {
        ArrayList<Integer[]> result = new ArrayList<Integer[]>();
        if (array.length < 4) {
            return result;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                for (int k = j + 1; k < array.length; k++) {
                    for (int n = k + 1; n < array.length; n++) {
                        int sum = array[i] + array[j] + array[k] + array[n];
                        if(sum == targetSum){
                            result.add(new Integer[]{array[i], array[j], array[k], array[n]});
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //Execute all the test cases
        testCase(1, inputTestCase1, targetSum1, Arrays.asList(outputTestCase1));
        testCase(2, inputTestCase2, targetSum2, Arrays.asList(outputTestCase2));
        testCase(3, inputTestCase3, targetSum3, Arrays.asList(outputTestCase3));
        testCase(4, inputTestCase4, targetSum4, Arrays.asList(outputTestCase4));
        testCase(5, inputTestCase5, targetSum5, Arrays.asList(outputTestCase5));
        testCase(6, inputTestCase6, targetSum6, Arrays.asList(outputTestCase6));
        testCase(7, inputTestCase7, targetSum7, Arrays.asList(outputTestCase7));
        testCase(8, inputTestCase8, targetSum8, Arrays.asList(outputTestCase8));
    }

    public static void testCase(int testCaseNumber, Integer[] input, int targetSum, List<Integer[]> output) {
        List<Integer[]> outputProcessed = fourNumberSum(input, targetSum);
        String message = (output.size() == outputProcessed.size() && compare(output, outputProcessed)) ?
                "Test Case " + testCaseNumber + " Pass" : "Test Case " + testCaseNumber + " Fail";
        System.out.println(message);
    }

    private static boolean compare(List<Integer[]> quads1, List<Integer[]> quads2) {
        quads1.stream().forEach(Arrays::sort);
        quads2.stream().forEach(Arrays::sort);
        for (Integer[] quad2 : quads2) {
            boolean found = false;
            for (Integer[] quad1 : quads1) {
                if (Arrays.equals(quad2, quad1)) {
                    found = true;
                    break;
                }
            }
            if (found == false) {
                return false;
            }
        }
        return true;
    }
}
