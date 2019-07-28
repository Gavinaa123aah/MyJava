# MyJava
# 1.equals() 和 "=="

    (1)判断两个对象是否相等通常有两种方法"equals()"和"=="；
 
    (2)"=="比较两个对象的地址空间；
 
    (3)所有对象继承Object类,若没有重写了Object类中的"equals()"方法，调用Object中的equals()方法,也是用的"=="
 
    (4)源码如下： 
   
   ```
    public boolean equals(Object obj) {
    return (this == obj);
    }
   ```

# 2.字符串比较相等
    字符串创建方式通常有以下两种：

        (1)String s1 = "hello"

        (2)String s2 = new String("hello")

        第(1)种方式是在常量池创建一个字符串常量，此时如果再创建一个String s3 = "hello",会去常量池寻找相同常量，不会开辟一个新的地址空间。
        
        第(2)种方式是堆中创建地址空间存放，此时如果再创建一个String s4 = new String("hello")会开辟一个新的地址空间存放。

    String类重写了equals()方法，比较的是字符串的内容（将字符串拆程char数组，比较每一个字符内容）

    s1,s3内存地址相等，所以对于s1==s3或s1.equals(s3)返回的都是true

    s2,s4内存地址不相等，内容相等。所以s2==s4返回false,s1==s3返回true

    String类重写了equals()方法源码如下：

```java
    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof String) {
            String anotherString = (String)anObject;
            int n = value.length;
            if (n == anotherString.value.length) {
                char v1[] = value;
                char v2[] = anotherString.value;
                int i = 0;
                while (n-- != 0) {
                    if (v1[i] != v2[i])
                        return false;
                    i++;
                }
                return true;
            }
        }
        return false;
    }
```

# 3.对象比较相等
    （1）equals比较两个对象是否相等，默认使用的是Object类中的equals方法，所以是比较两个对象的地址是否相等。

    （2）如果想比较两个对象的内容是否相等，如：两个Student对象的name是否相等，应该重新equals方法

# 4.hashcode方法
    
    (1)Object中的hashcode()是通过对象的地址生成的
    
    (2)之所以说重写了equals()后应该重写hashcode(), 是在集合的场景下才需要：HashMap/HashTable/Set
 
    (3)集合（HashMap/HashTable/Set）是如何判断两个对象是否重复呢？ 分两步：
        第1步：判断连个对象的hashcode是否相等，若不相等，则两个对象不相等；若相等，则转入2步。
        第2步：判断两个对象用equals运算是否相等，若不相等，则认为两个对象不相等；若相等，则认为两个对象相等

# 5.重写了euqals()就要重写hashcode()方法。why?
    (1)Object中的euqals()和hashcode()是一对。例：new两个对象A.B.若都没有重写，在存入集合的时候，当两个地址计算得到不同的hashcode时，
    存到集合中不同的位置; 当hashcode一样（hash碰撞）时，用equals去比较，会得到false(两个地址不同)，存到集合中的同一位置，用链表链起来。
    
    (2)而当equals被重写,hashcode没有重写会有什么问题呢？比如重写了Student对象中的equals(),比较Student对象的name。此时两个相同name，
    不同的Student对象，equals(）是返回true的。我们希望这两个对象被存在SET集合中只存一个。所以不得不重写hashcode()。若不重写根据
    Object的hashcode()去计算,会将其存储在集合集合散列表的不同位置。违背了我们SET集合中只存一个的意愿
    
# 6.参考
>https://www.cnblogs.com/Qian123/p/5703507.html