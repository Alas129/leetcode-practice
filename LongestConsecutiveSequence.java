import java.util.HashMap;

public class LongestConsecutiveSequence {
    class Solution {
        public int longestConsecutive(int[] nums) {
            HashMap<Integer, Integer> dict = new HashMap<>();

            for (int n : nums) {
                dict.put(n, dict.getOrDefault(n, 0) + 1);
            }

            int seq = 0;
            int n = 0;

            for (int i = 0; i < nums.length; i++) {
                n = nums[i];
                int currSeq = 0;

                if (!(dict.containsKey(n - 1))) {
                    currSeq++;
                    while (dict.containsKey(n+1)) {
                        currSeq++;
                        n++;
                    }
                }
                seq = Math.max(seq, currSeq);
            }

            return seq;

        }
    }
}
