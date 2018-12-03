package quickLearnScala.chap5_data_structure
import scala.collection.mutable.Map


/**
  * Created by yinxing on 2018/11/30.
  */

// 映射(Map)
class MapExample {

  // 在Scala中，映射(Map)是一系列键值对的集合，也就是，建立了键和值之间的对应关系。在映射中，所有的值，都可以通过键来获取。
  // 映射包括可变和不可变两种，默认情况下创建的是不可变映射，如果需要创建可变映射，需要引入scala.collection.mutable.Map包

  /**
    * 创建映射
    */
  // 创建一个不可变映射：
  val university =Map("key1"->"value1","key2"->"value2","key3"->"value3")
  // 获取映射中的值，可以通过键来获取，如下：
  println(university("key1"))

  // 如果要检查映射中是否包含某个值，可以使用contains方法，如下：
  val value1 = if(university.contains("key1")) university("key1") else 0
  println(value1)

  // 上面我们定义的是不可变映射，是无法更新映射中的元素的，也无法增加新的元素。如果要更新映射的元素，就需要定义一个可变的映射，如下
  val university2 = Map("key1"->"value1","key2"->"value2","key3"->"value3")
  // 更新已有元素的值
  university2("key1")="newValue1"
  // 添加新元素
  university2("key4")="newValue4"

  // 也可以使用+=操作来添加新的元素，如下：
  //添加一个新元素
  university2 +=("key5"->"value5")
  //同时添加两个新元素
  university2 +=("key6"->"value6","key7"->"value7")


  /**
    * 循环遍历映射
    * 基本格式是：
    * for ((k,v) <- 映射) 语句块
    */
  for ((k,v) <- university) printf("Code is : %s and name is: %s\n",k,v)

  // 只遍历映射中的键
  for(k <- university.keys) println(k)

  // 只遍历映射中的值
  for (v <- university.values) println(v)



}
