import java.util.*;

class Graph {
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            this.adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adjacencyList[v].add(w);
    }

    // Depth-First Search (DFS) traversal
    public void dfs(int startVertex) {
        boolean[] visited = new boolean[vertices];
        dfsUtil(startVertex, visited);
    }

    private void dfsUtil(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (Integer neighbor : adjacencyList[vertex]) {
            if (!visited[neighbor]) {
                dfsUtil(neighbor, visited);
            }
        }
    }

    // Breadth-First Search (BFS) traversal
    public void bfs(int startVertex) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (Integer neighbor : adjacencyList[vertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);

        // Adding edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);

        System.out.println("Depth-First Search (DFS) traversal starting from vertex 0:");
        graph.dfs(0);

        System.out.println("\n\nBreadth-First Search (BFS) traversal starting from vertex 0:");
        graph.bfs(0);
    }
}
