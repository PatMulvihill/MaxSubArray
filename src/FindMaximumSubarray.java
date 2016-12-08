/**
 *
 * @author Patrick Mulvihill
 * CMPT 438: Algorithms
 * Dr. Tian
 * Project 2
 * pmulvihill01@manhattan.edu
 * github.com/PatMulvihill/MaxSubArray
 */
import java.util.*;
public class FindMaximumSubarray {
    public static int[] findMaximumSubarray(int[] arr, int low, int high) {
        if (high == low) {
            int[] solutionArr = {low, high, arr[low]};
            return solutionArr;
        } else {
            int mid = (low + high) / 2;
            int[] leftSumArr = findMaximumSubarray(arr, low, mid);
            int[] rightSumArr = findMaximumSubarray(arr, mid + 1, high);
            int[] crossSumArr = findMaxCrossingSubarray(arr, low, mid, high);
            if (leftSumArr[2] >= rightSumArr[2] && leftSumArr[2] >= crossSumArr[2]) {
                return leftSumArr;
            } else if (rightSumArr[2] >= leftSumArr[2] && rightSumArr[2] >= crossSumArr[2]) {
                return rightSumArr;
            } else {
                return crossSumArr;
            }
        }
    }
    
    public static int[] findMaxCrossingSubarray(int[] arr, int low, int mid, int high) {
        int leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE, sum = 0, maxLeft = mid, maxRight = mid + 1;
        for (int i = mid; i >= low; i--) {
            sum += arr[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }
        sum = 0;
        for (int j = mid + 1; j <= high; j++) {
            sum += arr[j];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = j;
            }
        }
        int[] crossSumArr = {maxLeft, maxRight, (leftSum + rightSum)};
        return crossSumArr;
    }
    
    public static void main(String[] args) {
        int[] dataArr1 = {15, 12, 19, 3, 9, 17, 11, 18, 5, 16,
                         4, 1, 3, 14, 2, 10, 13, 8, 7, 6};
        int[] dataArr2 = {15, 9, 3, 13, 8, 7, 21, 0, 47, 5};
        int[] dataArr3 = {10, -3, -5, 15, -10, 5, 3, 7, 20, -1, 0, 16};
        
        int[] maxSum1 = findMaximumSubarray(dataArr1, 0, dataArr1.length - 1);
        System.out.println("data array = " + Arrays.toString(dataArr1));
        int buyDay = maxSum1[0] + 1, sellDay = maxSum1[1] + 1;
        int buyPrice = dataArr1[maxSum1[0]], sellPrice = dataArr1[maxSum1[1]];
        int profit = maxSum1[maxSum1.length - 1];
        System.out.println("The Maximum subarray for the data array is: " + profit);
        System.out.println("The first day in the contigous maximum subarray is " + buyDay + " with value " + buyPrice);
        System.out.println("The last day in the contigous maximum subarray is " + sellDay + " with value " + sellPrice + "\n\n");
        
        int[] maxSum2 = findMaximumSubarray(dataArr2, 0, dataArr2.length - 1);
        System.out.println("data array = " + Arrays.toString(dataArr2));
        buyDay = maxSum2[0] + 1;
        sellDay = maxSum2[1] + 1;
        buyPrice = dataArr2[maxSum2[0]];
        sellPrice = dataArr2[maxSum2[1]];
        profit = maxSum2[maxSum2.length - 1];
        System.out.println("The Maximum subarray for the data array is: " + profit);
        System.out.println("The first day in the contigous maximum subarray is " + buyDay + " with value " + buyPrice);
        System.out.println("The last day in the contigous maximum subarray is " + sellDay + " with value " + sellPrice + "\n\n");
        
        int[] maxSum3 = findMaximumSubarray(dataArr3, 0, dataArr3.length - 1);
        System.out.println("data array = " + Arrays.toString(dataArr3));
        buyDay = maxSum3[0] + 1;
        sellDay = maxSum3[1] + 1;
        buyPrice = dataArr3[maxSum3[0]];
        sellPrice = dataArr3[maxSum3[1]];
        profit = maxSum3[maxSum3.length - 1];
        System.out.println("The Maximum subarray for the data array is: " + profit);
        System.out.println("The first day in the contigous maximum subarray is " + buyDay + " with value " + buyPrice);
        System.out.println("The last day in the contigous maximum subarray is " + sellDay + " with value " + sellPrice + "\n\n");
    }
    
}