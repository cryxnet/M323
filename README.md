# M323
Functional Programming Module @ TBZ

Repo: https://gitlab.com/ch-tbz-it/Stud/m323/m323/-/tree/main?ref_type=heads

## Guide

## Scala Crash Course

### Introduction to Scala

Scala is a high-level, statically-typed programming language that combines functional and object-oriented programming paradigms. It is designed to be concise and powerful, enabling the construction of robust, high-performance applications.

### Getting Started

#### Setting Up Scala

1. **Install Java Development Kit (JDK)**
   - Scala runs on the Java Virtual Machine (JVM), so you'll need the JDK installed.
   - Download and install from [Oracle's official site](https://www.oracle.com/java/technologies/javase-downloads.html) or use a package manager like Homebrew on macOS (`brew install openjdk`).

2. **Install Scala**
   - The easiest way to install Scala is via the Scala Build Tool (SBT).
   - Download and install SBT from [Scala's official site](https://www.scala-lang.org/download/).

3. **Verify Installation**
   - Open a terminal and type `scala -version` to check if Scala is installed correctly.

### Basic Syntax

#### Hello World

```scala
object HelloWorld {
  def main(args: Array[String]): Unit = {
    println("Hello, world!")
  }
}
```

- **object**: Defines a singleton object (a class with a single instance).
- **def**: Defines a method.
- **main**: Entry point of the Scala application.
- **Unit**: Equivalent to `void` in other languages, indicates the method returns no value.

#### Variables and Data Types

Scala has two types of variables:

- **val**: Immutable variable (like `final` in Java).
- **var**: Mutable variable.

```scala
val immutableVariable: Int = 10
var mutableVariable: String = "Hello"
```

#### Data Types

- **Int**: 32-bit integer.
- **Long**: 64-bit integer.
- **Float**: 32-bit floating-point.
- **Double**: 64-bit floating-point.
- **Boolean**: `true` or `false`.
- **Char**: 16-bit Unicode character.
- **String**: A sequence of characters.

### Control Structures

#### If-Else

```scala
val x = 10
val result = if (x > 0) "Positive" else "Negative"
```

#### Match (Pattern Matching)

```scala
val number = 10
val result = number match {
  case 0 => "Zero"
  case 1 => "One"
  case _ => "Other"
}
```

### Functions

#### Defining Functions

```scala
def add(a: Int, b: Int): Int = {
  a + b
}
```

#### Anonymous Functions (Lambdas)

```scala
val add = (a: Int, b: Int) => a + b
```

### Collections

#### Lists

```scala
val list = List(1, 2, 3, 4, 5)
```

#### Arrays

```scala
val array = Array(1, 2, 3, 4, 5)
```

#### Maps

```scala
val map = Map("one" -> 1, "two" -> 2, "three" -> 3)
```

#### Tuples

```scala
val tuple = (1, "one", true)
```

### Object-Oriented Programming

#### Classes

```scala
class Person(val name: String, val age: Int) {
  def greet(): String = s"Hello, my name is $name and I am $age years old."
}

val person = new Person("John", 30)
println(person.greet())
```

#### Traits

Traits are similar to interfaces in Java.

```scala
trait Greetable {
  def greet(): String
}

class Person(val name: String) extends Greetable {
  def greet(): String = s"Hello, my name is $name."
}

val person = new Person("John")
println(person.greet())
```

### Functional Programming

#### Higher-Order Functions

Functions that take other functions as parameters or return functions.

```scala
def applyFunction(f: Int => Int, x: Int): Int = f(x)

val increment = (x: Int) => x + 1
println(applyFunction(increment, 5)) // Output: 6
```

#### Map, Filter, Reduce

```scala
val numbers = List(1, 2, 3, 4, 5)

val doubled = numbers.map(_ * 2)
val even = numbers.filter(_ % 2 == 0)
val sum = numbers.reduce(_ + _)

println(doubled) // Output: List(2, 4, 6, 8, 10)
println(even)    // Output: List(2, 4)
println(sum)     // Output: 15
```

### Concurrency

Scala provides several libraries for concurrency, such as `Future` and `Akka`.

#### Futures

```scala
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

val future = Future {
  Thread.sleep(1000)
  42
}

future.onComplete {
  case Success(value) => println(s"The answer is $value")
  case Failure(e) => e.printStackTrace()
}
```

### Conclusion

This crash course covers the basics of Scala. For a more in-depth study, consider exploring Scala's official documentation, online tutorials, and courses. Scala's rich ecosystem and expressive syntax make it a powerful tool for both object-oriented and functional programming.