package quickLearnScala.chap3_basic

/**
  * Created by yinxing on 2018/11/29.
  */

// 05读写文件
class ReadAndWriteFiles {

  /**
    * 写入文本文件
    */
  scala> import java.io.PrintWriter
  import java.io.PrintWriter //这行是Scala解释器执行上面语句后返回的结果
  scala> val out = new PrintWriter("output.txt")
  out: java.io.PrintWriter = java.io.PrintWriter@25641d39  //这行是Scala解释器执行上面语句后返回的结果
  scala> for (i <- 1 to 5) out.println(i)
  scala> out.close()

  /**
    * 读取文本文件中的行
    */
  scala> import scala.io.Source
  import scala.io.Source //这行是Scala解释器执行上面语句后返回的结果
  scala> val inputFile = Source.fromFile("output.txt")
  inputFile: scala.io.BufferedSource = non-empty iterator  //这行是Scala解释器执行上面语句后返回的结果
    scala> val lines = inputFile.getLines //返回的结果是一个迭代器
  lines: Iterator[String] = non-empty iterator  //这行是Scala解释器执行上面语句后返回的结果
    scala> for (line <- lines) println(line)
  1
  2
  3
  4
  5


}
