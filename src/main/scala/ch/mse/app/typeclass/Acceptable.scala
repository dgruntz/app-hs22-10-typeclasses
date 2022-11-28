package ch.mse.app.typeclass

trait Acceptable[T]

object Acceptable {
  given Acceptable[Int] with {}
  given Acceptable[Long] with {}
}
