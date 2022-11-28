package ch.mse.app.typeclass

object AcceptableTest {
  class Animal

  def foo[T : Acceptable](x: T) = println(x)
  
  def main(args: Array[String]): Unit = {
    // given Acceptable[Double] with {}
    foo(1)
    foo(2L)
    // foo(3.3)
    // foo("Hello")
    // foo(new Animal)(using new Acceptable[Animal]{})
  }

}