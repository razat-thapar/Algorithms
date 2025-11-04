# 🧩 Algorithms in OOP Design

Welcome to **Algorithms in OOP Design**, a curated collection of algorithm implementations written in Java using clean, modular, and object-oriented principles.

Each package explores a category of algorithms (like Graphs or Music Systems) with a focus on:
- Code readability and extensibility
- Real-world inspired design
- Efficient data structures

---

## 📚 Modules Overview

| Module                                                       | Description |
|--------------------------------------------------------------|-------------|
| [🎵 Music Playlist Shuffle](./src/main/java/music/README.md) | Dynamic shuffle system inspired by YouTube Music & Spotify, using weighted randomness and lazy deletion. |
| [🧠 graph.Graph Algorithms](./src/main/java/graph/README.md)               | OOP-based graph representation and algorithms (e.g., chromatic number, shortest paths). |
| 🧮 Sorting *(coming soon)*                                   | In-place and stable sorting algorithms with time–space tradeoffs. |
| 📈 Dynamic Programming *(coming soon)*                       | DP templates and common problem patterns. |

---

## 🧠 Design Philosophy

- **Encapsulation:** Each algorithm or domain is isolated in its own package.
- **Extensibility:** Adding a new algorithm means simply creating a new package + README.
- **Reusability:** Core data structures (like `graph.Graph`, `Node`, `Song`) can be extended.
- **Clarity:** Prioritize explanation and readability over micro-optimizations.

---

## ⚙️ Getting Started

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/razat-thapar/Algorithms.git
cd Algorithms/src/main/java
````

### 2️⃣ Explore Packages

Each package contains:

* Java source files (`*.java`)
* A dedicated `README.md` explaining the logic and usage

### 3️⃣ Run Tests

If using Maven:

```bash
mvn clean test
```

---

## 🧾 Contributing

Contributions are welcome! To add a new algorithm module:

1. Create a folder inside `src/main/java/`
2. Add your Java classes
3. Write a `README.md` (see templates below)
4. Update the root README’s module table

---

## ⚖️ License

Licensed under the **MIT License**.
See [LICENSE](../LICENSE) for details.

---

## 👤 Author

**Razat Aggarwal**
Software Engineer | Algorithm Enthusiast | DSA Practitioner
[GitHub Profile](https://github.com/razat-thapar)

````
