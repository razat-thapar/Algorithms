
# 🧩 Algorithms in Object-Oriented Design

Welcome to the **Algorithms Repository**, where each module demonstrates how classical algorithms can be implemented using **Object-Oriented Programming (OOP)** principles.  
This project focuses on clean architecture, extensibility, and real-world inspired algorithmic applications.

---

## 📚 Table of Contents

1. [Graph Algorithms](#1-graph-algorithms)
2. [Music Playlist Shuffle Algorithm](#2-music-playlist-shuffle-algorithm)
3. *(More coming soon — Sorting, Dynamic Programming, etc.)*

---

## 1️⃣ Graph Algorithms

### 📘 Overview

This package implements fundamental **Graph Algorithms** in an **object-oriented design**.  
It provides reusable and modular graph components that can be easily extended to support new algorithms.

#### ✨ Features

- **Graph Representation**
  - Directed / Undirected graphs
  - Weighted / Unweighted edges
  - Supports self-loops and isolated vertices

- **Implemented Algorithms**
  - **Chromatic Number Calculation** — Minimum colors required so that no adjacent vertices share a color

- **OOP Design Principles**
  - *Encapsulation* — Graph and its components (e.g., vertices, edges) are independent entities  
  - *Modularity* — Each algorithm lives in its own class or method  
  - *Extensibility* — Easily add new graph algorithms

---

### 🧩 Example

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

### 🧪 Testing

```bash
mvn test
```

Tests include:

* Bipartite and cyclic graphs
* Edge cases: self-loops, disconnected graphs

---

### 🗺️ Roadmap

* Shortest Path Algorithms — Dijkstra, Bellman-Ford, Floyd-Warshall
* Minimum Spanning Tree — Prim, Kruskal
* Topological Sorting
* Strongly Connected Components — Tarjan’s Algorithm
* Dynamic graph updates

---

## 2️⃣ Music Playlist Shuffle Algorithm

### 📘 Overview

This module implements a **dynamic playlist shuffle algorithm**, inspired by YouTube Music and Spotify.
It uses a **weighted priority mechanism** with **lazy deletion** to ensure a fair and intelligent shuffle experience.

---

### 🧠 Core Concept

Each song is assigned a **dynamic weight**, influenced by behavioral and contextual factors:

| Factor             | Description                                   |
| ------------------ | --------------------------------------------- |
| ⏱️ Recency         | Lower weight if recently played               |
| ❤️ Likes           | Higher weight for liked/favorite songs        |
| 🔁 Skips           | Penalized weight for frequently skipped songs |
| 🔊 Completion Rate | Rewards songs that are played fully           |
| 🕓 Time of Day     | Adjusts weight based on context (optional)    |

---

### ⚙️ Algorithm Workflow

1. **Initialize** a `PriorityQueue<Song>` storing up to 1000 songs

    * If playlist ≤ 1000 → use all
    * If playlist > 1000 → keep top 50 by weight

2. **Select Next Song**

    * Poll top element from the heap (highest weight)

3. **Recompute Weight Dynamically**

    * After playback/skip, recalculate and reinsert

4. **Lazy Deletion**

    * If an old entry becomes stale (outdated weight), skip it upon retrieval instead of removing all duplicates.

---

### 🧩 Example Code

```java
public class Song {
    int id;
    double weight;
    int likes, skips, plays;
    long lastPlayedTimestamp;
}

PriorityQueue<Song> pq = new PriorityQueue<>(
    (a, b) -> Double.compare(b.weight, a.weight)
);

public double computeWeight(Song s) {
    return s.likes * 2.0 - s.skips * 1.5
           + s.plays * 0.1
           - (System.currentTimeMillis() - s.lastPlayedTimestamp) * 0.0001;
}
```

---

### 🧮 Complexity

| Operation       | Time     | Description                   |
| --------------- | -------- | ----------------------------- |
| Insert / Update | O(log n) | Maintain max-heap             |
| Poll            | O(log n) | Fetch next top song           |
| Weight Update   | O(1)     | Recompute based on attributes |

---

### 🚀 Future Work

* Context-based shuffle (mood, time, genre)
* Proportional randomization (Fenwick / Segment Tree)
* Exploration vs exploitation (ε-greedy strategy)

---

### 📂 Folder Structure

```
src/main/java/
 ├── graph/
 │    ├── Graph.java
 │    ├── Builder.java
 │    └── ChromaticNumber.java
 │
 └── music/
      ├── Song.java
      ├── ShuffleManager.java
      ├── WeightCalculator.java
      └── README.md
```

---

## 🤝 Contributing

1. Fork the repo
2. Create your branch

   ```bash
   git checkout -b feature-name
   ```
3. Commit and push

   ```bash
   git commit -m "Add feature description"
   git push origin feature-name
   ```
4. Submit a pull request 🎉

---

## ⚖️ License

This project is licensed under the **MIT License** — see the `LICENSE` file for details.

---

## 👤 Author

**Razat Aggarwal**
Software Engineer | Algorithm Enthusiast | DSA Practitioner
[GitHub Profile](https://github.com/razat-thapar)

---
