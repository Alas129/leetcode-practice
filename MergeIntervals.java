import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();

        for (int[] interval: intervals) {
            if (res.isEmpty() || res.get(res.size() - 1)[1] < interval[0]) {
                res.add(interval);
            } else {
                res.get(res.size() - 1)[1]  = Math.max(res.get(res.size() - 1)[1], interval[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}

public class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // test
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervals2 = {{1, 4}, {4, 5}};

        int[][] mergedIntervals1 = solution.merge(intervals1);
        int[][] mergedIntervals2 = solution.merge(intervals2);

        System.out.println("Merged Intervals1:" + Arrays.deepToString(mergedIntervals1));
        System.out.println("Merged Intervals2:" + Arrays.deepToString(mergedIntervals2));
    }
}