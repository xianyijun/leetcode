package cn.xianyijun.leetcode;

/**
 * @author xianyijun
 *	You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?


 */
public class ClimbingStairs {
	public int climbStairs(int n) {
		int[] array = new int[n + 1];
		array[0] = 1;
		array[1] = 1;
		for (int i = 2; i < array.length; i++) {
			array[i] = array[i - 1] + array[i - 2];
		}
		return array[n];
	}
}
