package cn.xianyijun.leetcode;

/**
 * @author xianyijun
 *	Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
 */
public class SearchinRotatedSortedArray {
	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = (end - start) / 2 + start;
			if (nums[mid] == target) {
				return mid;
			}
			if (nums[mid] < nums[end]) {
				if (target > nums[mid] && target <= nums[end]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			} else {
				if (target >= nums[start] && target < nums[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
		}
		return -1;
	}
}
