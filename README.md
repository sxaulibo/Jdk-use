# Jdk-use

需求：
使用SAX读取自定义配置的xml文件数据。

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
