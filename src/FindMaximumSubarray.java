/**
 *
 * @author Patrick Mulvihill
 * pmulvihill01@manhattan.edu
 * github.com/PatMulvihill
 */
import java.util.*;
public class FindMaximumSubarray {
    public static int maxSubarraySum(int []arr, int a, int b) {
        int maxSum = 0;
        
        return maxSum;
    }
    
    
    
    
    public static void main(String[] args) {
        int[] dataArr = {15, 12, 19, 3, 9, 10, 11, 12, 5, 7,
                         4, 1, 3, 4, 3, 10, 11, 12, 7, 6};
        int maxSum = maxSubarraySum(dataArr, 0, dataArr.length - 1);
        System.out.println("data array = " + Arrays.toString(dataArr));
        System.out.println("The Maximum sub array sum for the data array is: "
                + maxSum);
    }
    
}