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
 ####intern()使用
    new String().intern();
 ####StringTable垃圾回收
 #### G1 String 去重操作