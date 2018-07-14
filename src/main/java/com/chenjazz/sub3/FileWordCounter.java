package com.chenjazz.sub3;

import org.junit.Test;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.Random;

/**
 * @author chenjazz
 * @since 2018/7/12
 */
public class FileWordCounter {
    /**
     * 统计大文件（大小<2G）特定单词出现次数和总时间耗时
     *
     * @param filePath 文件的绝对路径
     * @param word     需要统计的单词
     * @return 特定单词出现次数
     * @throws IOException
     */
    public static CounterResult count(String filePath, String word) throws IOException {
        long start = System.currentTimeMillis();
        int count = 0;
        RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "r");
        FileChannel channel = randomAccessFile.getChannel();
        MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, randomAccessFile.length());
        //每次读取10M
        int size = 10 * 1024 * 1024;
        byte[] data;
        int capacity = mappedByteBuffer.capacity();

        //用来记录每轮统计的末尾字符串
        String endStr = "";

        for (int offset = 0; offset < capacity; offset += size) {//offset偏移量
            //每次读取放入byte数组
            if (capacity - offset >= size) {
                data = new byte[size];
                for (int i = 0; i < size; i++) {
                    data[i] = mappedByteBuffer.get(offset + i);
                }
            } else {
                //最后一次读取
                data = new byte[capacity - offset];
                for (int i = 0; i < capacity - offset; i++) {
                    data[i] = mappedByteBuffer.get(offset + i);
                }
            }
            //读取到的内容组成字符串
            String bufferStr = new String(data, Charset.forName("UTF-8"));
            //使用标点符号和空格进行分割
            String[] strArray = bufferStr.split("[\\pP\\s]");
            //进行数量统计，排除最后一个
            for (int i = 0; i < strArray.length - 1; i++) {
                if (i == 0) {
                    for (String s : (endStr + strArray[i]).split("[\\pP\\s]")) {
                        if (word.equals(s)) {
                            count++;
                        }
                    }
                } else {
                    if (word.equals(strArray[i])) {
                        count++;
                    }
                }
            }
            //最后一个字符串的索引
            int lastIndex = bufferStr.lastIndexOf(strArray[strArray.length - 1]);
            //进行截取,以便下一轮使用
            endStr = bufferStr.substring(lastIndex);
        }

        //统计最后一轮 的末尾字符串
        if (word.equals(endStr)) {
            count++;
        }

        channel.close();
        randomAccessFile.close();

        return new CounterResult(count, (System.currentTimeMillis() - start) / 1000f);
    }
}
