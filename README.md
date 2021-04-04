# Jdk-use

需求：
1.使用SAX读取自定义配置的xml文件数据。

SAX parser is working differently with a DOM parser, it neither load any XML document into memory nor creates an object representation of the XML document. Instead, the SAX parser use callback function (org.xml.sax.helpers.DefaultHandler) to informs clients of the XML document structure.
参考：https://www.javaguides.net/2018/10/how-to-read-xml-file-in-java-sax-parser.html

解读：
ModuleHandler类 extends DefaultHandler
startElement 首标签元素读取 <Module>
characters   标签的属性(包括标签类型、标签中的文本内容)
endElement   末标签读取 </Module>

从首部标签开始向内部标签进行遍历标签式搜索
这个标签读取是都会读取
按照类似深度搜索根标签首标签开始读取到末尾标签。

遍历的过程中我们可以根据需要创建对象，并给相应的对象设置属性等
好处是，读取标签并没有创造整个的对象，我们在寻找指定标签内容时候对内存特别友好

SAX Parser is faster and uses less memory than DOM parser.

2.手写JDK动态代理实现。
JDK动态代理采用采用字节重组，重新生成对象来替代原始对象，以达到动态代理的目的。
(1)获取被代理对象的引用，并且获得它的所有接口，反射获取。
(2)JDK动态代理类重新生成一个新的类，同时新的类要实现被代理类实现的所有接口。
(3)动态生成Java代码，新加业务逻辑方法由一定的逻辑代码调用。
(4)编译新生成的Java代码.class文件。
(5)重新加载到JVM中运行。

静态代理：将自己本身的对象组合到中介类，业务层调用中介类
动态代理：可以抽离代理一些共同的东西，比如调用接口的耗时
为了适应Object实现代理模式，JDK框架中要求
1、实现InvocationHandler接口的一个中介类，并且这个中介类中需要组合一个业务层的实现接口
2、调用Proxy.newProxyInstance()反射一个实现接口的代理类，然后业务层进行调用
