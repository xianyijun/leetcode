package cn.xianyijun.leetcode;

/**
 * @author xianyijun
 *	Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

Note:
You can assume that you can always reach the last index.

Subscribe to see which companies asked this question
 */
public class JumpGameII {

	public int jump(int[] nums) {
		int count = 0;
		int max = 0;
		int nextMax = 0;
		for (int i = 0; i <= max && i < nums.length-1; i++) {
			nextMax = Math.max(nextMax, i + nums[i]);
			if (i == max) {
				max = nextMax;
				count++;
			}
		}
		return max >= nums.length - 1 ? count : -1;
	}

}
