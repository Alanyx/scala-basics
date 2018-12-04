package quickLearnScala.chap_11_functional_programming

/**
  * Created by yinxing on 2018/12/4.
  */
class ReduceOperation {

  // 在Scala中，我们可以使用reduce这种二元操作对集合中的元素进行归约。
  // reduce包含reduceLeft和reduceRight两种操作，前者从集合的头部开始操作，后者从集合的尾部开始操作
  scala> val list = List(1,2,3,4,5)
  list: List[Int] = List(1, 2, 3, 4, 5)
  scala> list.reduceLeft(_ + _)
  res21: Int = 15
  scala> list.reduceRight(_ + _)
  res22: Int = 15

  /**
    * reduceLeft和reduceRight都是针对两两元素进行操作，在上面代码中，reduceLeft(_ + _)表示从列表头部开始，
    * 对两两元素进行求和操作，下划线是占位符，用来表示当前获取的两个元素，两个下划线之间的是操作符，表示对两个元素进行的操作，
    * 这里是加法操作（你也可以使用乘法*或者减法-等其他操作）
    */
  // reduceLeft(_ + _)执行顺序
  //  1+2 = 3
  //  3+3 = 6
  //  6+4 = 10
  //  10+5 = 15

  // 可以直接使用reduce，而不用reduceLeft和reduceRight，这时，默认采用的是reduceLeft，如下：
  scala> val list = List(1,2,3,4,5)
  list: List[Int] = List(1, 2, 3, 4, 5)
  scala> list.reduce(_ - _)
  res29: Int = -13 //可以看出，得到的结果和reduceLeft的结果是一样的


}
