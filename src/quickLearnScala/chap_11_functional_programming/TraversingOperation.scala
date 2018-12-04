package quickLearnScala.chap_11_functional_programming

/**
  * Created by yinxing on 2018/12/4.
  */
class TraversingOperation {

  /**
    * 列表的遍历
    */
  //方式1:使用for循环进行遍历：
  val list = List(1, 2, 3, 4, 5)
  for (elem <- list) {
    println(elem)
  }

  //方式2:使用foreach进行遍历：
  list.foreach(elem => println(elem))


  /**
    * 映射的遍历
    */
  //创建一个不可变映射：
  val university = Map("XMU" -> "Xiamen University", "THU" -> "Tsinghua University", "PKU" -> "Peking University")

  // 循环遍历映射，是经常需要用到的操作，基本格式是：
  // for ((k,v)<-映射) 语句块
  for ((k, v) <- university) {
    println("key is: %s and value is: %s\n", k, v)
  }

  // 把所有键打印出来：
  for(k<-university.keys) println(k)

  // 把所有值打印出来：
  for(v<-university.values) println(v)

  // 也可以使用foreach来实现对映射的遍历
  scala> university foreach {case(k,v) => println(k+":"+v)} //或者写成：university.foreach({case (k,v) => println(k+":"+v)})
  XMU:Xiamen University
  THU:Tsinghua University
  PKU:Peking University

  scala> university foreach {kv => println(kv._1+":"+kv._2)}
  XMU:Xiamen University
  THU:Tsinghua University
  PKU:Peking University

}
