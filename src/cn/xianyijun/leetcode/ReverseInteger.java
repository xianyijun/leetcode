package cn.xianyijun.leetcode;

/**
 * @author xianyijun
 *	Reverse digits of an integer.

	Example1: x = 123, return 321
	Example2: x = -123, return -321
 */
public class ReverseInteger {
	public int reverse(int x) {
		boolean flag = true;
		if (x < 0) {
			flag = false;
			x = Math.abs(x);
		}
		int result = 0;
		while (x > 0) {
			if (result > Integer.MAX_VALUE / 10) {
				return 0;
			}
			result = result * 10 + x % 10;
			x /= 10;
		}
		return flag ? result : (-1 * result);
	}
}
