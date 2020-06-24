##Java Concurrent Code
 #### Volatile 内存可见性
    使用此关键字修饰的变量，操作会在主存中进行即无线程的缓存，直接读取主存的值，在修改之后直接刷新主存的值
    不具备互斥性
    无法保证原子性
 #### 原子变量，可以保证线程安全
    采用 volatile 保证内存可见性
    采用 Cas 算法保证原子性，
 ####ConcurrentHashMap 线程安全的 hashmap
 #### 创建线程方式
    继承Thread类 重写run 方法
    实现runnable 接口，实现run 方法
    实现callable 接口，实现call方法
        有返回值，切可以跑出异常
    线程池创建线程