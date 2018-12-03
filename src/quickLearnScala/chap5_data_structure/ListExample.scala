package quickLearnScala.chap5_data_structure

/**
  * Created by yinxing on 2018/11/30.
  */

// 列表
class ListExample {

  val intList = List(1,2,3)
  // 列表有头部和尾部的概念，可以使用intList.head来获取上面定义的列表的头部，值是1，
  // 使用intList.tail来获取上面定义的列表的尾部，值是List(2,3），可以看出，头部是一个元素，而尾部则仍然是一个列表

  // 可以使用::操作，在列表的头部增加新的元素，得到一个新的列表，如下：
  val intList2 = 0::intList

  // 注意，上面操作执行后，intList不会发生变化，依然是List(1,2,3)，intListOther是一个新的列表List(0,1,2,3)
  // ::操作符是右结合的，因此，如果要构建一个列表List(1,2,3)，实际上也可以采用下面的方式：(Nil表示空列表)
  val intList3 = 1::2::3::Nil

  // 可以使用:::操作符对不同的列表进行连接得到新的列表，比如：注意是3个":"
  val intList4 = List(1,2)
  val intList5 = List(3,4)
  val intList6 = intList4:::intList5

  // Scala还为列表提供了一些常用的方法，比如，如果要实现求和，可以直接调用sum方法，如下：
  intList6.sum




}
