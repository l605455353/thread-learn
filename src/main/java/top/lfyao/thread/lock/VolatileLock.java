package top.lfyao.thread.lock;

/**
 * volatile（轻量级锁） :保证内存可见性，防止指令重排 （但是不保证线程操作的原子性）
 * synchronized(重量级）：保证可见性且原子性
 * 轻量级锁消耗较重量级低
 */
public class VolatileLock {
    private static volatile VolatileLock volatileLock;

    private VolatileLock() {
    }

    public VolatileLock getInstance() {
        if (volatileLock == null) {
            synchronized (VolatileLock.class) {
                if (volatileLock==null)volatileLock=new VolatileLock();
            }
        }
        return volatileLock;
    }
}
