import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Jiazhi
 * @since 2018/7/12
 */
public class SingletonTest {
    /**
     * 测试Singleton类线程安全性
     */
    @Test
    public void testSync()   {
        int threadSize = 100;
        //保存生成所有的实例的hashCode(需要同步类)
        ConcurrentHashMap<Integer, Object> hashCodeMap = new ConcurrentHashMap<>();
        //保证所有线程一起执行
        CountDownLatch countDownLatch = new CountDownLatch(1);
        //保证所有线程都把对象的hashCode放入hashCodeSet后执行断言
        CountDownLatch countDownLatch2 = new CountDownLatch(threadSize);

        ExecutorService service = Executors.newFixedThreadPool(threadSize);
        for (int i = 0; i < threadSize; i++) {
            service.submit(() -> {
                try {
                    System.out.println(Thread.currentThread() + "等待");
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Singleton singleton = Singleton.getSingleton();
//                Singleton singleton = Singleton.getNotThreadSafeSingleton();
                hashCodeMap.put(singleton.hashCode(), "");
                System.out.println(Thread.currentThread() + "执行完毕");
                countDownLatch2.countDown();
            });
        }
        //休眠5s,让所有线程进入等待状态
        //TODO 需要改进
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        countDownLatch.countDown();
        System.out.println("-----------------------");

        try {
            countDownLatch2.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(hashCodeMap.keySet());
        Assert.assertTrue(
                "hashCode长度：" + hashCodeMap.size() + ",元素：" + hashCodeMap.keySet(),
                hashCodeMap.size() == 1
        );
    }
}
