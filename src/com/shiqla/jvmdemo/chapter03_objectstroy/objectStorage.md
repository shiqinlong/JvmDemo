#### 对象的创建方式：
   - new
   - class的newInstance(): 反射方式，调用空参构造器，切为public
   - Construct的newInstance():采用反射方式，调用构造器实例化,无权限要求
   - 使用clone：不调用构造器，当前类需要实现cloneable接口
   - 反序列化:从文件以及网络读取类信息实例化
   - 第三方库的objenesis