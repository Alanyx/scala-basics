package quickLearnScala.chap5_data_structure

import scala.collection.mutable.Set

/**
  * Created by yinxing on 2018/11/30.
  */

// 集(set)
class SetExample {

  // ”集”中的元素并不会记录元素的插入顺序，而是以“哈希”方法对元素的值进行组织，所以，它允许你快速地找到某个元素
  // 集包括可变集和不可变集，缺省情况下创建的是不可变集，通常我们使用不可变集。
  // 下面我们用默认方式创建一个不可变集
  var mySet = Set("scala", "spark")
  mySet += "hadoop"
  println(mySet.contains("scala"))

  // 如果要声明一个可变集，则需要引入scala.collection.mutable.Set包,注意此处为val
  val myMutableSet = Set("database", "bigdata")
  myMutableSet += "cloud"
  println(myMutableSet)

  /**
    * 注意：虽然可变集和不可变集都有添加或删除元素的操作，但是，二者有很大的区别。
    * 对不可变集进行操作，会产生一个新的集，原来的集并不会发生变化。 而对可变集进行操作，改变的是该集本身，
    */

}
