import java.util.ArrayList;

public class DFS {
    private void iterative(int n, ArrayList<ArrayList<Integer>> graph) {
        boolean[] visited = new boolean[n];
        int[] prev = new int[n];
        for (int i=0; i<n; ++i) prev[i] = -1;

        ArrayList<Integer> stack = new ArrayList<Integer>();
        stack.add(0);

        while (!stack.isEmpty()) {
            int u = stack.remove(stack.size()-1);

            ArrayList<Integer> neighbors = graph.get(u);
            for (int v : neighbors) {
                if (visited[v]) continue;
                
                stack.add(v);
                prev[v] = u;
                visited[v] = true;
            }
        }
    }

    public void recursive(int n, ArrayList<ArrayList<Integer>> graph) {
        boolean[] visited = new boolean[n];
        int[] prev = new int[n];
        for (int i=0; i<n; ++i) prev[i] = -1;

        recursive(graph, visited, prev, 0);
    }

    private void recursive(ArrayList<ArrayList<Integer>> graph, boolean[] visisted, int[] prev, int u) {
        if (visisted[u]) return;
        else visisted[u] = true;

        ArrayList<Integer> neighbors = graph.get(u);
        for (int v : neighbors) {
            prev[v] = u;
            recursive(graph, visisted, prev, v);
        }
    }
}
