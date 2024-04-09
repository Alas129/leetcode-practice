import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindRelativeRanks {
    class Solution {
        public String[] findRelativeRanks(int[] score) {
            // Create a list of pairs (score, index)
            List<int[]> pairs = new ArrayList<>();
            for (int i = 0; i < score.length; i++) {
                pairs.add(new int[] { score[i], i });
            }

            // Sort the list of pairs based on score in descending order
            Collections.sort(pairs, (a, b) -> b[0] - a[0]);

            // Result array to store ranks
            String[] result = new String[score.length];

            // Assign ranks based on sorted order
            for (int i = 0; i < pairs.size(); i++) {
                int index = pairs.get(i)[1];
                if (i == 0) {
                    result[index] = "Gold Medal";
                } else if (i == 1) {
                    result[index] = "Silver Medal";
                } else if (i == 2) {
                    result[index] = "Bronze Medal";
                } else {
                    result[index] = String.valueOf(i + 1); // Convert placement to string
                }
            }

            return result;
        }
    }
}
