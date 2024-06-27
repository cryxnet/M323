/**
 * Scala application to solve the N-Queens problem using recursion and backtracking.
 * The application will also use functional programming principles such as immutability, pure functions,
 * and higher-order functions.
 */

// Define type alias for position
type Position = (Int, Int)

// Define board dimensions and number of queens
val BOARD_HEIGHT = 8
val BOARD_LENGTH = 8
val QUEEN_NUMBER = 8

object QueensProblem {

  /**
   * Check if two queens threaten each other.
   * @param p1 The first queen's position.
   * @param p2 The second queen's position.
   * @return True if the queens threaten each other, otherwise false.
   */
  def threatens(p1: Position, p2: Position): Boolean = {
    val (x1, y1) = p1
    val (x2, y2) = p2
    x1 == x2 || y1 == y2 || (x1 - x2).abs == (y1 - y2).abs
  }

  /**
   * Check if a queen can be safely placed at the given position.
   * @param queens The list of positions of already placed queens.
   * @param position The new queen's position.
   * @return True if the position is safe, otherwise false.
   */
  def isSafe(queens: List[Position], position: Position): Boolean =
    queens.forall(!threatens(_, position))

  /**
   * Place queens on the board using recursion and backtracking.
   * @param n The number of queens to place.
   * @return A list of all possible solutions, where each solution is a list of queen positions.
   */
  def placeQueens(n: Int): List[List[Position]] = {
    def placeQueensRec(k: Int): List[List[Position]] = {
      if (k == 0) List(List.empty)
      else {
        for {
          queens <- placeQueensRec(k - 1)
          row <- 0 until BOARD_HEIGHT
          newQueen = (k - 1, row)
          if isSafe(queens, newQueen)
        } yield newQueen :: queens
      }
    }
    placeQueensRec(n)
  }

  /**
   * Display the board with queens placed.
   * @param queens The list of queen positions.
   * @param n The dimensions of the board (n x n).
   */
  def showBoard(queens: List[Position], n: Int): Unit = {
    val board = Array.fill(n, n)(".")
    queens.foreach { case (x, y) => board(x)(y) = "Q" }
    board.foreach(row => println(row.mkString(" ")))
    println()
  }
}

// Main method to execute the program
object Main {
  def main(args: Array[String]): Unit = {
    val solutions = QueensProblem.placeQueens(QUEEN_NUMBER)
    println(s"Found ${solutions.length} solutions.")
    solutions.foreach(QueensProblem.showBoard(_, BOARD_HEIGHT))
  }
}
