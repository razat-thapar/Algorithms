import java.util.ArrayList;
import java.util.List;
/**
 * The Graph class represents a graph data structure with support for both directed and undirected graphs,
 * as well as weighted and unweighted edges. It provides functionality to build and manipulate graphs
 * using the Builder pattern.
 *
 * Algorithms used in this class:
 * - Chromatic Number Calculation:
 *   - Binary Search + Backtracking:
 *     - Determines the minimum number of colors required to color the graph such that no two adjacent vertices
 *       share the same color.
 *     - Time Complexity: O(log(V) * V^V)
 *     - Space Complexity: O(V)
 *
 * Features:
 * - Supports directed and undirected graphs.
 * - Supports weighted and unweighted edges.
 * - Provides a Builder class for flexible graph construction.
 *
 * Usage:
 * Use the {@link Graph.Builder} class to create instances of the Graph.
 */

public class Graph {
    private final int V; // Number of vertices
    private boolean isDirected;
    private boolean isWeighted;
    private boolean hasSelfLoop;
    private final List<List<Edge>> adjList; // Adjacency list representation

    private Graph(int V, boolean isDirected, boolean isWeighted, boolean hasSelfLoop ,List<List<Edge>> adjList) {
        this.V = V;
        this.adjList = adjList;
    }

    public int getVertices() {
        return V;
    }

    public List<List<Edge>> getAdjList() {
        return adjList;
    }

    public int chromaticNumber() {
        // Problem: Given a graph, return its chromatic number. i.e., min colors required to color a graph such that no two adjacent vertices have the same color.
        // Solution: Binary Search + Backtracking
        // TC: O(logV * V^V) SC: O(V)
        //edge case
        if(this.hasSelfLoop) return -1; // Graph with self-loop cannot be colored
        int left = 1, right = V, ans = V;
        while (left < right) {
            int mid = (left + right) / 2;
            if (canColor(mid)) {
                ans = mid;
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private boolean canColor(int colors) {
        // Determine whether the graph can be colored with the given number of colors using backtracking
        int[] color = new int[V];
        return canColorUtil(0, color, colors);
    }

    private boolean canColorUtil(int v, int[] color, int colors) {
        // Backtracking algorithm to assign colors to vertices
        if (v == V) return true; // All vertices are assigned a color
        for (int c = 1; c <= colors; c++) {
            if (isSafe(v, color, c)) {
                color[v] = c; // Assign color c to vertex v
                if (canColorUtil(v + 1, color, colors)) return true;
                color[v] = 0; // Backtrack
            }
        }
        return false;
    }
    private boolean isSafe(int v, int[] color, int c) {
        for (Edge edge : adjList.get(v)) {
            // Check adjacency for undirected or directed graphs
            if (color[edge.getVertex()] == c) return false;
        }
        return true;
    }

    public static class Builder {
        private final Graph graph;

        public Builder(int V) {
            this.graph = new Graph(V, false, false, false, new ArrayList<>());
            for (int i = 0; i < V; i++) {
                graph.adjList.add(new ArrayList<>());
            }
        }

        public Builder setDirected(boolean isDirected) {
            graph.isDirected = isDirected;
            return this;
        }

        public Builder setWeighted(boolean isWeighted) {
            graph.isWeighted = isWeighted;
            return this;
        }

        public Builder addEdge(int u, int v) {
            if (graph.isWeighted) {
                throw new IllegalStateException("Weight is required for a weighted graph.");
            }
            if(u==v) graph.hasSelfLoop = true;
            graph.adjList.get(u).add(new Edge(v, 0));
            if (!graph.isDirected) {
                graph.adjList.get(v).add(new Edge(u, 0));
            }
            return this;
        }

        public Builder addEdge(int u, int v, int weight) {
            if (!graph.isWeighted) {
                throw new IllegalStateException("Cannot add weighted edges to an unweighted graph.");
            }
            if(u==v) graph.hasSelfLoop = true;
            graph.adjList.get(u).add(new Edge(v, weight));
            if (!graph.isDirected) {
                graph.adjList.get(v).add(new Edge(u, weight));
            }
            return this;
        }

        public Graph build() {
            return graph;
        }
    }

    public static class Edge {
        private final int vertex;
        private final int weight;

        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        public int getVertex() {
            return vertex;
        }

        public int getWeight() {
            return weight;
        }
    }
}