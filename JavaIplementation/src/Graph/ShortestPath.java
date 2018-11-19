package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class ShortestPath {

    private Graph g;
    private int src;
    private boolean[] visited;
    private int[] from;
    private int[] ord;


    public ShortestPath(Graph g, int src) {
        if (g == null || src < 0 || src >= g.V()) {
            throw new IllegalArgumentException("Illegal Path Constructor Argument");
        }

        this.g = g;
        this.src = src;
        visited = new boolean[g.V()];
        from = new int[g.V()];
        ord = new int[g.V()];

        for (int i = 0; i < g.V(); i++) {
            visited[i] = false;
            from[i] = -1;
            ord[i] = -1;
        }

        bfs(src);
    }

    public void bfs(int s) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(s);
        visited[s] = true;
        ord[s] = 0;

        while (!queue.isEmpty()) {
            int u = queue.remove();

            for (int v : g.adj(u)) {
                visited[v] = true;
                from[v] = u;
                ord[v] = ord[u] + 1;
                queue.add(v);
            }
        }
    }


    public boolean hasPath(int v) {
        if (v < 0 || v >= g.V()) {
            throw new IllegalArgumentException();
        }

        return visited[v];
    }

    public int length(int v) {
        if (!hasPath(v)) {
            throw new IllegalArgumentException("Path doesn't exist");
        }

        return ord[v];
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
