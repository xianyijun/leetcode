package cn.xianyijun.leetcode;

/**
 * @author xianyijun
 *	Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

	For example,
	Given n = 3,

	You should return the following matrix:
	[
	 [ 1, 2, 3 ],
	 [ 8, 9, 4 ],
	 [ 7, 6, 5 ]
	]
 */
public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
		int[][] result = new int[n][n];
		int startX = 0, endX = n - 1;
		int startY = 0, endY = n - 1;
		int count = 1;
		while (startX <= endX && startY <= endY) {
			for (int i = startX; i <= endX; i++) {
				result[startY][i] = count;
				count++;
			}
			for (int i = startY + 1; i <= endY; i++) {
				result[i][endX] = count;
				count++;
			}
			if (startX != endX) {
				for (int i = endX - 1; i >= startX; i--) {
					result[endY][i] = count;
					count++;
				}
			}
			if (startY != endY) {
				for (int i = endY - 1; i > startY; i--) {
					result[i][startX] = count;
					count++;
				}
			}
			endX--;
			startX++;
			endY--;
			startY++;
		}
		return result;
	}
}
