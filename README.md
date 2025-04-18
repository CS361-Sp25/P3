# Project 2: Turing Machine Simulator

* Author: Jayce Lowry and Chase Stombaugh
* Class: CS361 Section 1
* Semester: Spring 2025

## Overview

This project simulates a deterministic Turing Machine using Java. The simulator reads an encoded input file describing the Turing Machine and an input string, then models the TM's execution on a bi-infinite tape. The simulator outputs the contents of all tape cells visited during the computation.

The Turing Machine follows the standard formal definition with:
* A finite set of states Q
* A tape alphabet Γ including a reserved blank symbol '0'
* An input alphabet Σ = {1, 2, ..., m}, excluding '0'
* A deterministic transition function δ
* A designated start state q₀ = 0
* A halting (accepting) state qₙ = n - 1

The TM processes transitions encoded in the input file and halts once the accepting state is reached.

## Reflection

### Jayce



### Chase



## Compiling and Using

### Compiling
To compile the NFA implementation and test cases on the Onyx server, navigate to the 
project's root directory and run:

```shell
javac tm/*.java
```


This will compile all necessary source files in the tm package.

### Running

To run the Turing Machine simulator on an encoded TM input file, use:

```shell
java tm.TMSimulator <filename>
```

## Sources used

https://docs.oracle.com/javase/8/docs/api/java/io/BufferedReader.html - Used for reading input files
Course notes and examples - guidance on TM structure and simulation