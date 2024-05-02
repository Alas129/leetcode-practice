import java.util.*;

public class NetworkDelayTime {
    class Solution {
        public int networkDelayTime(int[][] times, int n, int k) {
            Map<Integer, List<int[]>> graph = new HashMap<>();
            for (int[] time : times) {
                int u = time[0];
                int v = time[1];
                int w = time[2];
                graph.putIfAbsent(u, new ArrayList<>());
                graph.get(u).add(new int[]{v, w});
            }

            int[] distances = new int[n + 1];
            Arrays.fill(distances, Integer.MAX_VALUE);
            distances[k] = 0;

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            pq.offer(new int[]{k, 0});

            while (!pq.isEmpty()) {
                int[] node = pq.poll();
                int u = node[0];
                int distU = node[1];
                if (distU > distances[u]) continue; // Skip if we have already found a better distance
                if (graph.containsKey(u)) {
                    for (int[] edge : graph.get(u)) {
                        int v = edge[0];
                        int weightUV = edge[1];
                        if (distances[u] + weightUV < distances[v]) {
                            distances[v] = distances[u] + weightUV;
                            pq.offer(new int[]{v, distances[v]});
                        }
                    }
                }
            }

            int maxDistance = 0;
            for (int i = 1; i <= n; i++) {
                if (distances[i] == Integer.MAX_VALUE) {
                    return -1;
                }
                maxDistance = Math.max(maxDistance, distances[i]);
            }

            return maxDistance;
        }
    }
}
