public class BucketSort {
    public int[] topKFrequent(int[] nums, int k) {
        // initialize
        Map<Integer, Integer> freqMap = new HashMap();
        for (int n: nums) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }

        // if there is only one number in nums
        List<Integer>[] bucket = new List[nums.length+1];
        for (int key : freqMap.keySet()) {
            int freq = freqMap.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new LinkedList<>();
            }
            bucket[freq].add(key);
        }

        List<Integer> result = new LinkedList<>();
        for (int i=bucket.length-1; i>0 && k>0; i--) {
            if (bucket[i] != null) {
                List<Integer> list = bucket[i];
                result.addAll(list);
                k -= list.size();
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();

    }
}
