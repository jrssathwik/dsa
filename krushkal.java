import java.util.Arrays;
import java.util.Comparator;

class Edge {
    int src, dest, weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

public class KruskalAlgorithm {
    private int V, E; // Number of vertices and edges in the graph
    private Edge[] edges; // Array to store graph edges

    // Constructor
    KruskalAlgorithm(int v, int e) {
        V = v;
        E = e;
        edges = new Edge[E];
        for (int i = 0; i < e; ++i) {
            edges[i] = new Edge(0, 0, 0);
        }
    }

    // A utility method to find the set of an element i (uses path compression technique)
    private int find(int parent[], int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    // A utility method to do union of two sets of x and y (uses union by rank)
    private void union(int parent[], int x, int y) {
        int xRoot = find(parent, x);
        int yRoot = find(parent, y);
        parent[xRoot] = yRoot;
    }

    // The main function to construct MST using Kruskal's algorithm
    private void kruskalMST() {
        Edge result[] = new Edge[V]; // This will store the resultant MST
        int e = 0; // An index variable used for result[]

        // Step 1: Sort all the edges in non-decreasing order of their weight.
        Arrays.sort(edges, Comparator.comparingInt(o -> o.weight));

        // Allocate memory for creating V subsets
        int parent[] = new int[V];
        Arrays.fill(parent, -1);

        // Number of edges to be taken is equal to V-1
        while (e < V - 1) {
            // Step 2: Pick the smallest edge. Increment index for the next iteration.
            Edge nextEdge = edges[e++];

            int x = find(parent, nextEdge.src);
            int y = find(parent, nextEdge.dest);

            // Step 3: If including this edge does not cause a cycle, include it in the result and
            // increment the index of result[] for the next edge.
            if (x != y) {
                result[e - 1] = nextEdge;
                union(parent, x, y);
            }
        }

        // Print the constructed MST
        System.out.println("Minimum Spanning Tree using Kruskal's Algorithm:");
        for (int i = 0; i < e - 1; ++i)
            System.out.println(result[i].src + " - " + result[i].dest + ": " + result[i].weight);
    }

    public static void main(String[] args) {
        int V = 4; // Number of vertices in the graph
        int E = 5; // Number of edges in the graph
        KruskalAlgorithm graph = new KruskalAlgorithm(V, E);

        // Add edge 0-1
        graph.edges[0] = new Edge(0, 1, 10);
        // Add edge 0-2
        graph.edges[1] = new Edge(0, 2, 6);
        // Add edge 0-3
        graph.edges[2] = new Edge(0, 3, 5);
        // Add edge 1-3
        graph.edges[3] = new Edge(1, 3, 15);
        // Add edge 2-3
        graph.edges[4] = new Edge(2, 3, 4);

        // Call the Kruskal algorithm
        graph.kruskalMST();
    }
}
