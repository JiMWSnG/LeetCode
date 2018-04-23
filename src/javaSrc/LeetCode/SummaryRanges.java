package javaSrc.LeetCode;

import java.util.*;

public class SummaryRanges {
    /**
     * Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far as a list of disjoint intervals.
     *
     * For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:
     *
     * [1, 1]
     * [1, 1], [3, 3]
     * [1, 1], [3, 3], [7, 7]
     * [1, 3], [7, 7]
     * [1, 3], [6, 7]
     *
     * Follow up:
     * What if there are lots of merges and the number of disjoint intervals are small compared to the data stream's size?
     *
     * Credits:
     * Special thanks to @yunhong for adding this problem and creating most of the test cases.
     */

    /***********
     ** right **
     ***********/


    // Definition for an interval.
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    private Set<Interval> set;
    private List<Interval> merge = new ArrayList<>();

    /** Initialize your data structure here. */
    public SummaryRanges() {
        Comparator<Interval> comparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        };
        set = new TreeSet<>(comparator);
    }

    public void addNum(int val) {
        int size = set.size();
        boolean insert = true;
        if (size == 0){
            set.add(new Interval(val, val));
            return ;
        }
        for (Interval interval : set){
            int left = interval.start;
            int right = interval.end;
            if (val >= left && val <= right){
                return ;
            }
            if (val == left - 1 || val == right + 1){
                merge.add(interval);
                insert = false;
            }
        }
        int left = val;
        int right = val;

        if (!insert){
            for (Interval i : merge ){
                left = left < i.start ? left :i.start;
                right = right > i.end ? right : i.end;
                set.remove(i);
            }
            merge.clear();
        }
        set.add(new Interval(left, right));

    }

    public List<Interval> getIntervals() {
        List<Interval> result = new ArrayList<>();
        for (Interval i : set){
            result.add(i);
        }
        return result;
    }

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */
public static void main(String[] args) {
    SummaryRanges summaryRanges = new SummaryRanges();
    summaryRanges.addNum(1);
    System.out.println(summaryRanges.getIntervals().toString());

    summaryRanges.addNum(3);
    System.out.println(summaryRanges.getIntervals());

    summaryRanges.addNum(7);
    System.out.println(summaryRanges.getIntervals());

    summaryRanges.addNum(2);
    System.out.println(summaryRanges.getIntervals());

    summaryRanges.addNum(6);
    System.out.println(summaryRanges.getIntervals());
}
}
