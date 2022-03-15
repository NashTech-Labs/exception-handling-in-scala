import scala.util.{Failure, Success, Try}

// Handle Exceptions using Try/Success/Failure
object HandleExceptionUsingTrySuccessFailure {

  def sumUsingTry(a: Int, b: Int): Try[Int] = Try{
    Calculator.sum(a, b)
  }

  def getSum(a: Int, b: Int): Int = sumUsingTry(a, b) match {
    case Success(sum) => sum
    case Failure(_) => -1
  }

}
