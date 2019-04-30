package quickLearnScala.chap3_basic

/**
  * Created by yinxing on 2018/11/29.
  */
// 02基本数据类型和操作
class BasicDataTypesAndOperations {

  /**
    * 基本数据类型
    */
  // Int: 123就是整数字面量
  val a = 123
  // Float: 浮点数字面量
  val b = 3.14
  // Boolean:布尔型字面量
  val c = true
  // Char:字符字面量
  val d = "A"
  // String:字符串字面量
  val e = "hello"

  // 产生字符串"5"
  5.toString()
  // 输出两个字符串公共部分:输出"bc"
  "abc".intersect("bcd")


  /**
    * 操作符
    */
  /// 在Scala中，可以使用加(+)、减(-) 、乘(*) 、除(/) 、余数（%）等操作符，而且，这些操作符就是方法。例如，5 + 3和(5).+(3)是等价的，也就是说：
  ///  a 方法 b   等价于 a.方法(b)
  //实际上调用了 (5).+(3)
  val sum1 = 5 + 3
  val sum2 = (5).+(3)

  /// 和Java不同，在Scala中并没有提供++和–-操作符，当需要递增和递减时，可以采用如下方式表达：
  var k = 5
  k += 1
  print(k)

  /// 也可以使用关系和逻辑操作，比如，大于(>)、小于(<)、大于等于(>=)和小于等于(<=)，会产生Boolean类型的结果

}
