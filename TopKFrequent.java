import java.util.*;

public class TopKFrequent {
    class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            // Step 1: Count frequency of each word
            Map<String, Integer> frequencyMap = new HashMap<>();
            for (String word : words) {
                frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            }

            // Step 2: Use a min heap to maintain top k frequent words
            PriorityQueue<String> minHeap = new PriorityQueue<>(
                    (word1, word2) -> frequencyMap.get(word1).equals(frequencyMap.get(word2)) ?
                            word2.compareTo(word1) :
                            frequencyMap.get(word1) - frequencyMap.get(word2)
            );

            for (String word : frequencyMap.keySet()) {
                minHeap.offer(word);
                if (minHeap.size() > k) {
                    minHeap.poll(); // Remove the least frequent word if heap size exceeds k
                }
            }

            // Step 3: Retrieve the result from the min heap
            List<String> result = new ArrayList<>();
            while (!minHeap.isEmpty()) {
                result.add(minHeap.poll());
            }

            // Step 4: Reverse the list to get words sorted by frequency (highest to lowest)
            Collections.reverse(result);

            return result;
        }
    }
}
