package misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by liqiushi on 8/29/14.
 */
public class MergeIntervals {
    public static void main(String[] args) {
        Interval i1 = new Interval(1, 3);
        Interval i2 = new Interval(2, 6);
        Interval i3 = new Interval(8, 10);
        Interval i4 = new Interval(15, 18);

        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(i1);
        intervals.add(i2);
        intervals.add(i3);
        intervals.add(i4);

        List<Interval> res = merge(intervals);
        for (Interval i : res) {
            System.out.print(i.start + " : " + i.end);
            System.out.println();
        }

//        Interval i1 = new Interval(1, 4);
//        Interval i2 = new Interval(0, 0);
//
//        List<Interval> intervals = new ArrayList<Interval>();
//        intervals.add(i1);
//        intervals.add(i2);
//
//        List<Interval> res = merge(intervals);
//        for (Interval i : res) {
//            System.out.print(i.start + " : " + i.end);
//            System.out.println();
//        }

//        Interval i1 = new Interval(1, 10);
//        Interval i2 = new Interval(4, 5);
//        Interval i3 = new Interval(2, 3);
//        Interval i4 = new Interval(6, 7);
//        Interval i5 = new Interval(8, 9);
//
//        List<Interval> intervals = new ArrayList<Interval>();
//        intervals.add(i1);
//        intervals.add(i2);
//        intervals.add(i3);
//        intervals.add(i4);
//        intervals.add(i5);
//
//        List<Interval> res = merge(intervals);
//        for (Interval i : res) {
//            System.out.print(i.start + " : " + i.end);
//            System.out.println();
//        }
    }

    private static List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        if (intervals == null)
            return res;

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        for (int i = 0; i < intervals.size(); ) {
            if (i + 1 < intervals.size() && intervals.get(i).end < intervals.get(i + 1).start) {
                res.add(intervals.get(i));
                i++;
            } else {
                int start = intervals.get(i).start;
                int end = intervals.get(i).end;
                // expand the end dynamically
                while (i + 1 < intervals.size() && end >= intervals.get(i + 1).start) {
                    start = Math.min(start, intervals.get(i + 1).start);
                    end = Math.max(end, intervals.get(i + 1).end);
                    i++;
                }
                i++;
                res.add(new Interval(start, end));
            }
        }

        return res;
    }
}
