# 🎵 Music Playlist Shuffle Algorithm

## 📘 Overview

This module simulates a **smart shuffle algorithm** similar to what streaming apps like **YouTube Music** or **Spotify** use.  
It balances **fairness**, **freshness**, and **user preference** using **weighted randomization** with **lazy deletion**.

---

## 🧠 Core Concept

Each song has a **dynamic weight**, updated continuously based on user interactions and playback data.

| Factor | Description |
|--------|--------------|
| ⏱️ Recency | Recently played songs get lower weight. |
| ❤️ Likes | Liked songs gain higher preference. |
| 🔁 Skips | Skipped songs are penalized. |
| 🔊 Completion Rate | Higher completion = higher weight. |
| 🕓 Time of Day | (Optional) Adjusts weights contextually. |

---

## ⚙️ Algorithm Design

### 1️⃣ Initialization
- All songs are wrapped in a `Song` object and pushed into a **`PriorityQueue<Song>`** (max-heap by weight).  
- The heap stores:
  - Up to **1000 songs** if playlist ≤ 1000  
  - Top **50 most relevant songs** otherwise  

### 2️⃣ Song Selection
- The top-weighted song is retrieved using `pq.poll()`.

### 3️⃣ Weight Updates
- After playback or skip, weight is recomputed using:
```java
public double computeWeight(Song s) {
    return s.likes * 2.0 - s.skips * 1.5
           + s.plays * 0.1
           - (System.currentTimeMillis() - s.lastPlayedTimestamp) * 0.0001;
}
````

### 4️⃣ Lazy Deletion

* When weights change, old heap entries become stale.
* On each poll, verify that the stored weight matches the recalculated one — otherwise discard and continue.

---

## 🧮 Complexity

| Operation        | Time     | Description                    |
| ---------------- | -------- | ------------------------------ |
| Insert / Update  | O(log n) | Maintain heap order            |
| Poll             | O(log n) | Retrieve next valid song       |
| Weight Recompute | O(1)     | Based on pre-stored attributes |

---

## 🚀 Future Work

* Context-aware shuffle (time of day, mood, location)
* Proportional randomization using **Fenwick Tree**
* ε-greedy exploration–exploitation tuning

---

## 📂 File Structure

```
src/main/java/music/
 ├── Song.java
 ├── ShuffleManager.java
 ├── WeightCalculator.java
 └── README.md
```

---

## 🧩 Example Usage

```java
ShuffleManager shuffle = new ShuffleManager(songs);
Song next = shuffle.getNextSong();
shuffle.updateWeight(next, userFeedback);
```

---

## 🧾 License

MIT License — see [root LICENSE](../../LICENSE)

````