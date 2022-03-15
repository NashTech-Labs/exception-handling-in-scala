import CalculatorExceptions.{IntOverflowException, NegativeNumberException}

// Handle Exceptions using try/catch/finally construct
object HandleExceptionUsingtrycatch {

  def tryCatchSum(a: Int, b: Int): Int = {
    try {
      Calculator.sum(a, b)
    } catch {
      case _: IntOverflowException => -1
      case _: NegativeNumberException => -2
    } finally {
      // this block will always be invoked
      println("Calculation done!")
    }
  }

}
