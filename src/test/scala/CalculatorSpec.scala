import org.scalatest.flatspec.AnyFlatSpec

class CalculatorSpec extends AnyFlatSpec {

  behavior of "sum"

  it should "return the correct sum" in {
    val result = Calculator.sum(15, 9)
    assert(result == 24)
  }

  it should "throw NegativeNumberException if one of the addends is negative" in {
    import CalculatorExceptions._
    assertThrows[NegativeNumberException] {
      Calculator.sum(-4, 6)
    }
  }

  it should "throw IntOverflowException if the sum overflows the Int range" in {
    import CalculatorExceptions._
    assertThrows[IntOverflowException] {
      Calculator.sum(5, Int.MaxValue)
    }
  }

}
