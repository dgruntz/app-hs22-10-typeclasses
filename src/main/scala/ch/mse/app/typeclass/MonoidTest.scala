package ch.mse.app.typeclass

object MonoidTest {

  import Monoid.acc
  import Monoid.addMonoid

  def main(args: Array[String]): Unit = {
    println(acc(List(1, 2, 3)))
    println(acc(List("Hello", "World")))
    println(acc(List(List(1), List(1, 2), List(1, 2, 3))))
    println(acc(List(List(1), List(1, 2), List(1, 2, 3)))(using Monoid.listMonoid(using Monoid.multMonoid)))
  }

}