# 一.说明
项目基于maven构建，需要使用JDK1.8编译运行。

## 题目一
代码是 src/main/com/chenjazz/sub1/Singleton.java，

测试用例在  src/test/com/chenjazz/sub1/SingletonTest.java，
```
//获取线程安全的单实例
Singleton singleton = Singleton.getSingleton();
```


## 题目二
代码是 src/main/com/chenjazz/sub1/AntMinStack.java，

测试用例在  src/test/com/chenjazz/sub1/AntMinStackTest.java，
```
AntMinStack<Integer> stack = new AntMinStack<>();
//压入元素
stack.push(9);
//最小元素
stack.min();
//弹出元素
stack.pop();
```

## 题目三
代码是 src/main/com/chenjazz/sub1/FileWordCounter.java，src/main/com/chenjazz/sub1/CounterResult.java，

测试用例在  src/test/com/chenjazz/sub1/FileWordCounterTest.java，
```
CounterResult result = FileWordCounter.count(<文件路径>, <需要统计的单词>);
result.getCount(); //获取单词数量
result.getUseSeconds(); //获取用时
```

## 题目四
代码是 src/main/com/chenjazz/sub1/Calculator.java，

测试用例在  src/test/com/chenjazz/sub1/CalculatorTest.java，
```
Calculator.calculate("3*0+3+8+9*1"); //获取计算结果
```

---

# 二.原题

## 题目一
>提供一个懒汉模式的单实例类实现。
>要求： 1.考虑线程安全。 2.提供测试代码，测试线程安全性。



## 题目二：
>设计含最小函数min()、pop()、push()的栈AntMinStack
>要求：
>1.AntMinStack实现测试，满足栈特性
>2.要求min、push、pop、的时间复杂度都是O(1)




## 题目三：
>JAVA中对文件读取的效率会受到文件大小本身的影响，本题目要求能够对于文本文件进行读取，在保证读取效率的同时，要求内存不能溢出。
>要求：
>输入一个本地文本文件地址，文本文件大小为2G,文本编码类型为utf-8。
读取该文本文件中出现特定单词的数量
把文本部分文件读取到内存中后，即可释放内存，并统计特定单词出现次数和总时间耗时
尽量减低字符统计耗时。




## 题目四：
>设计数据结构与算法，计算算数表达式，需要支持基本计算，加减乘除，满足计算优先级例如输入 3*0+3+8+9*1 输出20。括号，支持括号，例如输入 3+（3-0）*2 输出 9假设所有的数字均为整数，无需考虑精度问题。
>要求：
>1.代码结构清晰
>2.数据结构选型合理。