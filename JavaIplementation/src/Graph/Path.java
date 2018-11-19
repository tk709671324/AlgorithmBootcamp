package Graph;

import java.util.Stack;
import java.util.Vector;

public class Path {

    private Graph g;
    private int src;
    private boolean[] visited;
    private int[] from;


    private void dfs(int v) {
        visited[v] = true;

        for (int i : g.adj(v)) {
            if (!visited[i]) {
                from[i] = v;
                dfs(i);
            }
        }
    }

    public Path(Graph g, int src) {

        if (g == null || src < 0 || src >= g.V()) {
            throw new IllegalArgumentException("Illegal Path Constructor Argument");
        }

        this.g = g;
        this.src = src;
        visited = new boolean[g.V()];
        from = new int[g.V()];

        for (int i = 0; i < g.V(); i++) {
            from[i] = -1;
            visited[i] = false;
        }

        dfs(src);
    }

    public boolean hasPath(int v) {
        if (v < 0 || v >= g.V()) {
            throw new IllegalArgumentException();
        }

        return visited[v];
    }

    public Vector<Integer> path(int v) {
        if (!hasPath(v)) {
            throw new IllegalArgumentException("Path doesn't exist");
        }

        int p = v;
        Stack<Integer> stack = new Stack<>();

        while (p != -1) {
            stack.push(p);
            p = from[p];
        }

        Vector<Integer> res = new Vector<>();
        while (!stack.empty()) {
            res.add(stack.pop());
        }

        return res;

    }

    public void showPath(int v) {
        if (!hasPath(v)) {
            throw new IllegalArgumentException("Path doesn't exist");
        }

        Vector<Integer> vec = path(v);

        for (int i = 0; i < vec.size(); i++) {
            System.out.println(vec.elementAt(i));
            if (i != vec.size() - 1) {
                System.out.println(" -> ");
            }else {
                System.out.println();
            }
        }
    }
}
