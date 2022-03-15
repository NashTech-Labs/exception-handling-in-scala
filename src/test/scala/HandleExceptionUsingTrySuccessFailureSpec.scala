import org.scalatest.flatspec.AnyFlatSpec

import scala.util.{Failure, Success}

class HandleExceptionUsingTrySuccessFailureSpec extends AnyFlatSpec {

  behavior of "sumUsingTry"

  it should "return the correct sum" in {
    val result = HandleExceptionUsingTrySuccessFailure.sumUsingTry(5, 9)
    result match {
      case Failure(_) => fail("It should succeed!")
      case Success(sum) => assert(sum == 14)
    }
  }

  it should "handle NegativeNumberException" in {
    import CalculatorExceptions._
    val result = HandleExceptionUsingTrySuccessFailure.sumUsingTry(-4, -6)
    result match {
      case Failure(e) => assert(e.isInstanceOf[NegativeNumberException])
      case Success(_) => fail("It should fail!")
    }
  }

  it should "handle IntOverflowException" in {
    import CalculatorExceptions._
    val result = HandleExceptionUsingTrySuccessFailure.sumUsingTry(Int.MaxValue, 5)
    result match {
      case Failure(e) => assert(e.isInstanceOf[IntOverflowException])
      case Success(_) => fail("Should fail!")
    }
  }

  behavior of "getSum"

  it should "return the correct sum" in {
    val result = HandleExceptionUsingTrySuccessFailure.getSum(5, 9)
    assert(result == 14)
  }

  it should "handle a failure" in {
    val result = HandleExceptionUsingTrySuccessFailure.getSum(-2, -8)
    assert(result == -1)
  }

}
