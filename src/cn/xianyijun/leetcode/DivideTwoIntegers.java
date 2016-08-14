package cn.xianyijun.leetcode;

/**
 * @author xianyijun
 *	Divide two integers without using multiplication, division and mod operator.

	If it is overflow, return MAX_INT.
 */
public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		if (divisor == 0) {
			return Integer.MAX_VALUE;
		}
		if (dividend == 0) {
			return 0;
		}
		if (dividend == Integer.MIN_VALUE && divisor == -1) {
			return Integer.MAX_VALUE;
		}
		boolean flag = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
		long ldividend = Math.abs((long) dividend);
		long ldivisor = Math.abs((long) divisor);
		int result = 0;
		while (ldividend >= ldivisor) {
			int shift = 0;
			while (ldividend >= ldivisor << shift) {
				shift++;
			}
			ldividend -= ldivisor << (shift - 1);
			result += 1 << (shift - 1);
		}
		return flag ? (result * -1) : result;
	}
}
