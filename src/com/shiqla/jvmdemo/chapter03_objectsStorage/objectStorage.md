## 对象的存储：
   ###对象的创建方式
    - new
    - class的newInstance(): 反射方式，调用空参构造器，且必须为public
    - Construct的newInstance():采用反射方式，调用构造器实例化,无权限要求
    - 使用clone：不调用构造器，当前类需要实现cloneable接口
    - 反序列化:从文件以及网络读取类信息实例化
    - 第三方库的objenesis:很少使用
   ### 对象创建的步骤
    1 判断对象类是否加载，链接，初始化
    2 为对象分配内存
        计算对象空间大小，然后根据大小分配内存
    3 处理并发安全问题
    4 初始化分配的空间
        属性的默认初始化
    5 设置对象的对象头
        所属类，hashcode,GC信息
    6 执行init方法初始化
        执行显示初始化，包含代码块和类构造器调用
   ### 对象内存布局
    对象头
        运行时元数据
           哈希值，GC分代年龄，锁状态标志，线程持有锁，偏向线程ID,偏向时间戳
        类型指针
           指向元数据instanceclass,确定该对象的所属类型
    实例数据
        真正的有效信息，包含代码中定义的各种类型的字段，包含父类继承的字段
        分配规则：
            相同宽度字段放在一起
            父类的放在子类之前
    对齐填充
   ###对象定位
    通过引用指针，直接定位到堆空间
    对象访问
        句柄访问
            在堆空间维护对象的句柄池，包含数据指针和类型指针
        直接指针
            直接指向堆空间的对象实体