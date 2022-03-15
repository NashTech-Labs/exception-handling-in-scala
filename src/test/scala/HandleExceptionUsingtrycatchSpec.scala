import org.scalatest.flatspec.AnyFlatSpec

class HandleExceptionUsingtrycatchSpec extends AnyFlatSpec {

  behavior of "tryCatchSum"

  it should "return the correct sum" in {
    val result = HandleExceptionUsingtrycatch.tryCatchSum(5, 9)
    assert(result == 14)
  }

  it should "handle IntOverflowException" in {
    val result = HandleExceptionUsingtrycatch.tryCatchSum(Int.MaxValue, 5)
    assert(result == -1)
  }

  it should "handle NegativeNumberException" in {
    val result = HandleExceptionUsingtrycatch.tryCatchSum(-4, -6)
    assert(result == -2)
  }

}
