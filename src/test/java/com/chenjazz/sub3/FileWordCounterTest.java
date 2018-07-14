package com.chenjazz.sub3;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Random;

/**
 * @author chenjazz
 * @since 2018/7/12
 */
public class FileWordCounterTest {
    /**
     * 生成单词的数量
     */
    private static final int COUNT = 801_2481;

    @Test
    public void testCount() {
        CounterResult counterResult;
        try {
            counterResult = FileWordCounter.count("E:\\file.txt", "grapes");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("count*************" + counterResult);
        Assert.assertEquals(counterResult.getCount(), COUNT);
    }

    /**
     * 生成一个大文件
     *
     * @throws IOException
     */
    @Test
    public void generateBigFile() throws IOException {
        BufferedWriter bufferedReader = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream("E:/file.txt"), Charset.forName("UTF-8")
                )
        );
        for (int i = 0; i < COUNT; i++) {
            bufferedReader.write(
                    "A fox is looking for food. He is very hungry. Now he comes near a wall. The wall is very high. " +
                            "The fox is looking up. He sees a lot of fine grapes on the wall. He says, \"How nice they are!\""
            );
            Random random = new Random();
            int rand = random.nextInt();
            if (rand > 5000) {
                bufferedReader.write("food. He is.is very hungry. Now he comes nea....''");
            } else {
                bufferedReader.write(".....\"food!Now he comes near a wal. He is.....''\"");
            }
            bufferedReader.flush();
        }
        bufferedReader.close();
    }
}
