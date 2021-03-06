## 运行时数据区
    线程栈，本地方法区，程序计数器 和线程绑定，每个线程独享
   #### 方法区（非堆空间,metasapce）也存在垃圾回收机制，由FULLGC 回收垃圾
        jdk 1.8 之后方法区改为matespace 区，使用直接物理内存
        -XX:MetaSapceXX 设置元空间默认大小
        -XX:MaxMetaSpaceXX 设置元空间最大大小
        1.8 之后字符串常量池是放在堆空间，改进GC 效率
        1.8 之后静态变量也存放在堆区
   #### 堆区 heap 对于内存管理主要在heap区完成,垃圾回收主要发生在堆区（JDK 1.8之后）
        -Xms xx 设置堆空间初始大小 -Xmx 设置堆空间最大值
        一般会设置为一样大小，防止内存频繁扩容
        -XX:+PrintGCDetails 输出GC 的相关信息
        -XX:NewRatio 用来分配老年代和新生代的比率 一般为1:2 的关系
        如果不设置任何参数，初始大小为物理内存的1/64,最大大小为物理内存的1/4
        堆区主要管存储（主要包含对象类型）
        Young区：
            包含eden,su01 su02 ,在实际内存分配中，su01 su02只能二选一，并且2个su区一样大
            eden 和su01 ,su02 可以设置比率,6:1:1 
            每次复制之后，对于幸存者区，谁空谁是to 区
            几乎所有的对象都是在eden 被创建的,绝大部分的对象销毁也是在eden 区发生.
            -Xmn 设置新生代的大小
        old区：
            对于经过GC后的eden区，还是放不下的超大对象，会直接存放在old区
            old区会执行major GC,如果执行之后内存还是不足则直接抛出oom异常
            old区的major GC 效率比young 区的 minor GC 低10倍以上.
        元空间（metaspace）:
        
        full GC, 会回收young，old，metaspace,避免去执行，非常影响性能,
        System.GC 会建议系统去执行full gc.
        堆区的分代思想：
            更精细化的进行内存管理，根据对象的使用程度进行分区,提高内存管理效率
        内存分配策略：
            一般对象分配到eden区，
            对于大对象(经过minor GC后eden空间还是不够)可以直接存在在old 区（尽量避免过多的出现大对象）
            长期存活的对象分配到old区
            对于经过逃逸分析后，一个对象并没有逃逸出方法的话，可以直接在栈上分配，此对象也不会被GC 回收，会根据栈帧消亡而释放栈空间。
            逃逸分析：
                分析在方法中构建的对象的作用域，如果此对象的作用空间只存在此方法内部，则没有发生逃逸。
                如果此对象会被方法外医用，则发生逃逸。
                对于发生没有发生逃逸的对象，则可以直接在栈上分配。
                可以做标量替换，栈上分配，锁消除做代码优化
        TLAB: (thread local  buffer)线程私有空间，有线分配，默认1%的eden区
        开发中能使用局部变量，就不要再方法外定义
   #### JAVA 虚拟机栈 
       虚拟机启动参数 -Xss（stack size ,栈大小） 设置最大栈大小:-Xss1024K
       有点容易跨平台，但是相较于寄存器性能较慢
       栈区主要管运行(也存储基本类型的局部变量)
       栈帧：栈的最小存储单位,一个正在运行的方法就是一个栈帧，一个线程内，一个时间段内只能执行一个栈帧
            局部变量表：local variables table
                定义为一个数字数组，主要存储方法参数和定义在方法体内部的局部变量
                包含基本类型，对象引用,以及返回地址,在编译期都确定的类型
                不存在线程安全问题
                需要的容量大小在编译器决定，保存在方法的code中 Maximun local variables
                最基本的存储单元成为 slot,32位的类型占用一个slot ，64位的类型占用2个slot(long,double)，引用对象也占用一个slot 
                当前的栈帧如果由构造方法或者实例方法创建，那么局部变量表会保存this对象到index0.
           操作数栈： (表达式栈)
                使用数组实现,操作数栈大小也是编译期确定
                保存计算结果，以及临时存储计算的中间变量
           动态链接表：（指向运行时常量池的方法引用）
                在编译期保存的符号引用，在类加载之后的linking 阶段里面的resolve阶段会解析符号引用，转为直接引用
                最终的对象都存储在运行时常量池（线程共享）
           返回地址：
           额外的附加信息:
           
        栈不存在垃圾回收机制
        栈中主要的异常：
            Java栈可以是动态的和固定的，如果是固定的会抛出stackoverflow,栈区溢出，一般由 递归和循环调用引起
            如果是动态扩展当内存不足的时候会抛出oom(outofmemoryerror)
       
   #### 本地方法栈 native function stack (hotspot 是存在本地方法栈，其他虚拟机不一定存在)
        采用native 修饰的方式，一般是直接调用系统接口来实现的一些方法
        与java环境外交互
        与操作系统交互
        sun`s java
        内存溢出和虚拟机栈相同，也包含stackoverflow 以及oom,
   #### 程序计数器 program counter
        存储指向下一个指令的地址和当前线程绑定，线程结束也会被销毁
   #### 变量的分类：
            按照数据类型分类：
                基本数据类型：
                引用数据类型
            按照定位的位置：
                成员：
                    可以分为类变量（静态变量），在类加载的linking阶段的prepare 阶段进行默认初始化，然后在执行clinit进行显示的赋值
                    实例变量（非静态）,在构建实例的时候使用 init 方法来进行默认赋值
                局部变量：
                    方法内部的变量，使用之前一定要显示的初始化
   #### 栈顶缓存技术
            使用CPU 的寄存器来缓存栈顶元素，比直接读取内存速度快很多     
   
         
    
   