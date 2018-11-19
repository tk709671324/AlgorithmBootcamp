package Graph;

public class Components {

    private Graph g;
    private boolean[] visited;
    private int compoNum;
    private int[] id;

    private void dfs(int v) {

        visited[v] = true;
        id[v] = compoNum;

        for (int i : g.adj(v)) {
            if (!visited[i]) {
                dfs(i);
            }
        }

    }

    public Components(Graph g) {
        this.g = g;

        visited = new boolean[g.V()];
        id = new int[g.V()];
        compoNum = 0;

        for (int i = 0; i < g.V(); i++) {
            visited[i] = false;
            id[i] = -1;
        }

        for (int i = 0; i < g.V(); i++) {
            if (!visited[i]) {
                dfs(i);
                compoNum++;
            }
        }
    }

    public int getCompoNum() {
        return compoNum;
    }

    public boolean isConnected(int v, int w) {
        assert v >= 0 && v < g.V();
        assert w >= 0 && w < g.V();

        return (id[v] == id[w]);
    }

}
