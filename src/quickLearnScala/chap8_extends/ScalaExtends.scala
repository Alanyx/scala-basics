package quickLearnScala.chap8_extends

/**
  * Created by yinxing on 2018/12/3.
  */

// 继承
class ScalaExtends {

  /**
    * Scala中的继承与Java有着显著的不同：
    * （1）重写一个非抽象方法必须使用override修饰符。
    * （2）只有主构造器可以调用超类的主构造器。
    * （3）在子类中重写超类的抽象方法时，不需要使用override关键字。
    * （4）可以重写超类中的字段。
    * Scala和Java一样，不允许类从多个超类继承，因此，下面我们只讨论继承自一个类的情形。
    */
  /**
    * 抽象类
    */
  // 以汽车为例子，首先我们创建一个抽象类，让这个抽象类被其他类继承
  // 抽象类，不能直接被实例化
  abstract class Car {
    // 字段没有初始化值，就是一个抽象字段
    val carBrand: String

    // 抽象方法，不需要使用abstract关键字
    def info()

    def greeting() {
      println("welcome to my car!(abstract)")
    }
  }

  // 关于上面的定义，说明几点：
  // （1）定义一个抽象类，需要使用关键字abstract。
  // （2）定义一个抽象类的抽象方法，也不需要关键字abstract，只要把方法体空着，不写方法体就可以。
  // （3）抽象类中定义的字段，只要没有给出初始化值，就表示是一个抽象字段，
  //     但是，抽象字段必须要声明类型，比如：val carBrand: String，就把carBrand声明为字符串类型，这个时候，不能省略类型，否则编译会报错。


  /**
    * 扩展类
    * 抽象类不能直接被实例化，所以，下面我们定义几个扩展类，它们都是扩展了Car类，或者说继承自Car类。
    */
  class BMWCar extends Car {
    //重写超类字段，需要使用override关键字，否则编译会报错
    override val carBrand: String = "BMW"

    //重写超类的抽象方法时，不需要使用override关键字，不过，如果加上override编译也不错报错
    def info() {
      println("This is a %s car. It is on sale", carBrand)
    }

    //重写超类的非抽象方法，**必须使用override关键字**
    override def greeting() {
      println("Welcome to my BMW car!")
    }
  }

  class BYDCar extends Car{
    override val carBrand: String = "BYD"

    def info(){println("This is a %s car. It is on sale", carBrand)}

    override def greeting() {println("welcome to my BYD car！")}
  }



}
