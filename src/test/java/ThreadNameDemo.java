public class ThreadNameDemo {

    static class RunTarget implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                ThreadUtil.sleepMilliSeconds(500);

                String cft = "[" + Thread.currentThread().getName() + "]" + ":" + "线程执行轮次:" + i;

                new Thread(() -> {
                    synchronized (System.out) {
                        System.out.println(cft);
                    }

                }).start();

            }
        }
    }

    public static void main(String[] args) {

        RunTarget target = new RunTarget();

        new Thread(target).start();

        new Thread(target).start();

        new Thread(target).start();

        new Thread(target, "手动命名线程-A").start();

        new Thread(target, "手动命名线程-B").start();

        ThreadUtil.sleepMilliSeconds(Integer.MAX_VALUE);//主线程不能结束

    }


}
