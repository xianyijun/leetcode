package cn.xianyijun.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xianyijun
 *You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

	For example, given:
	s: "barfoothefoobarman"
	words: ["foo", "bar"]
	
	You should return the indices: [0,9].
	(order does not matter).
 */
public class SubstringwithConcatenationofAllWords {
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> list = new ArrayList<>();
		if (s == null || words.length == 0) {
			return list;
		}
		int wordLength = words[0].length();

		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			if (map.containsKey(words[i])) {
				map.put(words[i], map.get(words[i]) + 1);
			} else {
				map.put(words[i], 1);
			}
		}
		for (int i = 0; i < wordLength; i++) {
			Map<String, Integer> exists = new HashMap<>();
			int count = 0;
			int left = i;
			int right = i;
			while (right <= s.length() - wordLength) {
				String key = s.substring(right, right + wordLength);
				if (map.containsKey(key)) {
					if (exists.containsKey(key)) {
						int currentWordCount = exists.get(key);
						int maxWordCount = map.get(key);
						if (currentWordCount < maxWordCount) {
							exists.put(key, currentWordCount + 1);
							count++;
						} else {
							String temp = s.substring(left, left + wordLength);
							while (!temp.equals(key)) {
								exists.put(temp, exists.get(temp) - 1);
								left += wordLength;
								temp = s.substring(left, left + wordLength);
								count--;
							}
							left += wordLength;
						}

					} else {
						count++;
						exists.put(key, 1);
					}
					if (count == words.length) {
						list.add(left);
						exists.put(s.substring(left, left + wordLength),
								exists.get(s.substring(left, left + wordLength)) - 1);
						count--;
						left += wordLength;
					}
				} else {
					count = 0;
					exists.clear();
					left = right + wordLength;
				}
				right += wordLength;
			}
		}
		return list;
	}
}
