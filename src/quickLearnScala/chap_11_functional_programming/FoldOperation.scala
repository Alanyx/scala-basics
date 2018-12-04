package quickLearnScala.chap_11_functional_programming

/**
  * Created by yinxing on 2018/12/4.
  */
class FoldOperation {

  // 折叠(fold)操作和reduce（归约）操作比较类似。fold操作需要从一个初始的“种子”值开始，并以该值作为上下文，处理集合中的每个元素。
  scala> val list = List(1,2,3,4,5)
  list: List[Int] = List(1, 2, 3, 4, 5)

  scala> list.fold(10)(_*_)
  res0: Int = 1200

  // fold函数实现了对list中所有元素的累乘操作。fold函数需要两个参数，一个参数是初始种子值，这里是10，
  // 另一个参数是用于计算结果的累计函数，这里是累乘。执行list.fold(10)(*)时，首先把初始值拿去和list中的第一个值1做乘法操作，得到累乘值10，
  // 然后再拿这个累乘值10去和list中的第2个值2做乘法操作，得到累乘值20，依此类推，一直得到最终的累乘结果1200。

  /**
    * fold有两个变体：foldLeft()和foldRight()，其中，foldLeft()，第一个参数为累计值，集合遍历的方向是从左到右。
    * foldRight()，第二个参数为累计值，集合遍历的方向是从右到左。对于fold()自身而言，遍历的顺序是未定义的，不过，一般都是从左到右遍历。
    */

}
