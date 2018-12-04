package quickLearnScala.chap_11_functional_programming

import java.io.File

import scala.collection.mutable.Map
import scala.io.Source

/**
  * Created by yinxing on 2018/12/4.
  */
class WordCountExample {

  // 通过一个单词统计的实例来加深对前面知识的消化理解

  /**
    * 任务：按照函数式编程的风格，编写一个程序，对某个目录下所有文件中的单词进行词频统计
    * 做法：请进入Linux系统，打开“终端”，进入Shell命令提示符状态，然后，在“/usr/local/scala/mycode”目录下，新建一个wordcount子目录，
    * 并在“/usr/local/scala/mycode/wordcount”目录下新建两个包含了一些语句的文本文件word1.txt和word2.txt（你可以在文本文件中随意输入一些单词，用空格隔开），
    * 我们会编写Scala程序对该目录下的这两个文件进行单词词频统计。
    * 请在“/usr/local/scala/mycode”目录下新建一个test.scala文件，下面是test.scala中包含的进行词频统计的Scala程序代码：
    */
  object WordCount {
    def main(args: Array[String]): Unit = {
      val dirfile = new File("/usr/local/Cellar/scala/mycode/wordcount")
      val files = dirfile.listFiles
      for (file <- files) println(file)

      // Array类的toList方法将连续存放的数组转换为递归存放的列表，上面的val listFiles=files.toList中，files是数组，files.toList得到一个列表。
      val listFiles = files.toList
      val wordsMap = Map[String, Int]()

      // 下面语句会对列表listFiles中的每个元素进行遍历，取出每个元素（就是文件名/usr/local/scala/mycode/wordcount/word2.txt
      // 和 /usr/local/scala/mycode/wordcount/word1.txt），对每个元素按照括号中定义的逻辑进行处理。
      listFiles.foreach(file => Source.fromFile(file).getLines().foreach(
        // 上面语句是一个Lamda表达式，也就是一个匿名函数，这个匿名函数的功能是，把file变量和列表listFiles的元素进行绑定，
        // 每次遍历获取到列表listFiles中一个元素的值时，就把该元素的值赋值给file，比如第一次遍历获取到的值是“/usr/local/scala/mycode/wordcount/word1.txt”，
        // 就把这个值赋值给file变量。然后，把file作为输入参数，传递给Lamda表达式=>右边的函数体去处理，
        // 也就是，把file变量的值传递给Source.fromFile(file).getLines().foreach(…)去执行。
        // Source.fromFile(file).getLines().foreach(…)会读取file文件（比如/usr/local/scala/mycode/wordcount/word1.txt），
        // 并调用getLines()方法获取该文件的所有行，并针对每行执行foreach()方法进行遍历，然后针对遍历到的当前一行，执行下面的处理逻辑：
        line => line.split(" ").
        // 也是个Lamda表达式，是个匿名函数，这个匿名函数的功能是，把line变量和Source.fromFile(file).getLines()得到的所有行的集合进行绑定，
          // 每次遍历获取到该集合中一个元素的值（也就是一行的内容）时，就把该元素的值（也就是一行的内容）赋值给line，然后，
          // 把line作为输入参数，传递给Lamda表达式=>右边的函数体去处理，也就是提交给line.split(” “).foreach(…)处理。
          // line.split(” “).foreach(…)会对得到的一行内容进行单词切分，也就使用使用split()方法把一行语句切分成一个个单词，
          // 这些单词又构成一个集合，然后对这个集合中的每个元素（也就是每个单词），又通过foreach()方法进行遍历，对于遍历到的每个单词，
          // 都调用foreach()方法的圆括号中定义好的处理逻辑，该处理逻辑如下：
        foreach(
          word=>{
            if (wordsMap.contains(word)) {
              wordsMap(word)+=1
            }else {
              wordsMap+=(word->1)
            }
          }
          // 上面的wordsMap是一个映射（Map）数据结构，每个映射中的条目都是一个<key,value>键值对，key是单词，value是单词出现的次数。
          // 上面这个处理逻辑的功能是，对于当前遍历到的某个单词，如果这个单词以前已经统计过，就把映射中以该单词为key的映射条目的value增加1。
          // 如果以前没有被统计过，则为这个单词新创建一个映射条目。
        )
      ))
      // WordCount统计程序的最后两行代码，会把词频统计结果打印出来：
      println(wordsMap)
      for ((key, value) <- wordsMap) println(key + ": " + value)
    }
  }


}
