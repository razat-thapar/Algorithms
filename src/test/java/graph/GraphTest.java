package graph;

public class GraphTest {
    // Add test cases here to validate the chromaticNumber method
    @org.junit.jupiter.api.Test
    void chromaticNumberHandlesGraphWithNoEdges() {
        Graph undirectedGraph = new Graph.Builder(5).build();

        int result = undirectedGraph.chromaticNumber();

        org.junit.jupiter.api.Assertions.assertEquals(1, result);
    }

    @org.junit.jupiter.api.Test
    void chromaticNumberHandlesGraphWithSingleEdge() {
        Graph undirectedGraph = new Graph.Builder(2)
                .addEdge(0, 1)
                .build();

        int result = undirectedGraph.chromaticNumber();

        org.junit.jupiter.api.Assertions.assertEquals(2, result);
    }

    @org.junit.jupiter.api.Test
    void chromaticNumberHandlesWeightedGraph() {
        Graph weightedGraph = new Graph.Builder(3)
                .setWeighted(true)
                .addEdge(0, 1, 5)
                .addEdge(1, 2, 10)
                .build();

        int result = weightedGraph.chromaticNumber();

        org.junit.jupiter.api.Assertions.assertEquals(2, result);
    }

    @org.junit.jupiter.api.Test
    void chromaticNumberHandlesDirectedGraph() {
        Graph directedGraph = new Graph.Builder(3)
                .setDirected(true)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .build();

        int result = directedGraph.chromaticNumber();

        org.junit.jupiter.api.Assertions.assertEquals(1, result);
    }

    @org.junit.jupiter.api.Test
    void chromaticNumberHandlesGraphWithSelfLoopAndEdges() {
        Graph undirectedGraph = new Graph.Builder(3)
                .addEdge(0, 0)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .build();

        int result = undirectedGraph.chromaticNumber();

        org.junit.jupiter.api.Assertions.assertEquals(-1, result);
    }

    @org.junit.jupiter.api.Test
    void chromaticNumberHandlesGraphWithDisconnectedComponents() {
        Graph undirectedGraph = new Graph.Builder(6)
                .addEdge(0, 1)
                .addEdge(2, 3)
                .addEdge(4, 5)
                .build();

        int result = undirectedGraph.chromaticNumber();

        org.junit.jupiter.api.Assertions.assertEquals(2, result);
    }
    @org.junit.jupiter.api.Test
    void chromaticNumberHandlesEmptyGraph() {
        Graph emptyGraph = new Graph.Builder(0).build();

        int result = emptyGraph.chromaticNumber();

        org.junit.jupiter.api.Assertions.assertEquals(0, result);
    }

    @org.junit.jupiter.api.Test
    void chromaticNumberHandlesGraphWithMultipleSelfLoops() {
        Graph graphWithSelfLoops = new Graph.Builder(3)
                .addEdge(0, 0)
                .addEdge(1, 1)
                .addEdge(2, 2)
                .build();

        int result = graphWithSelfLoops.chromaticNumber();

        org.junit.jupiter.api.Assertions.assertEquals(-1, result);
    }

    @org.junit.jupiter.api.Test
    void chromaticNumberHandlesFullyConnectedGraph() {
        Graph fullyConnectedGraph = new Graph.Builder(4)
                .addEdge(0, 1)
                .addEdge(0, 2)
                .addEdge(0, 3)
                .addEdge(1, 2)
                .addEdge(1, 3)
                .addEdge(2, 3)
                .build();

        int result = fullyConnectedGraph.chromaticNumber();

        org.junit.jupiter.api.Assertions.assertEquals(4, result);
    }

    @org.junit.jupiter.api.Test
    void chromaticNumberHandlesGraphWithWeightedAndUnweightedEdges() {
        Graph mixedGraph = new Graph.Builder(4)
                .setWeighted(true)
                .setDirected(false)
                .addEdge(0, 1, 5)
                .addEdge(1, 2, 10)
                .setWeighted(false)
                .addEdge(2, 3)
                .build();

        int result = mixedGraph.chromaticNumber();

        org.junit.jupiter.api.Assertions.assertEquals(2, result);
    }

    @org.junit.jupiter.api.Test
    void chromaticNumberHandlesGraphWithIsolatedVertices() {
        Graph graphWithIsolatedVertices = new Graph.Builder(5)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .build();

        int result = graphWithIsolatedVertices.chromaticNumber();

        org.junit.jupiter.api.Assertions.assertEquals(2, result);
    }

    @org.junit.jupiter.api.Test
    void chromaticNumberHandlesBipartiteGraph() {
        Graph bipartiteGraph = new Graph.Builder(4)
                .addEdge(0, 1)
                .addEdge(0, 2)
                .addEdge(1, 3)
                .addEdge(2, 3)
                .build();

        int result = bipartiteGraph.chromaticNumber();

        org.junit.jupiter.api.Assertions.assertEquals(2, result);
    }

    @org.junit.jupiter.api.Test
    void chromaticNumberHandlesEvenCyclicGraph() {
        Graph cyclicGraph = new Graph.Builder(4)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 3)
                .addEdge(3, 0)
                .build();

        int result = cyclicGraph.chromaticNumber();

        org.junit.jupiter.api.Assertions.assertEquals(2, result);
    }
    @org.junit.jupiter.api.Test
    void chromaticNumberHandlesOddCyclicGraph() {
        Graph cyclicGraph = new Graph.Builder(3)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 0)
                .build();

        int result = cyclicGraph.chromaticNumber();

        org.junit.jupiter.api.Assertions.assertEquals(3, result);
    }
}
