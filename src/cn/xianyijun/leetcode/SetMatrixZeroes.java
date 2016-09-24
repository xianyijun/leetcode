package cn.xianyijun.leetcode;

public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		if (matrix.length == 0) {
			return;
		}
		if (matrix[0].length == 0) {
			return;
		}
		boolean zeroCol = false;
		boolean zeroRow = false;
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[0][i] == 0) {
				zeroRow = true;
				break;
			}
		}
		for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[i][0] == 0) {
				zeroCol = true;
				break;
			}
		}
	}
}
