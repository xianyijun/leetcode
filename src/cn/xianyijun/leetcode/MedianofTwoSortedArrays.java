package cn.xianyijun.leetcode;

public class MedianofTwoSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len = nums1.length + nums2.length;
		if ((len & 1) == 0) {
			return (findTopKNum(nums1, nums2, 0, 0, len / 2) + findTopKNum(nums1, nums2, 0, 0, len / 2 + 1)) / 2.0;
		} else {
			return findTopKNum(nums1, nums2, 0, 0, len / 2 + 1);
		}
	}

	private double findTopKNum(int[] first, int[] second, int firstStart, int secondStart, int k) {
		if (firstStart >= first.length) {
			return second[k + secondStart - 1];
		}
		if (secondStart >= second.length) {
			return first[k + firstStart - 1];
		}
		if (k == 1) {
			return Math.min(first[firstStart], second[secondStart]);
		}
		int num1 = firstStart + k / 2 - 1 < first.length ? first[firstStart + k / 2 - 1] : Integer.MAX_VALUE;
		int num2 = secondStart + k / 2 - 1 < second.length ? second[secondStart + k / 2 - 1] : Integer.MAX_VALUE;
		if (num1 < num2) {
			return findTopKNum(first, second, firstStart + k / 2, secondStart, k - k / 2);
		} else {
			return findTopKNum(first, second, firstStart, secondStart + k / 2, k - k / 2);
		}
	}
}
