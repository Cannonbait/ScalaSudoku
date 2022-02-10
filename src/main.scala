case class Cell(number: Option[Int])
case class Row(cells: List[Cell])
case class Sudoku(rows: List[Row])

def allBlankSudoku() : Sudoku = {
  Sudoku(List.fill(9)(Row(List.fill(9)(Cell(None)))))
}

def isSudoku(candidate: Sudoku) : Boolean = {
  false
}