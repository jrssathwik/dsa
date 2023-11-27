import java.util.Arrays;

public class PrimAlgorithm {
    private static final int V = 5; // Number of vertices in the graph

    // A utility method to find the vertex with the minimum key value,
    // which is not yet included in the MST
    private int minKey(int key[], Boolean mstSet[]) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    // A utility method to print the constructed MST stored in parent[]
    private void printMST(int parent[], int graph[][]) {
        System.out.println("Edge   Weight");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "    " + graph[i][parent[i]]);
        }
    }

    // Function to construct and print the MST for a graph represented using adjacency matrix representation
    private void primMST(int graph[][]) {
        int parent[] = new int[V]; // Array to store constructed MST
        int key[] = new int[V]; // Key values used to pick minimum weight edge in cut
        Boolean mstSet[] = new Boolean[V]; // To represent set of vertices included in MST

        // Initialize all keys as INFINITE
        Arrays.fill(key, Integer.MAX_VALUE);

        // Always include first  vertex in MST
        key[0] = 0; // Make key 0 so that this vertex is picked as first vertex
        parent[0] = -1; // First node is always root of MST

        // The MST will have V vertices
        for (int count = 0; count < V - 1; count++) {
            // Pick the minimum key vertex from the set of vertices not yet included in MST
            int u = minKey(key, mstSet);

            // Add the picked vertex to the MST set
            mstSet[u] = true;

            // Update key value and parent index of the adjacent vertices of the picked vertex
            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        // Print the constructed MST
        printMST(parent, graph);
    }

    public static void main(String[] args) {
        PrimAlgorithm prim = new PrimAlgorithm();

        int graph[][] = new int[][]{{0, 2, 0, 6, 0},
                                    {2, 0, 3, 8, 5},
                                    {0, 3, 0, 0, 7},
                                    {6, 8, 0, 0, 9},
                                    {0, 5, 7, 9, 0}};

        // Print the Minimum Spanning Tree
        prim.primMST(graph);
    }
}
