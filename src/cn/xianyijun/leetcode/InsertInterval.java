package cn.xianyijun.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InsertInterval {
	public static class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> result = new ArrayList<>();
		if (intervals == null || intervals.isEmpty()) {
			result.add(newInterval);
			return result;
		}
		intervals.add(newInterval);
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});

		int start = intervals.get(0).start;
		int end = intervals.get(0).end;
		for (int i = 1; i < intervals.size(); i++) {
			if (intervals.get(i).start > end) {
				result.add(new Interval(start, end));
				start = intervals.get(i).start;
				end = intervals.get(i).end;
			} else if (intervals.get(i).end > end) {
				end = intervals.get(i).end;
			} else {

			}
		}
		result.add(new Interval(start, end));
		return result;
	}
}
