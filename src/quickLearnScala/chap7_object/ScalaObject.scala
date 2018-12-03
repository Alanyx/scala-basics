package quickLearnScala.chap7_object

/**
  * Created by yinxing on 2018/12/3.
  */
class ScalaObject {

  // Scala并没有提供Java那样的静态方法或静态字段，但是，可以采用object关键字实现单例对象，具备和Java静态方法同样的功能
  /**
    * 单例对象
    */
  object Person {
    private var lastId = 0

    def newPersonId(): Unit = {
      lastId += 1
      lastId
    }
  }

  // 从上面的定义可以看出，单例对象的定义和类的定义很相似，明显的区分是，用object关键字，而不是用class关键字
  printf("The first person id is %d.\n", Person.newPersonId())
  printf("The second person id is %d.\n", Person.newPersonId())
  printf("The third person id is %d.\n", Person.newPersonId())

  /**
    * 注意，对于一个Scala应用程序而言，必须包含main方法，由于上面代码中没有包含main方法，
    * 因此，不能使用scalac命令进行编译，而是直接使用scala命令运行代码，就可以得到结果；
    * 如果使用scalac命令去编译test.scala文件，就会报错。
    */

  /**
    * 伴生对象
    * 在Java中，我们经常需要用到同时包含实例方法和静态方法的类，在Scala中可以通过伴生对象来实现。
    * 当单例对象与某个类具有相同的名称时，它被称为这个类的“伴生对象”。
    * 类和它的伴生对象必须存在于同一个文件中，而且可以相互访问私有成员（字段和方法）
    */
  class PersonTwo {
    //调用了伴生对象中的方法
    private val id = PersonTwo.newPersonTwoId()
    private var name = ""

    def this(name: String) {
      this()
      this.name = name
    }

    def info() {
      printf("the id of %s is %d.\n", name, id)
    }
  }

  object PersonTwo {
    private var lastId = 0

    // 有个private
    private def newPersonTwoId(): Unit = {
      lastId += 1
      lastId
    }

    def main(args: Array[String]): Unit = {
      val personTwo1 = new PersonTwo("zhangsan")
      val personTwo2 = new PersonTwo("lisi")
      personTwo1.info()
      personTwo2.info()
    }
  }

  //从上面结果可以看出，伴生对象中定义的newPersonId()实际上就实现了Java中静态（static）方法的功能，
  // 所以，实例化对象person1调用newPersonId()返回的值是1，实例化对象person2调用newPersonId()返回的值是2。
  // 我们说过，Scala源代码编译后都会变成JVM字节码，实际上，在编译上面的源代码文件以后，
  // 在Scala里面的class和object在Java层面都会被合二为一，class里面的成员成了实例成员，object成员成了static成员。

  /**
    * 应用程序对象
    * 每个Scala应用程序都必须从一个对象的main方法开始，我们之前介绍的HelloWorld程序就是一个非常典型的例子。
    */
  object HelloWorld {
    def main(args: Array[String]) {
      println("Hello, World!")
    }
  }

  // 第一种方法:直接使用scala命令运行得到结果。
  // 这段代码中没有定义类，就是一个单例对象，因此，可以不用编译，直接使用scala命令运行得到结果，命令如下：
  //  scala test.scala

  // 第二种方法：先编译再执行
  // 可以首先使用scalac编译命令对test.scala进行编译，然后，使用scala命令运行，具体如下：
  //  scalac test.scala
  //  scala -classpath . HelloWorld //这里的HelloWorld是在test.scala文件中object关键字后面的HelloWorld


  /**
    * apply方法和update方法
    * 我们经常会用到对象的apply方法和update方法，虽然我们表面上并没有察觉，
    * 但是，实际上，在Scala中，apply方法和update方法都会遵循相关的约定被调用，
    * 约定如下：用括号传递给变量(对象)一个或多个参数时，Scala 会把它转换成对apply方法的调用；
    * 与此相似的，当对带有括号并包括一到若干个参数的对象进行赋值时，编译器将调用对象的update方法，
    * 在调用时，是把括号里的参数和等号右边的对象一起作为update方法的输入参数来执行调用
    */
  // 测试一下apply方法是否被调用
  class TestApplyClass {
    def apply(param: String): String = {
      println("apply method called, parameter is: " + param)
      "hello scala!"
    }
  }

  val myObject = new TestApplyClass()
  println(myObject("param1"))


  // 上面是类中定义了apply方法，下面看一个在单例对象中定义apply方法的例子：
  object TestApplySingleObject {
    def apply(param1: String, param2: String): String = {
      println("apply method called ")
      param1 + " and " + param2
    }
  }

  val group = TestApplySingleObject("one", "two")
  println(group)


  // 下面我们测试一个伴生类和伴生对象中的apply方法实例
  /**
    * 从上面代码可以看出，当我们执行val a = ApplyTest()时，会导致apply方法的调用并返回该方法调用的值，也就是ApplyTest的实例化对象。
    * 当执行a()时，又会导致调用伴生类的apply方法，如果我们愿意，就可以在伴生类的apply方法中写入一些处理逻辑，这样就可以把传入的参数赋值给实例化对象的变量。
    */
  class TestApplyClassAndObject {
  }

  class ApplyTest {
    def apply() = println("apply method in class is called!")

    def greetingOfClass: Unit = {
      println("Greeting method in class is called.")
    }
  }

  object ApplyTest {
    def apply() = {
      println("apply method in object is called")
      new ApplyTest()
    }
  }

  object TestApplyClassAndObject {
    def main(args: Array[String]) {
      //这里会调用伴生对象中的apply方法
      val a = ApplyTest()
      a.greetingOfClass
      // 这里会调用伴生类中的apply方法
      a()
    }
  }

  // 看一个apply方法的例子。由于Scala中的Array对象定义了apply方法，因此，我们就可以采用如下方式初始化一个数组：
  // 也就是说，不需要new关键字，不用构造器，直接给对象传递3个参数，Scala就会转换成对apply方法的调用，也就是调用Array类的伴生对象Array的apply方法，完成数组的初始化。
  val myArr = Array("scala", "spark", "hadoop")


  // 现在解释Scala中伴生对象的一个重要用途，你就不会存在理解障碍了。在Scala中，伴生对象有一个重要用途，
  // 那就是，我们通常将伴生对象作为工厂使用，这样就不需要使用关键字new来创建一个实例化对象了，具体实例如下：
  class Car(name: String) {
    def info() {
      println("Car 's name is " + name)
    }
  }

  object Car {
    // apply方法会调用伴生类Car的**构造方法**创建一个Car
    def apply(name: String): Car = new Car(name)
  }

  object myTest {
    def main(args: Array[String]): Unit = {
      // 这里会调用伴生对象中的apply方法，apply方法会创建一个Car类的实例化对象
      val myCar = Car("BMW")
      myCar.info()
    }
  }


  /**
    * update
    * 前面介绍了apply方法，实际上，update方法也是类似的（感兴趣的读者，可以查找网络资料学习update方法如何测试，这里不再赘述），比如：
    */
  // 声明一个长度为3的字符串数组，每个数组元素初始化为null
  val myStrArr = new Array[String](3)
  // 实际上，调用了伴生类Array中的update方法，执行myStrArr.update(0,"BigData")
  myStrArr(0) = "BigData"
  myStrArr(1) = "hadoop"
  myStrArr.update(2, "spark")
  // 从上面可以看出，在进行元组赋值的时候，之所以没有采用Java中的方括号myStrArr[0]，而是采用圆括号的形式，myStrArr(0)，是因为存在上述的update方法的机制

}
