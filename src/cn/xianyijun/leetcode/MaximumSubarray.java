package cn.xianyijun.leetcode;

/**
 * @author xianyijun
 *	Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 *
 *	For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 *	the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray {
	  public int maxSubArray(int[] nums) {
	        if (nums.length == 0) {
				return 0;
			}
			if(nums.length == 1){
			    return nums[0];
			}
			int sum = nums[0];
			int result = nums[0];
			for (int i = 1; i < nums.length; i++) {
				sum = Math.max(nums[i], sum + nums[i]);
				result = Math.max(result, sum);
			}
			return result;
	    }
}
