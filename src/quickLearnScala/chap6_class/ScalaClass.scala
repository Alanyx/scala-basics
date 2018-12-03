package quickLearnScala.chap6_class

/**
  * Created by yinxing on 2018/11/30.
  */
class ScalaClass {

  /**
    * 简单的类
    */
  // 最简单的类的定义形式是：
  class Counter {
    var value = 0 //注意这里没有private修饰符，从而让这个变量对外部可见
    def increment(step: Int): Unit = {
      value += step
    }

    def current(): Int = {
      value
    }
  }

  // 使用new关键字来生成对象：
  new Counter() // new Counter

  /**
    * 给类增加字段和方法
    */
  class CounterTwo {
    private var value = 0

    // increment()是方法，没有参数，冒号后面的Unit是表示返回值的类型，在Scala中不返回任何值，那么就用Unit表示，相当于Java中的void类型。
    // 方法的返回值，不需要靠return语句，方法里面的最后一个表达式的值就是方法的返回值，比如，
    // 下面current()方法里面只有一条语句“value”，那么，value的值就是该方法的返回值。
    def increment(): Unit = {
      value += 1
    }

    def current(): Int = {
      value
    }
  }

  // 因为increment()方法只是对value的值进行了增加1的操作，并没有返回任何值，所以，返回值类型是Unit。
  // Unit后面的等号和大括号后面，包含了该方法要执行的具体操作语句。
  // 如果大括号里面只有一行语句，那么也可以直接去掉大括号，写成下面的形式：
  class CounterThree {
    private var value = 0

    def increment(): Unit = value += 1 //去掉了大括号
    def current(): Int = {
      value
    } //作为对比，这里依然保留大括号
  }

  // 或者，还可以去掉返回值类型和等号，只保留大括号，如下：
  class CounterFour {
    private var value = 0

    //去掉了返回值类型和等号，只保留大括号
    def increment() {
      value += 1
    }

    //作为对比，这里依然保留原来形式
    def current(): Int = {
      value
    }
  }

  /**
    * 创建对象
    * Scala在调用无参方法时，是可以省略方法名后面的圆括号的。
    */
  val myCounter = new CounterTwo()
  //或者也可以不用圆括号，写成myCounter.increment
  myCounter.increment()
  println(myCounter.current())

  /**
    * 编译和执行
    */
  class CounterFive {
    private var value = 0

    def increment(): Unit = {
      value += 1
    }

    def current(): Int = {
      value
    }
  }

  object MyCounter {
    def main(args: Array[String]) {
      val myCounter = new Counter
      myCounter.increment()
      println(myCounter.current)
    }
  }

  scalac TestCounterJVM
  .scala
  scala - classpath.MyCounter //MyCounter是包含main方法的对象名称，这里不能使用文件名称TestCounterJVM


  /**
    * getter和setter方法
    * Scala中，也提供了getter和setter方法的实现，但是并没有定义成getXxx和setXxx
    */
  object MyCounter {
    def main(args: Array[String]): Unit = {
      val myCounter = new Counter()
      //不是用getXxx获取字段的值
      println(myCounter.value)
      //不是用setXxx设置字段的值
      myCounter.value = 3
      // 设置步长为1，每次增加1
      myCounter.increment(1)
      println(myCounter.current())
    }
  }

  // 在Java中，是不提倡设置这种公有(public)字段的，一般都是把value字段设置为private，然后提供getter和setter方法来获取和设置字段的值。
  // 那么，到了Scala中该怎么做呢？
  //  我们先把value字段声明为private，看看会出现什么效果，继续修改TestCounterJVM.scala文件：
  class CounterN {
    //增加了private修饰符，成为私有字段
    private var privateValue = 0

    // value变成私有字段以后，Scala又没有提供getter和setter方法，怎么可以访问value字段呢？
    // 解决方案是，在Scala中，可以通过定义类似getter和setter的方法，分别叫做value和value_=，具体如下：
    //定义一个方法，方法的名称就是原来我们想要的字段的名称
    def value = privateValue

    def value_=(newValue: Int) {
      //只有提供的新值是正数，才允许修改
      if (newValue > 0) privateValue = newValue
    }

    def increment(step: Int): Unit = {
      value += step
    }

    def current(): Int = {
      value
    }
  }


  /**
    * 辅助构造器
    * Scala构造器包含1个主构造器和若干个（0个或多个）辅助构造器。
    * 我们首先认识一下辅助构造器。辅助构造器的名称为this，每个辅助构造器都必须调用一个此前已经定义的辅助构造器或主构造器
    */
  // 带有辅助构造器的类，我们对上面的Counter类定义进行修改：
  class Counter {
    // value用来存储计数器的起始值
    private var value = 0
    // 表示计数器的名称
    private var name = ""
    // mode用来表示计数器类型（比如，1表示步数计数器，2表示时间计数器）
    private var mode = 1

    def this(name: String) {
      // 调用主构造器
      this()
      this.name = name
    }

    def this(name: String, mode: Int) {
      this(name)
      this.mode = mode
    }

    def increment(step: Int): Unit = {
      value += step
    }

    def current(): Int = {
      value
    }

    def info(): Unit = {
      printf("Name:%s and mode is %d\n", name, mode)
    }
  }

  object MyCounter {
    def main(args: Array[String]): Unit = {
      // 主构造器
      val myCounter1 = new Counter()
      // 第一个辅助构造器，计数器的名称设置为Runner，用来计算跑步步数
      val myCounter2 = new Counter("runner")
      // 第二个辅助构造器，计数器的名称设置为Timer，用来计算秒数
      val myCounter3 = new Counter("timer", 2)
      // 显示计数器信息
      myCounter1.info()
      //设置步长
      myCounter1.increment(1)
      //显示计数器当前值
      printf("Current Value is: %d\n", myCounter1.current)
      //显示计数器信息
      myCounter2.info
      //设置步长
      myCounter2.increment(2)
      //显示计数器当前值
      printf("Current Value is: %d\n", myCounter2.current)
      //显示计数器信息
      myCounter3.info
      //设置步长
      myCounter3.increment(3)
      //显示计数器当前值
      printf("Current Value is: %d\n", myCounter3.current)

    }
  }

  /**
    * 主构造器
    * Scala的主构造器是整个类体，需要在类名称后面罗列出构造器所需的所有参数，这些参数被编译成字段，字段的值就是创建对象时传入的参数的值。
    */
  class CounterMain(val name:String,val model:Int){
    //value用来存储计数器的起始值
    private var value = 0
    def increament(step:Int):Unit = {
      value +=step
    }
    def current():Int={value}
    def info():Unit = {
      println("name:%s and mode is %d\n",name,model)
    }

    object MyCounter{
      def main(args: Array[String]): Unit = {
        val myCounter =new CounterMain("timer",2)
        myCounter.info()
        myCounter.increament(1)
        printf("Current Value is: %d\n",myCounter.current) //显示计数器当前值
      }
    }

  }



}
