package quickLearnScala.chap4_control

/**
  * Created by yinxing on 2018/11/30.
  */

// 02while循环
class WhileLoop {

  var i = 9
  while (i > 0) {
    i -= 1
    println("i=", i)
  }

  var j = 0
  do {
    j += 1
    println(j)
  } while (j < 5)

}
