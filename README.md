# Project on Algorithmic Complexity and Tree Structures in Java

This repository contains the implementation of the **Individual Project 2** for the course *Analysis and Design of Data and Algorithms (ADDA/EDA)*, academic year **2023–2024**.  
The objective of this project was to analyze **algorithmic complexity** and implement different algorithms related to **recursion, iteration, and tree data structures**, both binary and n-ary.

---

## 📘 Project Overview

This project explores the theoretical and experimental aspects of algorithm design, focusing on:

- **Execution time analysis** for recursive and iterative algorithms.
- **Complexity comparison** between theoretical predictions and empirical results.
- **Design and verification** of balanced binary and n-ary trees.
- **Recursive traversal** of trees to extract meaningful paths based on numeric and logical conditions.

The project was fully implemented in **Java**, following modular design principles and ensuring that each exercise can be tested independently.

---

## 🧩 Exercises Implemented

### **Exercise 1 – Recursive and Iterative Function f(a)**
A function `f(a)` was defined recursively as: 


`f(a) = 10  if  a < 6`<p>
`f(a) = Math.pow(a, 3) * f(a - 1)  otherwise`

Two implementations were developed:
- **Recursive** version using direct definition.
- **Iterative** version using loops.

Execution times were measured for both versions, comparing results using the **Double** and **BigInteger** data types.  
The analysis included a theoretical complexity study and an empirical comparison through performance charts.

---

### **Exercise 2 – Merge Sort Complexity Analysis**
Using a provided implementation of **Merge Sort**, several experiments were conducted to study the **influence of the base case threshold** on runtime performance.

Tasks included:
- Measuring execution time for various input sizes.
- Varying the threshold size for the base case.
- Comparing results to the expected theoretical complexity of *O(n log n)*.

---

### **Exercise 3 – Balanced Tree Detection**
This exercise focused on designing a recursive algorithm to determine whether a given tree is **balanced**.

A tree is balanced if:
1. It is empty, or  
2. It is a leaf, or  
3. The difference in height between all its child subtrees is at most one, and all subtrees are themselves balanced.

Two variants were developed:
- **Binary tree balance check**
- **N-ary tree balance check**

The solution uses recursion to compute subtree heights and validate balance conditions efficiently.

---

### **Exercise 4 – Path Discovery in Trees**
Given a binary or n-ary tree of integers, the algorithm returns a list of **all root-to-leaf paths** such that:

> The sum of the node values along the path is divisible by the length of that path.

Each path is represented as a list of integers `[root, ..., leaf]`.

Both binary and n-ary versions were implemented recursively, exploring all possible paths and filtering those that satisfy the divisibility condition.

---

## ⚙️ Implementation Details

- Implemented in **Java 17** using **Eclipse IDE**.
- Each exercise is structured in an independent class and tested with separate input files.
- Results (including timing data and output validation) were printed to the console.
- Time measurements were conducted using `System.nanoTime()` and averaged across multiple runs.

> **Note:**  
> This public version of the project may not be fully compilable, as certain components rely on **university-provided libraries** that cannot be distributed outside the institutional environment.  
> These dependencies are limited to auxiliary classes for input handling and plotting.

---

## 📊 Performance Analysis

Exercises 1 and 2 include:
- Theoretical complexity derivations.  
- Runtime measurements for different input sizes.  
- Empirical graphs showing asymptotic behavior.  
- Comparisons between recursive and iterative approaches.

All analyses were carried out using the methodology taught during the course sessions.

---

## 🧭 Learning Outcomes

Through this project, the following learning goals were achieved:
- Understanding and quantifying **time complexity** of recursive and iterative algorithms.
- Applying recursion to real-world data structures such as **binary** and **n-ary trees**.
- Developing efficient methods for **tree traversal and condition-based filtering**.
- Strengthening analytical skills by comparing **theoretical** and **empirical** performance results.

---

## 🧾 License and Acknowledgment

This project was developed for educational purposes as part of the **Analysis and Design of Data and Algorithms** course.  
Some libraries and framework components remain **property of the University** and are therefore **not included** in this public repository.

---

## 👤 Author

**Mario Castro García**  
*Analysis and Design of Data and Algorithms – Individual Project 2 (2023–2024)*  

