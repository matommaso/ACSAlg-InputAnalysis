package it.maior.acs.alg.parameter
import java.io.{File, PrintWriter}

import scala.io.Source

object ParameterFormatter {

  val inputPath = "input/E-Piloti-Maggio.alg"
  val outputPath = "output/ACSAlg-formatted.txt"

  def main(args: Array[String]): Unit = {

    val pw = new PrintWriter(new File(outputPath ))
    var countIdentation =0

    for (line <- Source.fromFile(inputPath).getLines) {

      if(line.contains("{")) {countIdentation+=1}
      else if (line.contains("}")){countIdentation-=1}

      var countIdentationPrintable =countIdentation
      if(line.contains("{")) {countIdentationPrintable-=1}

      var printableOutput:String = ""
      for(i <- 0 to countIdentationPrintable-1)
      {
        printableOutput += "\t"
      }

      printableOutput+= line
      pw.write(printableOutput +"\n")
      println(printableOutput)
    }
    pw.close
  }
}
