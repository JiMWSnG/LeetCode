package javaSrc.LeetCode;

import java.util.*;

/**
 * @Author jimwong
 * @since 2018/4/10  下午11:15
 */
public class InsertInterval {
    /**
     * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
     *
     * You may assume that the intervals were initially sorted according to their start times.
     *
     * Example 1:
     * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
     *
     * Example 2:
     * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
     *
     * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
     */




    /***********
     ** right **
     ***********/
    public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
    }

    Set<Interval> set;

    public InsertInterval(){
        Comparator<Interval> comparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        };
        set = new TreeSet<>(comparator);

    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> removeList = new ArrayList<>();
        int curStart = newInterval.start;
        int curEnd = newInterval.end;
        for (Interval i : intervals){
            // merge
            if (isIn(i.start, i.end, curStart) || isIn(i.start, i.end, curEnd)){
                curStart = i.start < curStart ? i.start : curStart;
                curEnd = i.end > curEnd ? i.end : curEnd;
                removeList.add(i);
                // remove
            }else if (isLeftOut(i.start, i.end, curStart) && isRightOut(i.start, i.end, curEnd)){
                removeList.add(i);
            }
        }
        intervals.removeAll(removeList);
        intervals.add(new Interval(curStart,curEnd));
        intervals.sort(Comparator.comparing((Interval a) -> a.start));
        return intervals;
    }

    private boolean isIn(int left, int right, int cur){
        return cur >= left && cur <= right;
    }

    private boolean isLeftOut(int left, int right, int cur){
        return cur < left && cur < right;
    }

    private boolean isRightOut(int left ,int right, int cur){
        return cur > left && cur > right;
    }

}
