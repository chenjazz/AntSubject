package com.chenjazz.sub1;

/**
 * 懒汉模式的单实例类实现 (线程安全)。
 *
 * @author chenjazz
 * @since 2018/7/12
 */
public class Singleton {
    private static Singleton singleton = null;

    private Singleton() {
    }

    /**
     * 获取线程安全的单实例
     *
     * @return Singleton实例
     */
    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    /**
     * 获取非线程安全的单实例
     * 用于测试
     *
     * @return Singleton实例
     */
    @Deprecated
    public static Singleton getNotThreadSafeSingleton() {

        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}
