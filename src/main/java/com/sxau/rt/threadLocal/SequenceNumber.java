package com.sxau.rt.threadLocal;

/**
 * 思考：Spring通过各种模板类降低了开发者使用各种数据持久化技术的难题。这些模板类都是线程安全的，也就是说，
 * 多个DAO可以复用同一个模板实例而不会发生冲突。虽然模板类访问底层数据，根据持久化技术的不同，模板类需要绑定数据连接或会话的资源。
 * 但这些资源本身是非线程安全的。也就是说它们不能在同一时刻被多个线程共享。虽然模板类通过资源池获取数据连接或会话，但资源池本身解决的是数据连接
 * 或会话的缓存问题，并非数据连接或会话的线程安全问题。
 * 按照传统经验，如果某个对象是非线程安全的，在多线程环境下，对对象的访问必须采用synchronize进行线程同步。但模板类并未采用线程同步机制，因为
 * 线程同步会降低并发性，影响系统性能。此外，通过代码同步解决线程安全的挑战性很大，可能会增加几倍的实现难度。
 * <p>
 * 那么，模板类究竟仰仗何种"魔法神功"，可以在无需线程同步的情况下就化解线程安全的难题呢？答案就是 ThreadLocal!
 * 无需线程同步的情况下化解线程安全的难题
 * ThreadLocal在Spring中发挥着重要的作用，在管理request作用域的Bean、事务管理、任务调度、AOP等模块中都会出现它的身影。
 * 要想了解Spring事务管理的底层技术，ThreadLocal是必须攻克的"山头堡垒"。
 * <p>
 * <p>
 * <p>
 * 结论：
 * 每个线程所产生的序号虽然都共享同一个SequenceNumber实例，但他们并没有互相干扰，而是产生独立的序号
 * 这是因为通过ThreadLocal为每个线程提供了单独的副本。
 */
public class SequenceNumber {
    private static ThreadLocal<Integer> seqNum = ThreadLocal.withInitial(() -> 0);

    /**
     * 获取下一个序列值
     */
    public int getNextNum() {
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }

    public static void main(String[] args) {
        SequenceNumber sn = new SequenceNumber();

        TestClient t1 = new TestClient(sn);
        TestClient t2 = new TestClient(sn);
        TestClient t3 = new TestClient(sn);
        t1.start();
        t2.start();
        t3.start();
    }

    private static class TestClient extends Thread {
        private SequenceNumber sn;

        public TestClient(SequenceNumber sn) {
            this.sn = sn;
        }

        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println("thread[" + Thread.currentThread().getName() +
                        "]     sn[" + sn.getNextNum() + "]");
            }
        }
    }
}
