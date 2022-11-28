package ch.mse.app.conversions

import scala.language.implicitConversions

object FractionTest {
	import Fraction.*
	
	def main(args: Array[String]):Unit = {
	  val f1 = Fraction(2,3)
	  val f2 = Fraction(-3,2)  
	  println(f1 * 3)
	  println(3 * f2)
	}
}
