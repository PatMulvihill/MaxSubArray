/**
 *
 * @author Patrick Mulvihill
 * pmulvihill01@manhattan.edu
 * github.com/PatMulvihill
 */
import java.util.*;
public class FindMaximumSubarray {
    public static int[] findMaximumSubarray(int[] arr, int low, int high) {
        int[] sumArr = new int[3];
        if (high == low) {
            sumArr[0] = low;
            sumArr[1] = high;
            sumArr[2] = arr[low];
            return sumArr;
        }
        else {
            int mid = (low + high) / 2;
            int[] leftSumArr = new int[3];
            leftSumArr = findMaximumSubarray(arr, low, mid);
            int[] rightSumArr = new int[3];
            rightSumArr = findMaximumSubarray(arr, mid + 1, high);
            int[] crossSumArr = new int[3];
            crossSumArr = findMaxCrossingSubarray(arr, low, mid, high);
            if (leftSumArr[2] >= rightSumArr[2] && leftSumArr[2] >= crossSumArr[2]) {
                return leftSumArr;
            } else if (rightSumArr[2] >= leftSumArr[2] && rightSumArr[2] >= crossSumArr[2]) {
                return rightSumArr;
            } else {
                return crossSumArr;
            }
        }
        
        
    }
    
    
    
    
    public static void main(String[] args) {
        int[] dataArr = {15, 12, 19, 3, 9, 10, 11, 12, 5, 7,
                         4, 1, 3, 4, 3, 10, 11, 12, 7, 6};
        int[] maxSum = findMaximumSubarray(dataArr, 0, dataArr.length - 1);
        System.out.println("data array = " + Arrays.toString(dataArr));
        System.out.println("The Maximum sub array sum for the data array is: "
                + Arrays.toString(maxSum));
    }
    
}