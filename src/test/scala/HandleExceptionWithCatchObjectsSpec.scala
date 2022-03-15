import org.scalatest.flatspec.AnyFlatSpec

import scala.util.{Failure, Success}

class HandleExceptionWithCatchObjectsSpec extends AnyFlatSpec {

  behavior of "sumUsingAllCatchObject"

  it should "return the correct sum" in {
    val result = HandleExceptionWithCatchObjects.sumUsingAllCatchObject(5, 9)
    result match {
      case Failure(_) => fail("It should succeed!")
      case Success(sum) => assert(sum == 14)
    }
  }

  it should "handle NegativeNumberException" in {
    import CalculatorExceptions._
    val result = HandleExceptionWithCatchObjects.sumUsingAllCatchObject(-4, -6)
    result match {
      case Failure(e) => assert(e.isInstanceOf[NegativeNumberException])
      case Success(_) => fail("It should fail!")
    }
  }

  it should "handle IntOverflowException" in {
    import CalculatorExceptions._
    val result = HandleExceptionWithCatchObjects.sumUsingAllCatchObject(Int.MaxValue, 5)
    result match {
      case Failure(e) => assert(e.isInstanceOf[IntOverflowException])
      case Success(_) => fail("Should fail!")
    }
  }

  behavior of "customCatchObjects"

  it should "handle NegativeNumberException" in {
    import CalculatorExceptions._
    val result = HandleExceptionWithCatchObjects.sumUsingCustomCatchObject(-1, -2)
    result match {
      case Failure(e) => assert(e.isInstanceOf[NegativeNumberException])
      case Success(_) => fail("It should fail!")
    }
  }

  it should "not handle IntOverflowException" in {
    import CalculatorExceptions._
    assertThrows[IntOverflowException] {
      HandleExceptionWithCatchObjects.sumUsingCustomCatchObject(Int.MaxValue, 1)
    }
  }

  it should "return the correct sum" in {
    val result = HandleExceptionWithCatchObjects.sumUsingCustomCatchObject(9, 2)
    result match {
      case Failure(_) => fail("It should succeed!")
      case Success(result) => assert(result == 11)
    }
  }

  behavior of "sumAndIgnoreException"

  it should "ignore specified exceptions" in {
    HandleExceptionWithCatchObjects.sumAndIgnoreException(-4, -2)
  }

}
