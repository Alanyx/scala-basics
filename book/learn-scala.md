Learn-Scala
========

# I 可扩展语言概述
## 安装
略

## 使用 Spark REPL
使用 `:help` 命令可以启动帮助系统

#### REPL 解释: 

- Read:读
- Evaluate:计算
- Print:打印
- Loop:循环

``` scala
scala> println("hello scala")
hello scala

```

```
scala> 5 * 7
res4: Int = 35

scala> 2 * res4
res5: Int = 70
```

命令返回值时，REPL 会把它赋给一个新的常量变量，之后的运算可以引用这个值，即“res”变量。

> res 变量会编号，总会有一个唯一容器存储命令结果（如上面的 res4）

# II 处理数据:字面量、值、变量、类型

## 概述

- 值语法： `val <name> : <type> = <literal>`

```
scala> val x:Int = 5
x: Int = 5

scala> x
res0: Int = 5

scala> x * 2
res1: Int = 10

scala> x / 5
res2: Int = 1
```

> 上面创建了一个名为 x、类型为 Int 的值，赋值为字面数字 5

- 变量语法： `var <name> : <type> = <literal>`

```
scala> var a:Double = 2.72
a: Double = 2.72

scala> a = 355.0 / 113.0
a: Double = 3.1415929203539825

scala> a = 5
a: Double = 5.0

```

## 值

##### 语法：定义值

	val <identifier>[:<type>] = <data>

值需要有一个名和所赋的数据，不要求有显示的类型(即 `<type> `语法)， scala 编译器会根据赋值推导其类型。

``` scala
scala> val x : Int = 20
x: Int = 20

scala> val greeting: String = "hello scala"
greeting: String = hello scala

scala> val atSymbol: Char = '@'
atSymbol: Char = @
```

