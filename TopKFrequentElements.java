import java.util.*;

class TopKFrequentElements_Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
        for (int n: nums) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }
        for (int key: freqMap.keySet()) {
            int freq = freqMap.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        List<Integer> res = new ArrayList<>();
        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res.stream().mapToInt(i->i).toArray();
    }
}

public class TopKFrequentElements {
    public static void main(String[] args) {
        TopKFrequentElements_Solution solution = new TopKFrequentElements_Solution();

        // Test cases
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        System.out.println(k1 + "th frequent elements: " + Arrays.toString(solution.topKFrequent(nums1, k1)));

        int[] nums2 = {1};
        int k2 = 1;
        System.out.println(k2 + "th frequent elements: " + Arrays.toString(solution.topKFrequent(nums2, k2)));
    }
}
