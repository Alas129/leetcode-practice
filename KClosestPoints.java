import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPoints {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(k, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]);
            }
        });

        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][2];
        while (k > 0) {
            k--;
            result[k] = maxHeap.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        KClosestPoints solution = new KClosestPoints();

        int[][] points1 = {{1, 3}, {-2, 2}};
        int k1 = 1;
        int[][] closest1 = solution.kClosest(points1, k1);
        System.out.println(Arrays.deepToString(closest1));

        int[][] points2 = {{3, 3}, {5, -1}, {-2, 4}};
        int k2 = 2;
        int[][] closest2 = solution.kClosest(points2, k2);
        System.out.println(Arrays.deepToString(closest2));
    }
}
