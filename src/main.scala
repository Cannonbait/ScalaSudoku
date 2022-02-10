import scala.io.Source

case class Cell(value: Option[Int])
case class Row(cells: List[Cell])
case class Sudoku(rows: List[Row])

def allBlankSudoku() : Sudoku =
  Sudoku(List.fill(9)(Row(List.fill(9)(Cell(None)))))

def isSudoku(candidate: Sudoku) : Boolean =
  candidate.rows.forall(row => row.cells.forall(cell => cell.value.isEmpty || (1 <= cell.value.get && cell.value.get <= 9)))

def isFilled(sudoku: Sudoku) : Boolean =
  sudoku.rows.forall(row => row.cells.forall(cell => cell.value.nonEmpty))

def printSudoku(sudoku: Sudoku) : Unit =
  sudoku.rows.foreach( row => println(row.cells.map(_.value.getOrElse(".")).mkString))

def readSudokuFromFile(path: String) : Sudoku =
  val lines = Source.fromFile(path).getLines.toList
  Sudoku(lines.map(line => Row(line.map(char => if (char == '.') Cell(None) else Cell(Option(char.asDigit))).toList)))


@main def main() =
//  val sudoku =
  val path = "src/resources/exampleSudoku"
  printSudoku(readSudokuFromFile(path))
//  println(isSudoku(blankSudoku))
//  println(isFilled(blankSudoku))


