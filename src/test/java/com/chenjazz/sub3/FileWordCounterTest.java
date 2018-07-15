package com.chenjazz.sub3;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author chenjazz
 * @since 2018/7/12
 */
public class FileWordCounterTest {
    /**
     * 测试统计大文本中特定单词出现次数
     */
    @Test
    public void testCount() {
        //大文件路径
        String filePath = "E:\\file.txt";
        //统计的单词
        String word = "grapes";
        //单词应该出现次数
        int count = 801_2481;

        CounterResult counterResult = FileWordCounter.count(filePath, word);

        System.out.println(counterResult);
        Assert.assertEquals(counterResult.getCount(), count);
    }

//    /**
//     * 生成一个大文件
//     *
//     * @throws IOException
//     */
//    @Test
//    public void generateBigFile() throws IOException {
//        BufferedWriter bufferedReader = new BufferedWriter(
//                new OutputStreamWriter(
//                        new FileOutputStream("E:/file.txt"), Charset.forName("UTF-8")
//                )
//        );
//        for (int i = 0; i < COUNT; i++) {
//            bufferedReader.write(
//                    "A fox is looking for food. He is very hungry. Now he comes near a wall. The wall is very high. " +
//                            "The fox is looking up. He sees a lot of fine grapes on the wall. He says, \"How nice they are!\""
//            );
//            Random random = new Random();
//            int rand = random.nextInt();
//            if (rand > 5000) {
//                bufferedReader.write("food. He is.is very hungry. Now he comes nea....''");
//            } else {
//                bufferedReader.write(".....\"food!Now he comes near a wal. He is.....''\"");
//            }
//            bufferedReader.flush();
//        }
//        bufferedReader.close();
//    }
}
