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
        int[] sumArr = new int[3];
        if (high == low) {
            int[] summArr = {low, high, arr[low]};
            return sumArr;
        } else {
            int mid = (low + high) / 2;
            int[] leftSumArr = findMaximumSubarray(arr, low, mid);
            int[] rightSumArr = findMaximumSubarray(arr, mid + 1, high);
            int[] crossSumArr = findMaxCrossingSubarray(arr, low, mid, high);
            if (leftSumArr[2] >= rightSumArr[2] && leftSumArr[2] >= crossSumArr[2]) {
                int[] solutionArr = {leftSumArr[0], leftSumArr[1], leftSumArr[2]};
                return solutionArr;
            } else if (rightSumArr[2] >= leftSumArr[2] && rightSumArr[2] >= crossSumArr[2]) {
                int[] solutionArr = {rightSumArr[0], rightSumArr[1], rightSumArr[2]};
                return solutionArr;
            } else {
                int[] solutionArr = {crossSumArr[0], crossSumArr[1], crossSumArr[2]};
                return solutionArr;
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
        int[] crossSumArr = {maxLeft, maxRight, leftSum + rightSum};
        return crossSumArr;
    }
    
    public static void main(String[] args) {
        int[] dataArr = {15, 12, 19, 3, 9, 10, 11, 12, 5, 7,
                         4, 1, 3, 4, 3, 10, 11, 12, 7, 6};
        int[] maxSum = findMaximumSubarray(dataArr, 0, dataArr.length - 1);
        System.out.println("data array = " + Arrays.toString(dataArr));
        int buyDay = maxSum[0] + 1, sellDay = maxSum[1] + 1;
        int buyPrice = dataArr[maxSum[0]], sellPrice = dataArr[maxSum[1]];
        int profit = sellPrice - buyPrice;
        System.out.println("The Maximum profit for the data array is: " + profit);
        System.out.println("The buy price is " + buyPrice + " on day " + buyDay);
        System.out.println("The sell price is " + sellPrice + " on day " + sellDay);
    }
    
}