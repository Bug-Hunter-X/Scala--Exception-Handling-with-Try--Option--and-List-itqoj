```scala
import scala.util.Try

class MyClass(val value: Int) {
  def getValue: Int = value
}

object Main {
  def main(args: Array[String]): Unit = {
    val values = List(1, 2, 3, 0, 4, 5)
    val myClasses = values.map(new MyClass(_))
    //Incorrectly using map on the Option resulting in a None
    val results: List[Option[Int]] = myClasses.map(obj => Try(10/obj.getValue).toOption)
    println(results)
    val result2:Option[List[Int]] = Try(results.map(_.get)).toOption //This will throw an exception if a division by zero occurs, because a None value is present. 
    println(result2)
  }
}
```