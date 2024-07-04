import scala.concurrent.{Future, Await}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

object QueensProblem {
  type Position = (Int, Int)

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
   * Place queens on the board using recursion and backtracking with parallel processing.
   * @param n The number of queens to place.
   * @param height The height of the board.
   * @return A list of all possible solutions, where each solution is a list of queen positions.
   */
  def placeQueens(n: Int, height: Int): List[List[Position]] = {
    def placeQueensRec(k: Int): Future[List[List[Position]]] = {
      if (k == 0) Future.successful(List(List.empty))
      else {
        val futureSolutions = placeQueensRec(k - 1).flatMap { queensList =>
          val futures = for {
            queens <- queensList
            row <- 0 until height
            newQueen = (k - 1, row)
            if isSafe(queens, newQueen)
          } yield Future.successful(newQueen :: queens)

          Future.sequence(futures)
        }
        futureSolutions
      }
    }

    Await.result(placeQueensRec(n), Duration.Inf)
  }

  /**
   * Display the board with queens placed.
   * @param queens The list of queen positions.
   * @param height The height of the board.
   * @param length The length of the board.
   */
  def showBoard(queens: List[Position], height: Int, length: Int): Unit = {
    val board = Array.fill(height, length)(".")
    queens.foreach { case (x, y) => board(x)(y) = "Q" }
    board.foreach(row => println(row.mkString(" ")))
    println()
  }
}

// Main method to execute the program
/* 
* Main method to execute the program
* @args --show-board to print out all possibilities 
*/
object Main {
  def main(args: Array[String]): Unit = {
    val showBoard = args.contains("--show-board")
    
    val boardHeight = args.indexOf("--height") match {
      case i if i >= 0 && i + 1 < args.length => args(i + 1).toInt
      case _ => 12
    }

    val boardLength = args.indexOf("--length") match {
      case i if i >= 0 && i + 1 < args.length => args(i + 1).toInt
      case _ => 12
    }

    val queenNumber = args.indexOf("--queens") match {
      case i if i >= 0 && i + 1 < args.length => args(i + 1).toInt
      case _ => 4
    }
    val solutions = QueensProblem.placeQueens(queenNumber, boardHeight)
    println(s"Found ${solutions.length} solutions.")
    if (showBoard) {
      solutions.foreach(QueensProblem.showBoard(_, boardHeight, boardLength))
    }
  }

  /**
   * Helper method to get the value of a command line argument.
   * @param args The array of arguments.
   * @param argName The name of the argument to find.
   * @return An Option containing the value of the argument if found, or None.
   */
  def getArgumentValue(args: Array[String], argName: String): Option[String] = {
    val index = args.indexOf(argName)
    if (index >= 0 && index + 1 < args.length) Some(args(index + 1)) else None
  }
}
