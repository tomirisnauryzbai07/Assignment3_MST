REPORT
Assignment 3 - Minimum Spanning Tree
Student: Nauryzbay Tomiris SE-2436

1. Goal of the work
The main goal of this project is to create a program that find Minimum Spanning Tree (MST) of a graph using Prim’s and Kruskal’s algorithms.
The program read data from input.json and save the result to output.json.

2. About project
I made this project in IntelliJ IDEA using Java.
I used Maven because it’s easier to manage libraries and dependencies.
Also, I used Gson library from Google to work with JSON files.
The program does these things:
Reads graph data from input.json.
Creates a Minimum Spanning Tree using:
Prim’s Algorithm
Kruskal’s Algorithm
Shows results in console.
Saves result into output.json.
It was not very easy but I understand how these algorithms work better after doing this.

3. Project Structure
Assignment3_MST/
│
├── pom.xml
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/tomi/algorithms/
│   │           ├── Main.java
│   │           ├── Graph.java
│   │           ├── Edge.java
│   │           ├── PrimAlgorithm.java
│   │           ├── KruskalAlgorithm.java
│   │           └── JsonHandler.java
│   └── resources/
│       ├── input.json
│       └── output.json
└── README.md

Description of files:
Main.java — runs the whole program
Graph.java — class for vertices and edges
Edge.java — represents one edge between two nodes
PrimAlgorithm.java — implementation of Prim’s algorithm
KruskalAlgorithm.java — implementation of Kruskal’s algorithm
JsonHandler.java — reads from and writes to JSON files

4. Example of program running

input.json):
{
  "vertices": ["A", "B", "C", "D", "E"],
  "edges": [
    {"source": "A", "destination": "B", "weight": 4},
    {"source": "A", "destination": "C", "weight": 2},
    {"source": "B", "destination": "C", "weight": 1},
    {"source": "B", "destination": "D", "weight": 5},
    {"source": "C", "destination": "D", "weight": 8},
    {"source": "C", "destination": "E", "weight": 10},
    {"source": "D", "destination": "E", "weight": 2}
  ]
}

Console output:

Prim’s Algorithm MST:
A - C : 2
C - B : 1
A - D : 5
D - E : 2
Total weight: 10

Kruskal’s Algorithm MST:
B - C : 1
A - C : 2
D - E : 2
A - D : 5
Total weight: 10

output.jason

{
  "Prim": {
    "edges": [
      {"source": "A", "destination": "C", "weight": 2},
      {"source": "C", "destination": "B", "weight": 1},
      {"source": "A", "destination": "D", "weight": 5},
      {"source": "D", "destination": "E", "weight": 2}
    ],
    "totalWeight": 10
  },
  "Kruskal": {
    "edges": [
      {"source": "B", "destination": "C", "weight": 1},
      {"source": "A", "destination": "C", "weight": 2},
      {"source": "D", "destination": "E", "weight": 2},
      {"source": "A", "destination": "D", "weight": 5}
    ],
    "totalWeight": 10
  }
}

5.Result and conclusion

Both algorithms (Prim and Kruskal) find the same MST result and total weight.
This project helped me to understand how MST algorithms work in real life.
I also learned how to use Maven, connect Gson, and handle JSON files.
I think my project is simple, but it works good and clear.
