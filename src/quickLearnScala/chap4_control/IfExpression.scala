package quickLearnScala.chap4_control

/**
  * Created by yinxing on 2018/11/30.
  */

// 01if条件表达式
class IfExpression {

  val x = 6
  if(x>0){
    println("positive number!")
  } else if(x==0){
    println("zero!")
  } else {
    println("negative number!")
  }

  /**
    * 有一点与Java不同的是，Scala中的if表达式的值可以赋值给变量，比如：
    */
  val y =6
  val a = if(y>0) 1 else -1

}
