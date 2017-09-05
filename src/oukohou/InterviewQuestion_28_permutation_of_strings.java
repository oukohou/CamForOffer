package oukohou;

/**
 * Created by oukohou on 2017/9/4.
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 * problem：字符串的全排列输出
 * tips: 动态规划，递归输出。
 * 首先求所有可能在第一位置的字符，即将第一位与后面所有字符交换，然后是子问题。
 */
public class InterviewQuestion_28_permutation_of_strings {

    public void permutateString(char[] chars, int index) {
        if (index == chars.length - 1) {
            display(chars);
            return;
        }

        char temp = chars[index];
        for (int i = index; i < chars.length; i++) {
            // i 从index开始，因为本身不交换的时候，也是一种
            chars[index] = chars[i];
            chars[i] = temp;

            permutateString(chars, index + 1);

            chars[i] = chars[index];
            chars[index] = temp;
        }
    }

    public void display(char[] chars) {
        for (char ch :
                chars) {
            System.out.print(ch);
        }
        System.out.println();
    }


    public static void main(String[] args) {
        StringBuilder string = new StringBuilder("abc");
        char[] chars = new char[string.length()];
        string.getChars(0, string.length(), chars, 0);
        new InterviewQuestion_28_permutation_of_strings().permutateString(chars, 0);

    }
}
