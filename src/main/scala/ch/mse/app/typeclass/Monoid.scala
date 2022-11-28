package ch.mse.app.typeclass

trait Monoid[A] {
  def op(x: A, y: A): A
  def unit: A
}

object Monoid {

  given stringMonoid: Monoid[String] with {
    def op(x: String, y: String) = x + y
    def unit = ""
  }

  given multMonoid: Monoid[Int] with {
    def op(x: Int, y: Int) = x * y
    def unit = 1
  }

  given addMonoid: Monoid[Int] with {
    def op(x: Int, y: Int) = x + y
    def unit = 0
  }

  given listMonoid[A](using m: Monoid[A]): Monoid[List[A]] with {
      def op(xs: List[A], ys: List[A]): List[A] =
        if (xs.isEmpty) ys
        else if (ys.isEmpty) xs
        else m.op(xs.head, ys.head) :: op(xs.tail, ys.tail)
      def unit = List()
    }

  def acc[A](list: List[A])(using m: Monoid[A]): A =
    list.foldLeft(m.unit)(m.op)

  def acc2[A: Monoid](list: List[A]): A = {
    val m = summon[Monoid[A]]
    list.foldLeft(m.unit)(m.op)
  }

}