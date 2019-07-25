# MyJava
#1.equals() 和 "=="

 (1)判断两个对象是否相等通常有两种方法"equals()"和"=="；
 
 (2)"=="比较两个对象的地址空间；
 
 (3)所有对象继承Object类,若没有重写了Object类中的"equals()"方法，调用Object中的equals()方法,也是用的"=="
 
 (4)源码如下： 
   ```
    public boolean equals(Object obj) {
    return (this == obj);
    }
   ```

#2.字符串比较相等
字符串创建方式通常有以下两种：

(1)String s1 = "hello"

(2)String s2 = new String("hello")

第(1)种方式是在常量池创建一个字符串常量，此时如果再创建一个String s3 = "hello",会去常量池寻找相同常量，不会开辟一个新的地址空间。
第(2)种方式是堆中创建地址空间存放，此时如果再创建一个String s4 = new String("hello")会开辟一个新的地址空间存放。

String类重写了equals()方法，比较的是字符串的内容（将字符串拆程char数组，比较每一个字符内容）

s1,s3内存地址相等，所以对于s1==s3或s1.equals(s3)返回的都是true

s2,s4内存地址不相等，内容相等。所以s2==s4返回false,s1==s3返回true


```
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

#3.对象比较相等(待更新)

#4.hashcode方法（待更新）