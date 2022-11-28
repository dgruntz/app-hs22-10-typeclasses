package ch.mse.app.types.path

trait DocumentAttribute
object Title extends DocumentAttribute

class Document { 
  var title: String = ""
  private var useNextArgAs: DocumentAttribute = null
  def set(obj: DocumentAttribute) = { useNextArgAs = obj; this }
  def to(arg: String) = useNextArgAs match {
    case Title => title = arg;
    case _ => throw new IllegalStateException
  } 
  //…
}

object DocumentTest {
  def main(args: Array[String]): Unit = {
    val book = new Document
    book.set(Title).to("Scala")

    book set Title to "Scala"

    println(book.title)
  }
}


