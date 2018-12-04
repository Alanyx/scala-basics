package quickLearnScala.chap_11_functional_programming

/**
  * Created by yinxing on 2018/12/4.
  */
class MapOperation {

  /**
    * map操作
    * map操作是针对集合的典型变换操作，它将某个函数应用到集合中的每个元素，并产生一个结果集合。
    */
  // 比如，给定一个字符串列表，我们可以通过map操作对列表的中每个字符串进行变换，让每个字符串都变成大写字母，这样变换后就可以得到一个新的集合
  scala> val books = List("Hadoop", "Hive", "HDFS")
  books: List[String] = List(Hadoop, Hive, HDFS)
  scala> books.map(s => s.toUpperCase)
  res0: List[String] = List(HADOOP, HIVE, HDFS)


  // s => s.toUpperCase 这种表达式被称为“Lamda表达式”，在Java8以后有引入这种新的特性，Scala也拥有该特性
  /**
    * “Lambda表达式”的形式如下：
    * (参数) => 表达式 //如果参数只有一个，参数的圆括号可以省略
    *
    * Lambda表达式实际上是一种匿名函数，大大简化代码编写工作。s => s.toUpperCase，它的含义是，对于输入s，都都执行s.toUpperCase操作。
    */


  /**
    * flatMap操作
    * flatMap是map的一种扩展。在flatMap中，我们会传入一个函数，
    * 该函数对每个输入都会返回一个集合（而不是一个元素），然后，flatMap把生成的多个集合“拍扁”成为一个集合。
    */
  scala> val books = List("Hadoop","Hive","HDFS")
  books: List[String] = List(Hadoop, Hive, HDFS)
  scala> books flatMap (s => s.toList)
  res0: List[Char] = List(H, a, o, o, p, H, i, v, e, H, D, F, S)
  // 上面的flatMap执行时，会把books中的每个元素都调用toList，生成List[Char]，最终，多个Char的集合被“拍扁”成一个集合


  // a 方法 b
  // a.方法(b)
  // 上面二者是等价的。所以：
  books flatMap (s => s.toList)
  books.flatMap(s => s.toList)
  // 这条语句的含义就是：对于列表books中的每个元素，都执行Lambda表达式定义的匿名函数“s => s.toList”，
  // 把一个books元素转换成一个字符集合，比如说，把“Hadoop”这个字符串转换成字符集合List(‘H’,’a’,’d’,’o’,’o’,’p’)，
  // 把“Hive”字符串转换成字符集合List(‘H’,’i’,’v’,’e’)。
  // 最后，flatMap把这些集合中的元素“拍扁”得到一个集合List(‘H’, ‘a’,’d’, ‘o’, ‘o’, ‘p’, ‘H’, ‘i’, ‘v’, ‘e’, ‘H’, ‘D’, ‘F’, ‘S’)。








}
