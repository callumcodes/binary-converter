object Main {
  def main(args: Array[String]) {
    if(args.length > 0) {
      args(0).matches("^[01]+$") match {
        case false => println("Binary only please")
        case _ =>
          println("Processing: " + args(0))
          println(splitBinary(args(0)).map(binaryToChar).mkString)
      }
    } else {
      println("Specify binary argument")
    }

  }

  def splitBinary(input: String):  List[String] = {
    def go(characters: List[String] = Nil, buffer: String): List[String]  = {
      buffer match {
        case "" => characters.reverse
        case _ => go(buffer.take(8) :: characters, buffer.takeRight(buffer.length - 8))
      }
    }

    go(Nil, input)
  }

  def binaryToChar(input: String): Char = {
    Integer.parseInt(input, 2).asInstanceOf[Char]
  }
}
