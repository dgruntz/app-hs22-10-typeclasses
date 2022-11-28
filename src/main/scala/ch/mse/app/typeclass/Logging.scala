package ch.mse.app.typeclass

object Logging {
  import java.io.PrintStream

  given out: PrintStream = System.out
  given datePrefix: String = s"${java.time.LocalDate.now}>>"
  // given String = s"${java.time.LocalDate.now}>>"
  // given timePrefix: String = s"${java.time.LocalTime.now}>>"

  def log(msg: String)(using out: PrintStream): Unit = out.println(msg)
  def logTimed(msg: String)(using out: PrintStream): Unit = log("[" + new java.util.Date + "] " + msg)
  def logPrefixed(msg: String)(using out: PrintStream, prefix: String): Unit = log("[" + prefix + "] " + msg)
  def logPrefixed2(msg: String)(using out: PrintStream)(using prefix: String): Unit = logPrefixed(msg)


  def main(args: Array[String]): Unit = {
    log("Implicits")
    log("Error message")(using System.err)
    logTimed("Hello")
    logTimed("Hello")(using System.err)
    logPrefixed("Hello")
    Thread.sleep(1000)
    logPrefixed("Hello")
    logPrefixed("Hello")(using summon[PrintStream], ">>")
    logPrefixed("Hello")(using summon, summon)

    // logPrefixed2("Hello2")
    // //logPrefixed2("Hello")(using ">>") // this does not compile
    // logPrefixed2("Hello")(using summon)(using ">>")
    // logPrefixed2("Hello")(using System.err)
    // logPrefixed2("Hello")(using System.err)(using ">>")
  }
}
