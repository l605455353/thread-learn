package top.lfyao.thread.threadCommunication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 版本二：手写一个数据库连接池
 *
 * @author: mengJiangLi
 * @create: 2018-02-06 09:53
 **/
public class DatePool2 {
    private LinkedList<Connection> pool = new LinkedList();
    private static final int INIT_CONNECTIONS = 10;

    private static final String DRIVER_CLASS = "";

    private static final String USER = "";

    private static final String PASSWORD = "";

    private static final String URL = "";
    private Lock lock = new ReentrantLock();
    private Condition addCondition = lock.newCondition();


    static {
        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public DatePool2() {
        try {
            for (int i = 0; i < INIT_CONNECTIONS; i++) {
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                pool.addLast(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {

        Connection connection = null;
        lock.lock();
        try {
            try {

                while (pool.size() <= 0) addCondition.await();

                if (!pool.isEmpty()) connection = pool.removeFirst();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return connection;
        } finally {
            lock.unlock();
        }

    }

    public void release(Connection connection) {
        lock.lock();
        try {
            pool.addLast(connection);
            addCondition.signal();
        } finally {
            lock.unlock();
        }

    }
}
