package quickLearnScala.chap5_data_structure

/**
  * Created by yinxing on 2018/11/30.
  */

// 元组(tuple)
class TupleExample {

  // 元组是不同类型的值的聚集。元组和列表不同，列表中各个元素必须是相同类型，而元组可以包含不同类型的元素。
  // 下面我们声明一个名称为tuple的元组
  // 声明一个元组是很简单的，只需要用圆括号把多个元组的元素包围起来就可以了
  val tuple = ("scala", 123, 10.0)
  // 当需要访问元组中的某个元素的值时，可以通过类似tuple._1、tuple._2、tuple._3这种方式就可以实现
  println(tuple._1)
  println(tuple._2)
  println(tuple._3)

}
