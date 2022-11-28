package ch.mse.app.typeclass

trait Showable[T] { def show(x: T): String }

object Showable {
  given Showable[A] with {
    def show(x: A) = "TC:A"
  }
  given Showable[B1] with {
    def show(x: B1) = "TC:B1"
  }
  given Showable[B2] with {
    def show(x: B2) = "TC:B2"
  }
}

class A
class B1 extends A
class B2 extends A

object ShowableTest {

  def show[T: Showable](x: T) = {
    summon[Showable[T]].show(x)
  }

  def main(args: Array[String]): Unit = {
    val list = List(new A, new B1, new B2)
    val list2 = list.map(x => show(x))
    println(list2)
  }
}
