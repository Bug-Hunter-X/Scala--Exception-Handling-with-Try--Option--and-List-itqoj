```scala
import scala.util.Try

class MyClass(val value: Int) {
  def getValue: Int = value
}

object Main {
  def main(args: Array[String]): Unit = {
    val values = List(1, 2, 3, 0, 4, 5)
    val myClasses = values.map(new MyClass(_))
    val results: List[Option[Int]] = myClasses.map(obj => Try(10 / obj.getValue).toOption)
    println(results) //List(Some(10), Some(5), Some(3), None, Some(2), Some(2))
    // Correctly handle None values using flatMap to avoid exceptions
    val result2: Option[List[Int]] = Try(results.flatMap(_.toList)).toOption 
    println(result2) //Some(List(10, 5, 3, 2, 2))
  }
}
```