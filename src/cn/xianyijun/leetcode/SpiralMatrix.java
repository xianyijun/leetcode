package cn.xianyijun.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xianyijun
 
 	Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
	For example,
	Given the following matrix:
	[
	 [ 1, 2, 3 ],
	 [ 4, 5, 6 ],
	 [ 7, 8, 9 ]
	]
	You should return [1,2,3,6,9,8,7,4,5].
 */
public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		if (matrix == null || matrix.length == 0) {
			return result;
		}
		int startX = 0, endX = matrix.length - 1;
		int startY = 0, endY = matrix[0].length - 1;
		while (startX <= endX && startY <= endY) {
			for (int i = startY; i <= endY; i++) {
				result.add(matrix[startX][i]);
			}
			for (int i = startX + 1; i <= endX; i++) {
				result.add(matrix[i][endY]);
			}
			if (startX != endX) {
				for (int i = endY - 1; i >= startY; i--) {
					result.add(matrix[endX][i]);
				}
			}
			if (startY != endY) {
				for (int i = endX - 1; i > startX; i--) {
					result.add(matrix[i][startY]);
				}
			}
			startX++;
			endX--;
			startY++;
			endY--;
		}
		return result;
	}
}