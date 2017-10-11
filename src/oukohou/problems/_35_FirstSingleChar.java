package oukohou.problems;

/**
 * Created by oukohou on 2017/10/11.
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 * problem:
 * 查找字符串中第一个只出现一次的字符；
 * solution:
 * 存储每个字符的出现次数，然后遍历字符串找到次数为1的第一个字符输出即可。字符是8位，故需要256长度的计数数组。
 */
public class _35_FirstSingleChar {

    public static char findFirstSingleChar(String string) {
        if ("".equals(string)) {
            return '\0';
        }

        int[] count = new int[256];
        for (char ch :
                string.toCharArray()) {
            count[(int) (ch)]++;
        }

        for (char ch :
                string.toCharArray()) {
            if (count[(int) ch] == 1) {
                return ch;
            }
        }
        return '\0';
    }


    public static void main(String[] args) {
        String string = "123456";
        char result = findFirstSingleChar(string);
        if (result == '\0') {
            System.out.println("illegal input...");
        } else System.out.println(result);
    }
}
