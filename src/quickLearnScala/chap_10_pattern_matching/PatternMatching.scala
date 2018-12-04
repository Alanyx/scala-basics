package quickLearnScala.chap_10_pattern_matching

/**
  * Created by yinxing on 2018/12/4.
  */
class PatternMatching {

  // 模式匹配
  //Java中有switch-case语句，但是，只能按顺序匹配简单的数据类型和表达式。
  // 相对而言，Scala中的模式匹配的功能则要强大得多，可以应用到switch语句、类型检查、“解构”等多种场合。
  /**
    * 简单匹配
    */
  // Scala的模式匹配最常用于match语句中。下面是一个简单的整型值的匹配实例。
  val colorNum = 1
  val colorStr = colorNum match {
    case 1 => "red"
    case 2 => "green"
    case 3 => "yellow"
    case _ => "Not Allowed"
  }
  println(colorStr)

  // 另外，在模式匹配的case语句中，还可以使用变量。
  val colorNum2 = 4
  val colorStr2 = colorNum2 match {
    case 1 => "red"
    case 2 => "green"
    case 3 => "yellow"
    case unexpected => unexpected + " is Not Allowed"
  }
  println(colorStr2)

  /**
    * 类型模式
    * Scala可以对表达式的类型进行匹配
    */
  for (elem <- List(9, 12.3, "spark", "hadoop", 'scala)) {
    val str = elem match {
      case i: Int => i + "is an int value"
      case d: Double => d + "is a double value"
      case "spark" => "spark is found"
      case s: String => s + "is a string value"
      case _ => "this is a unexpected value"
    }
    println(str)
  }

  /**
    * “守卫(guard)”语句
    * 可以在模式匹配中添加一些必要的处理逻辑。
    */
  for (elem <- List(1, 2, 3, 4)) {
    elem match {
      case _ if (elem % 2 == 0) => println(elem + " is even.")
      case _ => println(elem + " is odd.")
    }
  }

  /**
    * for表达式中的模式
    * for ((k,v) <- 映射) 语句块
    */
  val university = Map("XMU" -> "Xiamen University", "THU" -> "Tsinghua University", "PKU" -> "Peking University")
  for ((k, v) <- university) printf("Code is : %s and name is: %s\n", k, v)

  /**
    * case类的匹配
    * case类是一种特殊的类，它们经过优化以被用于模式匹配
    */
  case class Car(brand: String, price: Int)

  val BYDCar = new Car("BYD", 80000)
  val BMWCar = new Car("BMW", 100000)
  val BenzCar = new Car("Benz", 110000)
  for (car <- List(BYDCar, BMWCar, BenzCar)) {
    car match {
      case Car("BYD", 80000) => println("hello BYD")
      case Car("BMW", 100000) => println("hello BMW")
      case Car(brand, price) => println("Brand:" + brand + ", Price:" + price + ", do you want it?")
    }
  }

  /**
    * Option类型
    */
  // 标准类库中的Option类型用case类来表示那种可能存在、也可能不存在的值。
  // 一般而言，对于每种语言来说，都会有一个关键字来表示一个对象引用的是“无”，在Java中使用的是null。
  // Scala融合了函数式编程风格，因此，当预计到变量或者函数返回值可能不会引用任何值的时候，建议你使用Option类型。
  // Option类包含一个子类Some，当存在可以被引用的值的时候，就可以使用Some来包含这个值，例如Some(“Hadoop”)。
  // 而None则被声明为一个对象，而不是一个类，表示没有值。
  //首先我们创建一个映射
  scala> val books=Map("hadoop"->5,"spark"->10,"hbase"->7)
  books: scala.collection.immutable.Map[String,Int] = Map(hadoop -> 5, spark -> 10, hbase -> 7)

  //下面我们从映射中取出键为"hadoop"对应的值，这个键是存在的，可以取到值，并且取到的值会被包含在Some中返回
  scala> books.get("hadoop")
  res0: Option[Int] = Some(5)

  //下面我们从映射中取出键为"hive"对应的值，这个键是不存在的，所以取到的值是None对象
  scala> books.get("hive")
  res1: Option[Int] = None


  // Option类型还提供了getOrElse方法，这个方法在这个Option是Some的实例时返回对应的值，而在是None的实例时返回传入的参数。例如：
  scala> val sales=books.get("hive")
  sales: Option[Int] = None

  scala> sales.getOrElse("No Such Book")
  res3: Any = No Such Book

  scala> println(sales.getOrElse("No Such Book"))
  No Such Book

  /**
    * 在Scala中，使用Option的情形是非常频繁的。在Scala里，经常会用到Option[T]类型，其中的T可以是Sting或Int或其他各种数据类型。
    * Option[T]实际上就是一个容器，我们可以把它看做是一个集合，只不过这个集合中要么只包含一个元素（被包装在Some中返回），要么就不存在元素（返回None）。
    * 既然是一个集合，我们当然可以对它使用map、foreach或者filter等方法。比如
    */
  scala> books.get("hive").foreach(println)
  // 可以发现，上述代码执行后，屏幕上什么都没有显示，因为，foreach遍历遇到None的时候，什么也不做，自然不会执行println操作。



}
