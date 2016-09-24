package cn.xianyijun.leetcode;

/**
 * @author xianyijun
 *Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
 */
public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length())
			return false;
		boolean[] match = new boolean[s1.length() + 1];
		match[0] = true;
		for (int i = 0; i < s1.length(); i++) {
			match[i + 1] = match[i] && s1.charAt(i) == s3.charAt(i);
		}
		for (int i = 0; i < s2.length(); i++) {
			match[0] = match[0] && s2.charAt(i) == s3.charAt(i);
			for (int j = 0; j < s1.length(); j++) {
				match[j + 1] = match[j + 1] && s2.charAt(i) == s3.charAt(i + j + 1)
						|| match[j] && s1.charAt(j) == s3.charAt(i + j + 1);
			}
		}
		return match[s1.length()];
	}
}
