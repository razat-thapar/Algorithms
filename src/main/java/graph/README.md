# 🧠 Graph Algorithms in OOP Design

## 📘 Overview
Implements **graph algorithms** using **Object-Oriented Programming** principles.  
Focuses on clean class design, flexibility, and reusability.

---

## ✨ Features

- **Graph Representation**
    - Directed / Undirected
    - Weighted / Unweighted
    - Self-loops, isolated vertices

- **Algorithms**
    - Chromatic Number (Graph Coloring)
    - More algorithms to come (MST, Shortest Path, etc.)

---

## ⚙️ OOP Principles Applied
- **Encapsulation:** Vertices, Edges, and Graph are independent classes
- **Builder Pattern:** Create flexible graph structures
- **Extensibility:** Easily plug in new algorithms

---

## 🧩 Example Usage

```java
Graph graph = new Graph.Builder(4)
    .setDirected(false)
    .setWeighted(false)
    .addEdge(0, 1)
    .addEdge(1, 2)
    .addEdge(2, 3)
    .addEdge(3, 0)
    .build();

int chromaticNumber = graph.chromaticNumber();
````

---

## 🧪 Testing

```bash
mvn test
```

Covers:

* Bipartite, cyclic, and disconnected graphs
* Edge cases with self-loops

---

## 🗺️ Roadmap

* Dijkstra / Bellman-Ford / Floyd-Warshall
* Prim / Kruskal MST
* Topological Sort
* Tarjan’s SCC
* Dynamic updates

---

## 📂 File Structure

```
src/main/java/graph/
 ├── Graph.java
 ├── Builder.java
 ├── ChromaticNumber.java
 └── README.md
```

---

## 🧾 License

MIT License — see [root LICENSE](../../LICENSE)

```
