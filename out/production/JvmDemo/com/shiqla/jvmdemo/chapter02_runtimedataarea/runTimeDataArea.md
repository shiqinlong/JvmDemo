## 运行时数据区
    线程栈，本地方法区，程序计数器 和线程绑定，每个线程独享
   #### 方法区（非堆空间）
        jdk 1.8 之后方法区改为matespace 区，使用直接物理内存
        metaspace 具体分为：常量池，代码区
   #### 堆区 heap 对于内存管理主要在heap区完成,垃圾回收主要发生在堆区
        Young区：
        old区：
   #### 线程栈 thread stack
   #### 本地方法栈 native function stack
   #### 程序计数器 program counter
    存储指向下一个指令的地址和当前线程绑定，线程结束也会被销毁
    
   