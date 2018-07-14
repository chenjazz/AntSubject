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

    @Override
    public String toString() {
        return "CounterResult{" +
                "count:" + count +
                ", useSeconds:" + useSeconds +
                "s}";
    }
}
