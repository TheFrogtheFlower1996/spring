
# JVM

~~~text
jvm java程序运行环境（JAVA 二进制字节码的运行环境）

优点：

跨平台性：一次编译，处处运行
垃圾回收机制，自动内存管理
~~~

* KB MB GB
~~~text
 1 KB = 1024 byte
 1 MB（兆） = 1024 KB
 1 GB = 1024 MB  
~~~

## JVM、JRE、JDK 区别

~~~text
JRE = jvm + 基础类库
JDK = jvm + 基础类库 + 编译环境
~~~

## JVM内存模型

![img_0.png](image-JVM/JVM内存模型.png)

# java运行时类何时被加载？

![img_0.png](image-JVM/类加载.png)

# JVM类加载过程

![img_0.png](image-JVM/类的加载过程.png)

![img_0.png](image-JVM/类的加载过程1.png)

## 加载

![img_0.png](image-JVM/加载.png)

## 验证
~~~text
验证Class文件中的字节流符合约束
~~~

## 准备
~~~text
类变量赋默认初始值，int为0，long为0l，boolean为false，引用类型为null，常量赋正式值
~~~

## 解析
~~~text
把 符号引用 翻译为 直接引用
~~~

##初始化
![img_0.png](image-JVM/初始化.png)
![img_0.png](image-JVM/初始化1.png)

* 一个类被加载的过程？ 初始化顺序
~~~java
public class test01 {

    // 静态常量 准备阶段 赋值
    public static final String URL = "静态常量";

    //静态变量 准备阶段 赋值为null，初始化阶段 赋值
    public static String URL2 = "静态变量";

    //变量 初始化赋值
    public String URL3 = "变量";

    //静态代码块 准备阶段赋值
    static {
        System.out.println(URL);
        System.out.println(URL2);
        System.out.println("静态代码块");
    }

    //普通代码块 初始化赋值
    {
//        System.out.println(URL2);
        System.out.println(URL3);
        System.out.println("普通代码块");
    }

    //构造器 初始化赋值
    public test01(){
        System.out.println("构造器");
    }

    public static void main(String[] args) {

        new test01();
    }
}
~~~

![img_0.png](image-JVM/初始化顺序.png)


* 继承时父子类的初始化顺序是怎样的？

* 先静后动，先父后子

父类

~~~java
public class Fu {
    // 静态常量 准备阶段 赋值
    public static final String URL = "父类 静态常量";

    //变量 初始化赋值
    public String URL3 = "父类 变量";

    //静态代码块 准备阶段赋值
    static {
        System.out.println(URL);
        System.out.println("父类 静态代码块");
    }

    //普通代码块 初始化赋值
    {
        System.out.println(URL3);
        System.out.println("父类 普通代码块");
    }

    //构造器 初始化赋值
    public Fu(){
        System.out.println("父类 构造器");
    }
}
~~~

子类
~~~java
public class So extends Fu{

    // 静态常量 准备阶段 赋值
    public static final String URL = "子类 静态常量";

    //变量 初始化赋值
    public String URL3 = "子类 变量";

    //静态代码块 准备阶段赋值
    static {
        System.out.println(URL);
        System.out.println("子类 静态代码块");
    }

    //普通代码块 初始化赋值
    {
        System.out.println(URL3);
        System.out.println("子类 普通代码块");
    }

    //构造器 初始化赋值
    public So(){
        System.out.println("子类 构造器");
    }

    public static void main(String[] args) {
        new So();
    }
}
~~~

![img_0.png](image-JVM/初始化顺序2.png)


##卸载
![img_0.png](image-JVM/卸载.png)

# JVM有哪些类加载器

![img_0.png](image-JVM/类加载器.png)

![img_0.png](image-JVM/类加载器2.png)

# JVM中不同的类加载器加载哪些文件

## 启动类加载器 （根的类加载器）

![img_0.png](image-JVM/启动类加载器.png)

## 扩展类加载器
![img_0.png](image-JVM/扩展类加载器.png)

## 应用程序类（系统的类加载器）

* 自己写的类和maven里面的jar包，都是被 ApplicationClassLoader 静态内部类加载

![img_0.png](image-JVM/应用程序类.png)

![img_0.png](image-JVM/应用程序类1.png)


# JVM三层类加载器之间是继承关系吗？

~~~text
不是，首先三个加载器都在jdk的 rt.jar/sun/misc/Launcher 类下的静态内部类，他们都继承 URLClassLoader 间接继承 ClassLoader

而且根的类加载器是由C++写成的

自定义类加载器直接继承 ClassLoader
~~~

# JVM类加载的双亲委派机制

![img_0.png](image-JVM/双亲委派机制.png)
![img_0.png](image-JVM/双亲委派机制1.png)

# JDK为什么要设计双亲委派模型 

![img_0.png](image-JVM/双亲委派机制好处.png)

![img_0.png](image-JVM/双亲委派机制好处1.png)

![img_0.png](image-JVM/双亲委派机制好处2.png)

# 可以打破JVM双亲委派模型吗

![img_0.png](image-JVM/双亲委派机制4.png)

# 如何自定义类加载器

![img_0.png](image-JVM/自定义类加载器.png)

# JVM内存模型

![img_0.png](image-JVM/JVM内存模型1.png)

# JVM内存划分

![img_0.png](image-JVM/JVM内存划分.png)

# 堆中存什么？栈中存什么

* 数据类型
~~~text
Java虚拟机中，数据类型可以分为两类：基本类型和引用类型。基本类型的变量保存原始值，即：他代表的
值就是数值本身；而引用类型的变量保存引用值。“引用值”代表了某个对象的引用，而不是对象本身，对象
本身存放在这个引用值所表示的地址的位置

基本类型包括：byte,short,int,long,char,float,double,Boolean,returnAddress
引用类型包括：类类型，接口类型和数组
~~~

* 栈是运行时的单位，而堆是存储的单位
~~~text
栈解决程序的运行问题，即程序如何执行，或者说如何处理数据；堆解决的是数据存储的问题，即数据怎么放、放在哪儿
~~~

* 堆中存什么？栈中存什么？
~~~text
堆中存的是对象。栈中存的是基本数据类型和堆中对象的引用。

一个对象的大小是不可估计的，或者说是可以动态变化的，但是在栈中，一个对象只对应了一个4btye的引用（堆栈分离的好处）

为什么不把基本类型放堆中呢？

因为其占用的空间一般是1~8个字节——需要空间比较少，而且因为是基本类型，所以不会出现动态增长的情况——长度固定，因此栈中存储就够了，如果把他存在堆中是没有什么意义的（还会浪费空间，后面说明）。
可以这么说，基本类型和对象的引用都是存放在栈中，而且都是几个字节的一个数，因此在程序运行时，他们的处理方式是统一的。但是基本类型、对象引用和对象本身就有所区别了，
因为一个是栈中的数据一个是堆中的数据。最常见的一个问题就是，Java中参数传递时的问题
~~~


# JVM 哪些区域 线程私有 线程共享

~~~text
堆和元空间线程共享，其他都是私有
~~~

# 程序计数器

~~~text
线程执行的字节码的行号指示器

内存较小 忽略不计 线程私有 互不影响

没有内存溢出和垃圾回收
~~~

# 栈
~~~text
存储 基本类型和对象的引用
栈是运行时单位，解决程序的运行问题，即程序如何执行，或者说如何处理数据
栈空间一般很小，不设置默认为1M，设置通过 -Xss1M 命令
方法执行入栈，执行完毕出栈（先进后出），随线程而灭
不会GC回收，线程私有
~~~

![img_0.png](image-JVM/虚拟机栈1.png)

![img_0.png](image-JVM/虚拟机栈2.png)

#本地方法栈

![img_0.png](image-JVM/本地方法栈.png)

# 堆
~~~text
存储 对象和数组
~~~

![img_0.png](image-JVM/java堆.png)

![img_0.png](image-JVM/java堆1.png)

![img_0.png](image-JVM/java堆2.png)

# 对象如何在 堆内存 中分配

![img_0.png](image-JVM/JVM中对象如何在堆内存中分配.png)

![img_0.png](image-JVM/JVM中对象如何在堆内存中分配2.png)

![img_0.png](image-JVM/JVM中对象如何在堆内存中分配3.png)

![img_0.png](image-JVM/JVM中对象如何在堆内存中分配4.png)

# 堆内存对象布局

![img_0.png](image-JVM/堆内存.png)

![img_0.png](image-JVM/堆内存1.png)

![img_0.png](image-JVM/堆内存2.png)

![img_0.png](image-JVM/堆内存3.png)

![img_0.png](image-JVM/堆内存4.png)

![img_0.png](image-JVM/堆内存2.png)

# JVM发生 堆内存溢出？

![img_0.png](image-JVM/堆内存溢出.png)

![img_0.png](image-JVM/堆内存溢出1.png)

![img_0.png](image-JVM/堆内存溢出2.png)

![img_0.png](image-JVM/堆内存溢出.png)

# JVM如何判断对象可以被回收

![img_0.png](image-JVM/对象回收.png)


## 哪些对象可以做 GC Roots?

~~~text
1、栈内存中的 对象的引用 
    例如：ArrayList list = new ArrayList()，如果list=null，那么该对象就会被垃圾回收
    
2、方法区中静态属性 对象的引用
    例如：饿汉模式中：
    private static A a;
    public static synchronized A getInstance(){
    
        if(a == null){
            a = new A();
        }
    }
    
3、方法区中常量 对象的引用
    例如：
    private final A a = new A();
~~~

![img_0.png](image-JVM/GCRoots.png)

![img_0.png](image-JVM/GCRoots2.png)

# JAVA的引用类型 

![img_0.png](image-JVM/java的引用类型.png)

# JVM内存分代模型

![img_0.png](image-JVM/内存分代模型.png)

![img_0.png](image-JVM/内存分代模型1.png)

# JVM堆中新生代的垃圾回收过程 

![img_0.png](image-JVM/新生代的垃圾回收过程.png)

![img_0.png](image-JVM/新生代的垃圾回收过程1.png)

# JVM动态年龄判断

![img_0.png](image-JVM/动态年龄判断.png)

![img_0.png](image-JVM/动态年龄判断1.png)

![img_0.png](image-JVM/动态年龄判断2.png)

![img_0.png](image-JVM/动态年龄判断3.png)

# 老年代空间分配担保机制

![img_0.png](image-JVM/空间担保机制.png)
![img_0.png](image-JVM/空间担保机制1.png)
![img_0.png](image-JVM/空间担保机制2.png)
![img_0.png](image-JVM/空间担保机制3.png)
![img_0.png](image-JVM/空间担保机制4.png)

# 什么情况下对象会进入老年代

![img_0.png](image-JVM/对象会进入老年代.png)
![img_0.png](image-JVM/对象会进入老年代1.png)
![img_0.png](image-JVM/对象会进入老年代2.png)

# 元空间

![img_0.png](image-JVM/元空间.png)


# JVM本机直接内存
![img_0.png](image-JVM/JVM本机直接内存.png)


#JVM本机直接内存溢出
![img_0.png](image-JVM/JVM本机直接内存溢出.png)

![img_0.png](image-JVM/JVM本机直接内存溢出1.png)

# 说几个和JVM内存相关的核心参数？

![img_0.png](image-JVM/核心参数.png)

![img_0.png](image-JVM/核心参数1.png)

# 如何计算对象的大小？

![img_0.png](image-JVM/如何计算对象的大小.png)
![img_0.png](image-JVM/如何计算对象的大小1.png)

# 堆 为什么要分为年轻代和老年代

![img_0.png](image-JVM/年轻代和老年代.png)
![img_0.png](image-JVM/年轻代和老年代1.png)
![img_0.png](image-JVM/年轻代和老年代2.png)
![img_0.png](image-JVM/年轻代和老年代3.png)
![img_0.png](image-JVM/年轻代和老年代4.png)

# JVM堆的年轻代为什么有两个Survivor区

# Eden区 和 S0 S1 空间大小为什么是 8:1:1

![img_0.png](image-JVM/Eden区.png)

# JVM中垃圾回收算法？

![img_0.png](image-JVM/垃圾回收算法.png)
![img_0.png](image-JVM/垃圾回收算法1.png)
![img_0.png](image-JVM/垃圾回收算法2.png)
![img_0.png](image-JVM/垃圾回收算法3.png)
![img_0.png](image-JVM/垃圾回收算法4.png)
![img_0.png](image-JVM/垃圾回收算法5.png)
![img_0.png](image-JVM/垃圾回收算法5.1.png)
![img_0.png](image-JVM/垃圾回收算法6.png)
![img_0.png](image-JVM/垃圾回收算法7.png)
![img_0.png](image-JVM/垃圾回收算法8.png)
![img_0.png](image-JVM/垃圾回收算法9.png)
![img_0.png](image-JVM/垃圾回收算法10.png)
![img_0.png](image-JVM/垃圾回收算法11.png)
![img_0.png](image-JVM/垃圾回收算法12.png)

# JVM垃圾收集器

![img_0.png](image-JVM/垃圾收集器.png)
![img_0.png](image-JVM/垃圾收集器2.png)
![img_0.png](image-JVM/垃圾收集器3.png)
![img_0.png](image-JVM/垃圾收集器4.png)
![img_0.png](image-JVM/垃圾收集器5.png)
![img_0.png](image-JVM/垃圾收集器6.png)
![img_0.png](image-JVM/垃圾收集器7.png)
![img_0.png](image-JVM/垃圾收集器8.png)
![img_0.png](image-JVM/垃圾收集器9.png)
![img_0.png](image-JVM/垃圾收集器10.png)
![img_0.png](image-JVM/垃圾收集器11.png)
![img_0.png](image-JVM/垃圾收集器12.png)
![img_0.png](image-JVM/垃圾收集器13.png)
![img_0.png](image-JVM/垃圾收集器14.png)
![img_0.png](image-JVM/垃圾收集器15.png)
![img_0.png](image-JVM/垃圾收集器16.png)
![img_0.png](image-JVM/垃圾收集器17.png)
![img_0.png](image-JVM/垃圾收集器18.png)
![img_0.png](image-JVM/垃圾收集器19.png)
![img_0.png](image-JVM/垃圾收集器20.png)
![img_0.png](image-JVM/垃圾收集器21.png)
![img_0.png](image-JVM/垃圾收集器22.png)
![img_0.png](image-JVM/垃圾收集器23.png)
![img_0.png](image-JVM/垃圾收集器24.png)
![img_0.png](image-JVM/垃圾收集器25.png)
![img_0.png](image-JVM/垃圾收集器26.png)
![img_0.png](image-JVM/垃圾收集器27.png)
![img_0.png](image-JVM/垃圾收集器28.png)
![img_0.png](image-JVM/垃圾收集器29.png)
![img_0.png](image-JVM/垃圾收集器30.png)
![img_0.png](image-JVM/垃圾收集器31.png)
![img_0.png](image-JVM/垃圾收集器32.png)
![img_0.png](image-JVM/垃圾收集器33.png)
![img_0.png](image-JVM/垃圾收集器34.png)
![img_0.png](image-JVM/垃圾收集器35.png)
![img_0.png](image-JVM/垃圾收集器36.png)
![img_0.png](image-JVM/垃圾收集器37.png)
![img_0.png](image-JVM/垃圾收集器38.png)
![img_0.png](image-JVM/垃圾收集器39.png)
![img_0.png](image-JVM/垃圾收集器40.png)
![img_0.png](image-JVM/垃圾收集器41.png)




















