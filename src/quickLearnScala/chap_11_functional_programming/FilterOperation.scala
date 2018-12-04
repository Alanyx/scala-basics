package quickLearnScala.chap_11_functional_programming

/**
  * Created by yinxing on 2018/12/4.
  */
class FilterOperation {

  // 在实际编程中，我们经常会用到一种操作，遍历一个集合并从中获取满足指定条件的元素组成一个新的集合。Scala中可以通过filter操作来实现。
  // 先创建一个映射
  val university = Map("XMU" -> "Xiamen University", "THU" -> "Tsinghua University","PKU"->"Peking University","XMUT"->"Xiamen University of Technology")
  // 采用filter操作过滤得到那些学校名称中包含“Xiamen”的元素：
  val universityOfXiamen= university filter(kv=>kv._2 contains "Xiamen")

  // 根据前面我们已经学习过的遍历映射的语句，我们可以把universityOfXiamen中的元素进行遍历全部打印出来：
  universityOfXiamen foreach {kv=>println(kv._1+":"+kv._2)}

  //  得到以下结果：
  //  XMU:Xiamen University
  //  XMUT:Xiamen University of Technology


  // 可以采用filter操作过滤得到那些学校名称中以字母“P”开头的元素：
  val universityOfP = university filter {kv =>kv._2 startsWith "P"}





}
