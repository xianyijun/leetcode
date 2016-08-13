package cn.xianyijun.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xianyijun
 *Given a string, find the length of the longest substring without repeating characters.

	Examples:
	
	Given "abcabcbb", the answer is "abc", which the length is 3.
	
	Given "bbbbb", the answer is "b", with the length of 1.
	
	Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int max = 0;
		int left = 0;
		int right = 0;
		char[] chars = s.toCharArray();
		Set<Character> set = new HashSet<>();
		while (right < chars.length) {
			if (set.contains(chars[right])) {
				max = Math.max(max, right - left);
				while (chars[left] != chars[right]) {
					set.remove(chars[left]);
					left++;
				}
				left++;
			} else {
				set.add(chars[right]);
			}
			right++;
		}
		max = Math.max(max, right - left);
		return max;
	}
}
