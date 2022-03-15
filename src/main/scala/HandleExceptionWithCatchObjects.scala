import CalculatorExceptions.{IntOverflowException, NegativeNumberException}

import scala.util.Try
import scala.util.control.Exception.{allCatch, catching, ignoring}

// Handle exceptions using catch objects
object HandleExceptionWithCatchObjects {

  def sumUsingAllCatchObject(a: Int, b: Int): Try[Int] = allCatch.withTry {
    // allCatch.withTry allows to catch all type of exceptions and handle them with a Try
    Calculator.sum(a, b)
  }

  // custom catch object that will catch only NegativeNumberException
  val myCustomCatcher = catching(classOf[NegativeNumberException])

  def sumUsingCustomCatchObject(a: Int, b: Int): Try[Int] = myCustomCatcher.withTry {
    Calculator.sum(a, b)
  }

  def sumAndIgnoreException(a: Int, b: Int) =
    ignoring(classOf[NegativeNumberException], classOf[IntOverflowException]) {
      // ignoring() catch object catches and ignore the specified exceptions
      println(s"The sum of $a and $b is ${Calculator.sum(a, b)}")
    }
}
