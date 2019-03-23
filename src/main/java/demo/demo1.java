package demo;



import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author : silent【agzhchren@gmail.com】
 * @Title: demo1
 * @Description: TODO
 * @date 2019-01-31  23:16
 */

public class demo1 {


    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        LinkedList<String> linkedList = new LinkedList<>();
        ArrayList<String> arrayList = new ArrayList<>();

        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("sssss");

        String str = "55555";
        Class cls = str.getClass();
        Field field = cls.getDeclaredField("value");
        field.setAccessible(true);
        byte[] newValue = (byte[]) field.get(str);
        newValue[2] = '6';
        //System.out.println(str);

        String aa = "sss";
        String aaa = "sss";

        System.out.println();



        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();


    }

}
