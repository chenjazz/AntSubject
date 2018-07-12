import java.io.*;
import java.nio.charset.Charset;
import java.util.StringTokenizer;

/**
 * @author Jiazhi
 * @since 2018/7/12
 */
public class FileWordCounter {

    public static int count(String filePath, String word) throws IOException {
        long start = System.currentTimeMillis();
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(filePath), Charset.forName("UTF-8")
                ), 5 * 1024 * 1024
        );
        String delim = " ,?.!:'\"";

        String line = "";
        int count = 0;
        while ((line = bufferedReader.readLine()) != null) {
            StringTokenizer tokenizer = new StringTokenizer(line, delim);
            while (tokenizer.hasMoreTokens()) {
                if (tokenizer.equals(word)) {
                    count++;
                }
            }
        }
        System.out.println("耗时：" + (System.currentTimeMillis() - start) / 1000f);
        return count;
    }

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedReader = new BufferedWriter(
//                new OutputStreamWriter(
//                        new FileOutputStream("E:/file.txt"), Charset.forName("UTF-8")
//                )
//        );
//        for (int i = 0; i < 6 * 99_000_0; i++) {
////        for (int i = 0; i < 6; i++) {
//            bufferedReader.newLine();
//            bufferedReader.write("A fox is looking for food. He is very hungry. Now he comes near a wall. The wall is very high. The fox is looking up. He sees a lot of fine grapes on the wall. He says, \"How nice they are! I want to eat them.\" The fox jumps and jumps, but he can’t get the grapes. The fox says,\"I must go now. I don't like those grapes. They are green. They are not good to eat.");
//            bufferedReader.flush();
//        }
//        bufferedReader.close();
        System.out.println(count("E:/file.txt", "he"));


    }
}
