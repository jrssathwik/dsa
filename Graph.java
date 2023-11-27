import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Graph {
    private int V; // Number of vertices
    private LinkedList<Integer>[] adj; // Adjacency list

    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    // Add an edge to the graph
    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // Depth-First Search (DFS) traversal
    public void DFS(int startVertex) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);

        System.out.println("DFS Traversal:");
        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();
            if (!visited[currentVertex]) {
                System.out.print(currentVertex + " ");
                visited[currentVertex] = true;
            }

            for (int neighbor : adj[currentVertex]) {
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                }
            }
        }
        System.out.println();
    }

    // Breadth-First Search (BFS) traversal
    public void BFS(int startVertex) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);

        System.out.println("BFS Traversal:");
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            if (!visited[currentVertex]) {
                System.out.print(currentVertex + " ");
                visited[currentVertex] = true;
            }

            for (int neighbor : adj[currentVertex]) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Graph graph = new Graph(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);

        int startVertex = 0; // Starting vertex for both DFS and BFS

        graph.DFS(startVertex);
        graph.BFS(startVertex);
    }
}
