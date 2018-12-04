package quickLearnScala.chap_9_trait

/**
  * Created by yinxing on 2018/12/3.
  */
class ScalaTrait {

  /**
    * Java中提供了接口，允许一个类实现任意数量的接口。在Scala中没有接口的概念，而是提供了“特质(trait)”，
    * 它不仅实现了接口的功能，还具备了很多其他的特性。Scala的特质，是代码重用的基本单元，可以同时拥有抽象方法和具体方法。
    * Scala中，一个类只能继承自一个超类，却可以实现多个特质，从而重用特质中的方法和字段，实现了多重继承。
    */
  /**
    * 特质的定义
    * 特质的定义和类的定义非常相似，有区别的是，特质定义使用关键字trait
    */
  trait CarId {
    var id: Int

    //定义了一个抽象方法
    def currentId(): Int
  }

  // 上面定义了一个特质，里面包含一个抽象字段id和抽象方法currentId
  // 注意，抽象方法不需要使用abstract关键字，特质中没有方法体的方法，默认就是抽象方法


  /**
    * 把特质混入类中
    * 特质定义好以后，就可以使用extends或with关键字把特质混入类中
    */
  // 使用extends关键字
  class BYDCardId extends CarId {
    override var id: Int = 10000

    //返回汽车编号
    override def currentId(): Int = {
      id += 1;
      id
    }
  }

  class BMWCarId extends CarId {
    override var id: Int = 20000

    override def currentId(): Int = {
      id += 1;
      id
    }
  }


  /**
    * 特质可以包含具体实现:
    * 上面的实例中，特质只包含了抽象字段和抽象方法，相当于实现了类似Java接口的功能。
    * 实际上，特质也可以包含具体实现，也就是说，特质中的字段和方法不一定要是抽象的
    */
  trait CarGreeting {
    def greeting(msg: String) {
      println(msg)
    }
  }

  /**
    * 把多个特质混入类中
    */
  // 上面我们已经定义了两个特质，即CarId和CarGreeting。现在，我们可以把两个特质都混入到类中
  trait CarId2 {
    var id: Int

    def currentId(): Int //定义了一个抽象方法
  }

  trait CarGreeting2 {
    def greeting(msg: String) {
      println(msg)
    }
  }

  //使用extends关键字混入第1个特质，后面可以反复使用with关键字混入更多特质
  class BYDCarId2 extends CarId2 with CarGreeting {
    override var id = 10000

    def currentId(): Int = {
      id += 1;
      id
    }
  }

  class BMWCarId2 extends CarId2 with CarGreeting {
    override var id = 20000

    def currentId(): Int = {
      id += 1;
      id
    }
  }

  object MyCar {
    def main(args: Array[String]): Unit = {
      val myCarId1 = new BYDCarId2()
      val myCarId2 = new BMWCarId2()
      myCarId1.greeting("welcome to my byd")
      println("my first carId is %d.\n", myCarId1.currentId())
      myCarId2.greeting("welcome to my bmw")
      println("my second carId is %d.\n", myCarId2.currentId())
    }
  }


}
