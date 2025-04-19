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

My main role during this was to do the TMParser class as well as the TMSimulator class. However, Jayce got on a roll and ended up doing the TMSimulator class, much to my surprise. The TMParser class went pretty smoothly, as it was really just figuring out the format of the strings. If we hadn't gone over it in lecture, then I think this would have been a good bit more challenging. The interface that Jayce had created definitely helped with this, as it allowed me to better visualize what was going on and needed from the class. One of the tricky parts however was trying to associate each line in the transition section with the correct (state, symbol) pair using the line number math. 

Then it was also important to pay close attention to the alphabet versus the tape symbols. The blank symbol '0' isn't a part of the input alphabet but it is a part of the tape alphabet. Then there was the issue of discovering and implementing the edge cases. Then it came to integrating it into TMSimulator. I was supposed to do this, but as previously stated, Jayce beat me to this part. He really was the carry behind this project. I did not get to contribute nearly as much as I wanted this time. 

This project did help me with getting a little more comfortable with parsing structured input since that has always been a weakpoint of mine. Handling exceptions hasn't been too bad but I think this project helped there as well. Then when being given a more open-ended interface, I feel like I performed fairly well compared to how I thought I would. I wasn't a fan of how empty the project description felt but Jayce carried that once again by going through and creating basically an outline oh what was to be needed. 


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