import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class BFS {
    public static void iterative(int n, ArrayList<ArrayList<Integer>> graph) {
        boolean[] visited = new boolean[n];
        int[] prev = new int[n];
        for (int i=0;i<n;++i) prev[i] = -1;

        Deque<Integer> queue = new LinkedList<Integer>();
        
        queue.push(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int u = queue.pop();

            ArrayList<Integer> neighbors = graph.get(u);
            for (int v : neighbors) {
                if (visited[v]) continue;

                visited[v] = true;
                prev[v] = u;
                queue.push(v);
            }
        }
    }
}
