## 并发编程由浅入深系统学习（持续更新中）

> 目录ke在支持md格式文件的软件可以使用中使用
## 目录
- [八种创建线程的方式](#0)
- [重入锁、自旋锁、死锁](#1)
- [单例应用中谈volatile和synchronized区别](#2)
- [Atomic原子操作](#3)
- [手写可重入锁Lock](#4)
- [AQS 重写锁](#5)
- [线程之间通信](#7)
- [ThreadLocal](#8)



## 内容
<h4 id="0" />

1. [继承Thread类（中断线程 和守护线程）](./src/main/java/top/lfyao/thread/threadImplementMethod/MethodOne.java)
2. [实现Runnable接口](./src/main/java/top/lfyao/thread/threadImplementMethod/MethodTwo.java)
3. [匿名内部类的方式](./src/main/java/top/lfyao/thread/threadImplementMethod/MethodThree.java)
4. [带返回值的创建线程方式](./src/main/java/top/lfyao/thread/threadImplementMethod/MethodFour.java)
5. [定时器](./src/main/java/top/lfyao/thread/threadImplementMethod/MethodFive.java)
6. [线程池实现](./src/main/java/top/lfyao/thread/threadImplementMethod/MethodSix.java)
7. [spring方式](./src/main/java/top/lfyao/thread/threadImplementMethod/MethodSeven.java)
8. [Lambda方式](./src/main/java/top/lfyao/thread/threadImplementMethod/MethodEightLambda.java)
- [lambda表达式学习](./src/main/java/top/lfyao/thread/threadImplementMethod/LambdaTest.java)


<h4 id="1" />

- [死锁](./src/main/java/top/lfyao/thread/lock/DeadLock.java)

<span>
windows系统可以通过命令：jconsole 打开查看线程是否变成了死锁
<span/>

<h4 id="2" />

- [单例应用中谈volatile和synchronized区别](./src/main/java/top/lfyao/thread/lock/VolatileLock.java)

<h4 id="3" />

- [Atomic原子操作](./src/main/java/top/lfyao/thread/lock/AtomicOperator.java)

<span>
Atomic<br/>
在多线程环境下，无锁的进行原子操作。<br/>
主要用途：可用于多线程高并发的计数器.
<span/>

<h4 id="4" />

- [手写可重入锁Lock](src/main/java/top/lfyao/thread/lockImplement/MyLock.java)

<h4 id="5" />

- [AQS 重写锁](src/main/java/top/lfyao/thread/lockImplement/MyLock2.java)

<h4 id="7" />

- [线程之间通信](./src/main/java/top/lfyao/thread/threadCommunication/Demo.java)

    [简易版线程池](./src/main/java/top/lfyao/thread/threadCommunication/DatePool2.java)

<span>
1.wait() 和notify()必须放在同步代码块中执行<br/>
2.notify 执行后，必须在此同步代码释放锁以后，叫醒的线程才开始竞争<br/>
<span/>


<h4 id="8" />

- [ThreadLocal](./src/main/java/top/lfyao/thread/threadCommunication/threadLocal/ThreadLocalDemo.java)

<span>
1.ThreadLocalMap内部Entry中key使用的是对ThreadLocal对象的弱引用<br/>
2.ThreadLocalMap里面就会存在key为null但是value不为null的entry项<br/>
3.会发生内存泄露，所以在使用完毕后即使调用remove方法才是解决内存泄露的王道
<span/>
