package cn.xianyijun.leetcode;

/**
 * @author xianyijun
 *	Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 */
public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		int start = 0;
		int end = height.length - 1;
		int max = 0;
		while (start < end) {
			int target = (end - start) * Math.min(height[start], height[end]);
			max = Math.max(max, target);
			if (height[start] <= height[end]) {
				start++;
			} else {
				end--;
			}
		}
		return max;
	}
}
