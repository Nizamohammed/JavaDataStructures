# JavaDataStructures
Custom Java Data Structures – Built from scratch to understand core logic behind arrays, linked lists, sorting, reversing, and memory management.

📝 Final README.md (ready to paste into your GitHub repo):
# JavaDataStructures

A clean and lightweight implementation of core data structures in Java, designed from scratch. This project includes:

- 🧱 `DynamicArray` — a resizable array implementation with automatic grow/shrink.
- 🔗 `DoublyLinkedList` — a full-featured doubly linked list with sorting, reversing, and more.

Built for learning, extending, and showcasing classic data structure logic.

---

## 📁 Folder Structure
JavaDataStructures/
├── src/
│ └── ds/
│ ├── DynamicArray.java
│ ├── DoublyLinkedList.java
│ ├── Node.java
│ └── Main.java


All files are inside the `ds` package.

---

## 🚀 Features

### ✅ DynamicArray
- Auto-resizing (grow & shrink)
- `add`, `insert`, `pop`, `delete`
- Generic support
- `toString()` and `isEmpty()`

### ✅ DoublyLinkedList
- `addFirst`, `addLast`, `addAt`
- `removeFirst`, `removeLast`, `removeAt`
- `get`, `set`, `contains`, `indexOf`
- `reverse()`, `sort()` using Merge Sort
- `clear()` and `isEmpty()`

---

## 🛠️ How to Run

### Clone the Repo

```bash
git clone https://github.com/Nizamohammed/JavaDataStructures.git
cd JavaDataStructures
```

Compile
```bash
javac src/ds/*.java
```
Run
```bash
java -cp src ds.Main
```
This will run the Main.java file and demonstrate all the functionality of both classes.

🤝 Contributing
This repo is mainly educational and personal, but feel free to fork it or reach out if you want to collaborate or build on top of this.

📜 License
This project is open-source and available under the MIT License.
