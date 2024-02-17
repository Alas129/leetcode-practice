import java.util.PriorityQueue;

class KLE_Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                // remove the smallest element if heap size exceed k
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}

public class KLargestElement {
    public static void main(String[] args) {
        KLE_Solution solution = new KLE_Solution();

        // test
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        System.out.println("Kth largest element in nums1: " + solution.findKthLargest(nums1, k1));

        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        System.out.println("Kth largest element in nums2: " + solution.findKthLargest(nums2, k2));
    }
}
