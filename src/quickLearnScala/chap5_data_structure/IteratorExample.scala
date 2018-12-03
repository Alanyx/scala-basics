package quickLearnScala.chap5_data_structure

/**
  * Created by yinxing on 2018/11/30.
  */

// 迭代器(Iterator)
class IteratorExample {

  /**
    * 在Scala中，迭代器（Iterator）不是一个集合，但是，提供了访问集合的一种方法。
    * 当构建一个集合需要很大的开销时（比如把一个文件的所有行都读取内存），迭代器就可以发挥很好的作用。
    * 迭代器包含两个基本操作：next和hasNext。next可以返回迭代器的下一个元素，hasNext用于检测是否还有下一个元素。
    *
    * 通常可以通过while循环或者for循环实现对迭代器的遍历。
    */
  // 注意，操作执行结束后，迭代器会移动到末尾，就不能再使用了，如果继续执行一次println(iter.next)就会报错。
  // 另外，上面代码中，使用iter.next和iter.next()都是可以的，但是，hasNext后面不能加括号。
  val iter = Iterator("scala", "spark", "hadoop")
  while (iter.hasNext) {
    println(iter.next())
  }

  // for循环方式
  val iter2 = Iterator("scala", "spark", "hadoop")
  for (element <- iter2){
    println(element)
  }



}
