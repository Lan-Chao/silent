package demo;



import java.lang.reflect.Field;

/**
 * @author : silent【agzhchren@gmail.com】
 * @Title: ThreadLocalDemo1
 * @Description: TODO
 * @date 2019-03-23  11:24
 */

public class ThreadLocalDemo1 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Object[] entrys = getEntrys();
        System.out.println("初始化threadLocalMap的entrys数量为：" + getSize(entrys));

        ThreadLocal<String> userId = ThreadLocal.withInitial(() -> "init id");
        userId.set("id in main thread");

        System.out.println("设置userId后threadLocalMap的entrys数量为：" + getSize(entrys));

        // 失去Threadlocal对象的强引用，并且尝试调用gc回收
        //userId = null;
        userId.remove();
        System.gc();

        System.out.println("userId置null后threadLocalMap的entrys数量为：" + getSize(entrys));
    }
    // 获得数组中非null元素个数
    private static int getSize(Object[] objects) {
        int count = 0;
        for (Object object : objects) {
            if (object != null) {
                count++;
            }
        }
        return count;
    }
    // 通过反射获得ThreadLocalMap中的底层数组
    private static Object[] getEntrys() throws NoSuchFieldException, IllegalAccessException {
        Thread mainThread = Thread.currentThread();
        Field threadLocals = Thread.class.getDeclaredField("threadLocals");
        threadLocals.setAccessible(true);
        Object threadLocalMap = threadLocals.get(mainThread);
        Class<?>[] declaredClasses = ThreadLocal.class.getDeclaredClasses();
        Field table = declaredClasses[0].getDeclaredField("table");

        table.setAccessible(true);
        return (Object[]) table.get(threadLocalMap);
    }
}
