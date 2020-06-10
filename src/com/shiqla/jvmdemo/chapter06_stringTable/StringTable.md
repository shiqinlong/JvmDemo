##StringTable 
 ####基本特性
    字符串,具有不可变特性
    final声明，不可被继承
    JDK8 使用 final char[] value 来表示
    JDK9 使用byte[]表示
    字符串不会存储相同的常量
    String对象都存放在StringTable 内部，使用HashTable 来实现，JDK7以上大小是60013,
    -XX:StringTableSize 用来设置大小，在JDK 8 最小值为1009
 ####内存分配
    String str = "test str"; 会直接存储在常量池中
    JDK8 中字符串常量存放在堆空间中
   
 ####基本操作
 ####拼接操作
     如果使用字符串（或者常量引用）拼接来构建字符串则直接存放在字符串常量池中，编译器优化
     如果字符串拼接前后出现变量，则需要在堆空间使用Stringbuilder 去拼接字符串,append()，内容为拼接的结果
 ####intern()使用
    new String().intern();
    入池操作，判断字符串常量池是否存在字面值，
    JDK 1.7 + 
     如果池中存在，则不会放入，直接放回池中对象的地址
     如果池中不存在，则会把对象引用放入池中，并返回对象地址。
    对于程序中大量存在的字符串，尤其有很多重复字符串，最好使用intern() 方式来节省存储空间
 ####StringTable垃圾回收
    
    
 #### G1 String 去重操作