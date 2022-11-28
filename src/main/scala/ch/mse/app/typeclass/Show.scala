package ch.mse.app.typeclass

trait Show { def show: String }

object ShowTest {

  class A extends Show { override def show = "A" }
  class B1 extends A { override def show = "B1" }
  class B2 extends A { override def show = "B2" }

  def main(args: Array[String]): Unit = {
    val list = List(new A, new B1, new B2)
    val list2 = list.map(x => x.show)
    println(list2)
  }

}