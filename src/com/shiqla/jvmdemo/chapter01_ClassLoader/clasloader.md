### **类加载器类型：**
    bootstrap loader: 引导类加载器
        加载Java核心类库（jre/lib/rt） C/C++ 语言来实现的
    extension lodaer: 扩展类加载器；
        间接继承于 classloader ，父类加载器为bootstrap 加载器
    application loader: 应用类加载器；自己写的类都是这个加载器来加载
### **加载过程**
    loading：把class 文件加载进入内存
    linkind阶段：
        verify:验证阶段，检查class 是否为一个正确的符合规范的文件
        prepar: 准备阶段：为变量分配内存并初始化为0值，但是static 的final 变量不会赋值，因为在编译阶段已经赋值
        resolve: 解析阶段 将常量池中的数据为变量分配引用:比如字符串
    init 初始化：
        clinit :只有当本类中含有static修饰符的时候字节码回自动加入此方法：
                类构造器方法,类初始化的时候会调用，会执行所有的static 代码，会按照定义顺序来执行
                如果有父类，那么父类的clinit 必定比子类的clinit 首先执行
    
###  **双亲委派机制**
    Java 类加载是按需加载，到需要用的时候才去加载类对象生成一个class 对象，
    加载采用双亲委派机制，让父类去加载类