package quickLearnScala.chap3_basic

/**
  * Created by yinxing on 2018/11/29.
  */

// 03Range
class Range {

  /// 在创建Range时，需要给出区间的起点和终点以及步长（默认步长为1）。下面通过几个实例来介绍：
  //（1）创建一个从1到5的数值序列，包含区间终点5，步长为1
  scala> 1 to 5
  res0: scala.collection.immutable.Range.Inclusive = Range(1, 2, 3, 4, 5)

  scala> 1.to(5)
  res0: scala.collection.immutable.Range.Inclusive = Range(1, 2, 3, 4, 5)

  //（2）创建一个从1到5的数值序列，不包含区间终点5，步长为1
  scala> 1 until 5
  res1: scala.collection.immutable.Range = Range(1, 2, 3, 4)

  // （3）创建一个从1到10的数值序列，包含区间终点10，步长为2
  scala> 1 to 10 by 2
  res2: scala.collection.immutable.Range = Range(1, 3, 5, 7, 9)

  // (4）创建一个Float类型的数值序列，从0.5f到5.9f，步长为0.3f
  scala> 0.5f to 5.9f by 0.8f
  res3: scala.collection.immutable.NumericRange[Float] = NumericRange(0.5, 1.3, 2.1, 2.8999999, 3.6999998, 4.5, 5.3)

}
