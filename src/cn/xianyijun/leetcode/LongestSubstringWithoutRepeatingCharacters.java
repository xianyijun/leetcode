package cn.xianyijun.leetcode;

import java.util.HashSet;
import java.util.Set;

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
