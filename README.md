```markdown
# Graph Algorithms in OOP Design

## Overview

This repository contains implementations of major graph algorithms written in an object-oriented programming (OOP) style. The code adheres to OOP design principles and patterns to ensure modularity, reusability, and maintainability. The primary focus is on providing a clean and extensible structure for graph-related algorithms.

## Features

- **Graph Representation**: 
  - Supports both directed and undirected graphs.
  - Handles weighted and unweighted edges.
  - Self-loops and isolated vertices are supported.
  
- **Algorithms**:
  - **Chromatic Number Calculation**: Determines the minimum number of colors required to color a graph such that no two adjacent vertices share the same color.
  - Additional algorithms can be added in the future.

- **Builder Pattern**: 
  - A flexible `Builder` class is provided to construct graph instances with various configurations (e.g., directed, weighted).

- **OOP Design Principles**:
  - Encapsulation: Graph and its components (e.g., edges) are encapsulated in classes.
  - Modularity: Each algorithm is implemented as a separate method or class.
  - Extensibility: The design allows for easy addition of new algorithms or graph features.

## Getting Started

### Prerequisites

- **Java**: Ensure you have Java 8 or later installed.
- **Maven**: This project uses Maven for dependency management and build automation.

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/graph-algorithms-oop.git
   cd graph-algorithms-oop
   ```

2. Build the project using Maven:
   ```bash
   mvn clean install
   ```

3. Run the tests to ensure everything is working:
   ```bash
   mvn test
   ```

### Usage

#### Creating a Graph

You can create a graph using the `Graph.Builder` class:

```java
Graph graph = new Graph.Builder(4)
    .setDirected(false)
    .setWeighted(false)
    .addEdge(0, 1)
    .addEdge(1, 2)
    .addEdge(2, 3)
    .addEdge(3, 0)
    .build();
```

#### Running Algorithms

For example, to calculate the chromatic number of a graph:

```java
int chromaticNumber = graph.chromaticNumber();
System.out.println("Chromatic Number: " + chromaticNumber);
```

### Testing

Unit tests are provided to validate the functionality of the graph algorithms. The tests cover:

- Happy paths (e.g., bipartite graphs, cyclic graphs).
- Edge cases (e.g., graphs with self-loops, disconnected components).

Run the tests using Maven:
```bash
mvn test
```

### Contributing

Contributions are welcome! If you'd like to add new algorithms or improve the existing code, please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature:
   ```bash
   git checkout -b feature-name
   ```
3. Commit your changes:
   ```bash
   git commit -m "Add feature description"
   ```
4. Push to your branch:
   ```bash
   git push origin feature-name
   ```
5. Open a pull request.

### Roadmap

- Add more graph algorithms:
    - Shortest Path (Dijkstra, Bellman-Ford, Floyd-Warshall).
    - Minimum Spanning Tree (Prim, Kruskal).
    - Topological Sorting.
    - Strongly Connected Components (Tarjan's Algorithm).
- Improve test coverage.
- Add support for dynamic graph updates.

### License

This project is licensed under the MIT License. See the `LICENSE` file for details.

### Contact

For any questions or suggestions, feel free to open an issue or contact the repository owner.
```