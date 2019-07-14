package offer;

public class Singleton {

    // 这里必须要加上volatile，原因是new Instance不是原子操作：
    // (1) 分配内存空间 (2) 初始化Singleton对象 (3) 将创建的Singleton对象的内存地址赋值给instance
    // 不加volatile，可能由于指令重排序，导致上述步骤变成1-3-2
    // 线程A在执行第5行代码时，B线程进来，而此时A执行了1和3，没有执行2，此时B线程判断s不为null直接返回一个未初始化的对象，就会出现问题
    private volatile static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {// 1
        if (instance == null) {//2
            synchronized (Singleton.class) {//3
                if (instance == null) {//4
                    instance = new Singleton();//5
                }
            }
        }
        return instance;
    }
}
