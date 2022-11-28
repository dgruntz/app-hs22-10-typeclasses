package ch.mse.app.conversions

class Fraction(n: BigInt, d: BigInt) {
  assert(d != 0)
  private val g = n.gcd(d)
  val numer = n / (g * d.signum)
  val denom = d / (g * d.signum)
  def *(other: Fraction) = new Fraction(numer * other.numer, denom * other.denom)
  def /(other: Fraction) = new Fraction(numer * other.denom, denom * other.numer)
  override def toString = numer.toString + " / " + denom;
}

object Fraction {
  def apply(n: BigInt, d: BigInt) = new Fraction(n, d)
  given Conversion[Int, Fraction] with {
    override def apply(n: Int): Fraction = new Fraction(n, 1)
  }
  // given Conversion[Int, Fraction] = n => Fraction(n,1)

  // demo only, not a useful conversion
  // given Conversion[Fraction, Int] = f => f.numer.toInt
}


