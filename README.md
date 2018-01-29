## 并发编程由浅入深系统学习（持续更新中）

> 目录ke在支持md格式文件的软件可以使用中使用
## 目录
- [八种创建线程的方式](#0)
- [重入锁、自旋锁、死锁](#1)
- [单例应用中谈volatile和synchronized区别](#2)
- [Atomic原子操作](#3)
- [手写可重入锁Lock](#4)
- [AQS 重写锁](#5)



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

- [手写可重入锁Lock](./src/main/java/top/lfyao/thread/LockImplement/MyLock.java)

<h4 id="5" />

- [AQS 重写锁](./src/main/java/top/lfyao/thread/LockImplement/MyLock2.java)



