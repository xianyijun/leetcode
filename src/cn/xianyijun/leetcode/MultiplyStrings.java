package cn.xianyijun.leetcode;

public class MultiplyStrings {
	public static String multiply(String num1, String num2) {
		if (num1.isEmpty() && num2.isEmpty()) {
			return "";
		}
		int i = 0;
		int j = 0;
		int[] result = new int[num1.length() + num2.length()];
		for (i = num1.length() - 1; i >= 0; i--) {
			int dig1 = num1.charAt(i) - '0';
			int carry = 0;
			for (j = num2.length() - 1; j >= 0; j--) {
				int dig2 = num2.charAt(j) - '0';
				int exist = result[i + j + 1];
				result[i + j + 1] = (dig1 * dig2 + exist + carry) % 10;
				carry = (dig1 * dig2 + exist + carry) / 10;
			}
			result[i + j + 1] = carry;
		}
		int count = 0;
		while (count < result.length - 1 && result[count] == 0) {
			count++;
		}
		StringBuilder sb = new StringBuilder();
		while (count < result.length) {
			sb.append(result[count++]);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(multiply("9", "9"));
	}
}
