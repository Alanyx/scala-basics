package quickLearnScala.chap5_data_structure

/**
  * Created by yinxing on 2018/11/30.
  */

// 数组
class ArraryExample {

  /**
    * 数组是编程中经常用到的数据结构，一般包括定长数组和变长数组(本节只介绍定长数组)
    * 需要注意的是，在Scala中，对数组元素的应用，是使用圆括号，而不是方括号，也就是使用intValueArr(0)，而不是intValueArr[0]，这个和Java是不同的。
    */
  //声明一个长度为3的整型数组，每个数组元素初始化为0
  val intValueArr = new Array[Int](3)
  //给第1个数组元素赋值为10
  intValueArr(0) = 10
  //给第2个数组元素赋值为11
  intValueArr(1) = 11
  //给第3个数组元素赋值为12
  intValueArr(2) = 12

  val strValueArr = new Array[String](3)
  strValueArr(0) = "hadoop"
  strValueArr(1) = "scala"
  strValueArr(2) = "spark"
  for (i <- 0 to 2) println(strValueArr(i))

  // 实际上，Scala提供了更加简洁的数组声明和初始化方法，如下：
  // 都不需要给出数组类型，Scala会自动根据提供的初始化数据来推断出数组的类型
  val intValueArr2 = Array(10, 11, 12)
  val strValueArr2 = Array("a", "b", "c")


}
