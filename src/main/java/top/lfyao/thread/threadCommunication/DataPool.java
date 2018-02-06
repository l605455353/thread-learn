package top.lfyao.thread.threadCommunication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * 手写一个数据库连接池
 *
 * @author: mengJiangLi
 * @create: 2018-02-05 20:32
 **/
public class DataPool {

    private LinkedList<Connection> pool = new LinkedList();
    private static final int INIT_CONNECTIONS = 10;

    private static final String DRIVER_CLASS = "";

    private static final String USER = "";

    private static final String PASSWORD = "";

    private static final String URL = "";

    static {
        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public DataPool() {
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
        Connection connection=null;
        synchronized (pool) {
            while (pool.size() <= 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (!pool.isEmpty()) connection=pool.removeFirst();
        }
        return connection;
    }

    public void release(Connection connection) {
        if (connection != null) {
            synchronized (pool) {
                pool.addLast(connection);
                notifyAll();
            }
        }
    }
}
