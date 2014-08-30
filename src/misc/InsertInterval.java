package misc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liqiushi on 8/28/14.
 */
public class InsertInterval {
    public static void main(String[] args) {
        Interval i1 = new Interval(1, 2);
        Interval i2 = new Interval(3, 5);
        Interval i3 = new Interval(6, 7);
        Interval i4 = new Interval(8, 10);
        Interval i5 = new Interval(12, 16);

        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(i1);
        intervals.add(i2);
        intervals.add(i3);
        intervals.add(i4);
        intervals.add(i5);

        Interval interval = new Interval(4, 9);
        List<Interval> res = insert(intervals, interval);
        for (Interval i : res) {
            System.out.print(i.start + " : " + i.end);
            System.out.println();
        }
    }

    private static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<Interval>();
        if (intervals == null)
            return res;

        if (intervals.size() == 0) {
            res.add(newInterval);
            return res;
        }

        for (Interval interval : intervals) {
            if (interval.end < newInterval.start) {
                // before new interval
                res.add(interval);
            } else if (interval.start > newInterval.end) {
                // after the interval, time to add new interval,
                // but the current is not added yet, will be added at
                // the next iteration
                res.add(newInterval);
                newInterval = interval;
            } else if (interval.start <= newInterval.start || interval.end >= newInterval.end) {
                // keep expanding
                newInterval = new Interval(Math.min(interval.start, newInterval.start),
                        Math.max((interval.end), newInterval.end));
            }
        }
        res.add(newInterval);

        return res;
    }
}
