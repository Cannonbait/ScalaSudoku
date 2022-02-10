import org.scalacheck.Gen.{frequency, oneOf}
import org.scalacheck.{Arbitrary, Gen, Properties}
import org.scalacheck.Prop.forAll
import sudoku.{Cell, Row, Sudoku, printSudoku, isSudoku}


object SudokuSpecification extends Properties("sudoku") {
  val cellGen = for {
    value <- Gen.oneOf[Option[Int]](Some(1), Some(2), Some(3), Some(4), Some(5), Some(6), Some(7), Some(8), Some(9), None)
  } yield Cell(value)

  val rowGen = for {
    cells <- Gen.listOfN(9, cellGen)
  } yield Row(cells)

  val sudokuGen: Gen[Sudoku] = for {
    rows <- Gen.listOfN(9, rowGen)
  } yield Sudoku(rows)

  implicit val arbSudoku: Arbitrary[Sudoku] = Arbitrary(sudokuGen)

  property("test") = forAll { (a: Sudoku) =>
    isSudoku(a)
  }
}
