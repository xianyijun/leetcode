package cn.xianyijun.leetcode;

/**
 * @author xianyijun
 *Determine whether an integer is a palindrome. Do this without extra space.
 */
public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		String target = x + "";
		if (target.length() == 0) {
			return true;
		}
		int start = 0;
		int end = target.length() - 1;
		while (start < end) {
			if (target.charAt(start) != target.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
}
