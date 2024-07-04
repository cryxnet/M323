# Scala N-Queens Problem Solver

This Scala application solves the N-Queens problem using recursion and backtracking. It employs functional programming principles such as immutability, pure functions, and higher-order functions. The application allows users to specify board dimensions, the number of queens, and whether to display all possible solutions or just the count.

## Features

- Solves the N-Queens problem for any board size and number of queens.
- Utilizes recursion and backtracking for the solution.
- Implements functional programming principles.
- Command-line interface for setting board dimensions and number of queens.
- Option to display all solutions or just the count of solutions.

## Prerequisites

- Scala (version 2.12 or later)
- Java JDK (version 8 or later)

## Usage

To compile and run the program, use the following commands:

```sh
scala main.scala [options]
```

### Command-Line Options

- `--height <height>`: Specifies the height of the board. Default is `12`.
- `--length <length>`: Specifies the length of the board. Default is `20`.
- `--queens <number>`: Specifies the number of queens. Default is `3`.
- `--show-board`: If present, the program will print out all possible board configurations. Otherwise, it will only print the count of solutions.

### Examples

1. **Run with default values**:

```sh
scala main.scala
```

2. **Specify custom board dimensions and number of queens**:

```sh
scala main.scala --height 8 --length 8 --queens 8
```

3. **Display all possible board configurations**:

```sh
scala main.scala --height 8 --length 8 --queens 8 --show-board
```
