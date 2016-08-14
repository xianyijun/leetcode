package cn.xianyijun.leetcode;

/**
 * @author xianyijun
 *	The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

	P   A   H   N
	A P L S I I G
	Y   I   R
	And then read line by line: "PAHNAPLSIIGYIR"
	Write the code that will take a string and make this conversion given a number of rows:
	
	string convert(string text, int nRows);
	convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class ZigZagConversion {
	public String convert(String s, int numRows) {
		if (s == null || s.length() == 0) {
			return "";
		}
		int len = s.length();
		if (numRows > len || numRows == 1) {
			return s;
		}
		StringBuilder sb = new StringBuilder();
		int count = 0;
		int step = 2 * (numRows - 1);
		char[] chars = s.toCharArray();
		for (int i = 0; i < numRows; i++) {
			int interval = step - 2 * i;
			for (int j = i; j < chars.length; j++) {
				sb.append(chars[j]);
				if (interval > 0 && interval < step && j + interval < len && count < len) {
					sb.append(j + interval);
					count++;
				}
			}
		}
		return sb.toString();
	}
}
