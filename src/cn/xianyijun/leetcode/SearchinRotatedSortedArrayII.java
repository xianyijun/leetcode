package cn.xianyijun.leetcode;

/**
 * @author xianyijun
 *	Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.
 */
public class SearchinRotatedSortedArrayII {
	public boolean search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = (start + end) >> 1;
			if (nums[mid] == target) {
				return true;
			}
			if (nums[start] < nums[mid]) {
				if (nums[start] <= target && nums[mid] > target) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else if (nums[start] > nums[mid]) {
				if (target > nums[mid] && target <= nums[end]) {
					start = mid + 1;
				} else {
					end = mid;
				}
			} else {
				start++;
			}
		}
		return false;
	}
}
