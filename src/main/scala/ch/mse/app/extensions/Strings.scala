package ch.mse.app.extensions

extension (s: String) {
    def singleSpace: String =
        s.trim.split("\\s+").mkString(" ")
    def decorated: String = "***" + s + "***"
}

object Test {
    def main(args: Array[String]): Unit = {
        val s = "Three  Two\tOne "
        val t = " Three Two  One"
        println(s.singleSpace == t.singleSpace)
        println("Hello".decorated)
    }
}