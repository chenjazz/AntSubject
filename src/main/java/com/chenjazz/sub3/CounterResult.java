package com.chenjazz.sub3;

/**
 * 封装统计单词的结果
 *
 * @author chenjazz
 * @see FileWordCounter
 * @since 2018/7/14
 */
public class CounterResult {
    /**
     * 单词出现的次数
     */
    private int count;
    /**
     * 统计使用的时间（秒）
     */
    private float useSeconds;

    public CounterResult(int count, float useSeconds) {
        this.count = count;
        this.useSeconds = useSeconds;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public float getUseSeconds() {
        return useSeconds;
    }

    public void setUseSeconds(float useSeconds) {
        this.useSeconds = useSeconds;
    }

    @Override
    public String toString() {
        return "统计数量:" + count + ", 用时:" + useSeconds + "s";
    }
}
