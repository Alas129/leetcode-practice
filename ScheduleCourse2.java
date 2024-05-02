import java.util.ArrayList;

public class ScheduleCourse2 {

    class Solution {
        static ArrayList<Integer>[] graph;
        static int v;
        static int e;

        static void addEdge(int a, int b) {
            graph[b].add(a);
        }

        public int[] findOrder(int num, int[][] pre) {
            v = num;
            e = pre.length;
            graph = new ArrayList[v];

            initializeGraph();
            buildGraph(pre);

            int[] indegree = calculateIndegree(pre);

            int[] ans = topologicalSort(indegree);

            if (ans.length != v) {
                return new int[0];
            } else {
                return ans;
            }
        }

        private void initializeGraph() {
            for (int i = 0; i < v; i++) {
                graph[i] = new ArrayList<>();
            }
        }

        private void buildGraph(int[][] pre) {
            for (int i = 0; i < pre.length; i++) {
                addEdge(pre[i][0], pre[i][1]);
            }
        }

        private int[] calculateIndegree(int[][] pre) {
            int[] indegree = new int[v];
            for (int i = 0; i < pre.length; i++) {
                indegree[pre[i][0]]++;
            }
            return indegree;
        }

        private int[] topologicalSort(int[] indegree) {
            int[] ans = new int[v];
            int idx = 0;
            int count = 0;

            while (idx < v) {
                boolean found = false;
                for (int i = 0; i < v; i++) {
                    if (indegree[i] == 0) {
                        found = true;
                        ans[idx++] = i;
                        for (int x : graph[i]) {
                            indegree[x]--;
                        }
                        indegree[i] = -1;
                        count++;
                    }
                }
                if (!found) {
                    return new int[0];
                }
            }
            if (count != v) {
                return new int[0];
            } else {
                return ans;
            }
        }
    }
}
