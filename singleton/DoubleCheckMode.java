package singleton;

/**
 * 因为同步锁的机制，多个线程获取类实例对象会排队等待获取锁，这样是没必要的，
 * 因为大多数情况下类实例对象都已经创建成功了，所以不用进入加锁的代码块
 *
 *
 * 多线程的单例模式，使用双重校验机制
 */
public class DoubleCheckMode {

    private volatile static DoubleCheckMode sDoubleCheckMode ;

    public DoubleCheckMode() {
        System.out.println(" created " + getClass().getSimpleName());
    }

    public static DoubleCheckMode getInstance() {
        if (sDoubleCheckMode == null)
            synchronized (DoubleCheckMode.class) {
                if (sDoubleCheckMode == null) {
                    sDoubleCheckMode = new DoubleCheckMode();
                }
            }
        return sDoubleCheckMode;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread() {
                @Override
                public void run() {
                    super.run();
                    System.out.println("thread" + getId());
                    DoubleCheckMode.getInstance();
                }
            }.start();
        }
    }

}