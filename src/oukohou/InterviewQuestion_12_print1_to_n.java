package oukohou;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by oukohou on 2017/7/5.
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 * 输入数字n，按序打印1到n的十进制数，如n=3时，输出1,2,...999.
 * <p>
 * tips：
 * n可能很大！
 * 两种方法：
 * 1. 字符串模拟整数加法；
 * 2. 递归调用n个位置上的0-9打印
 */
public class InterviewQuestion_12_print1_to_n {

    public void print_1_to_n(int n) {
        char[] chars = new char[n];
        Arrays.fill(chars, '0');
        while (!increment_1(chars))
            print_chars(chars);
    }

    private boolean increment_1(char[] chars) {
        boolean first_carry_bit = false;
        int sum_of_a_position = 0;
        int position = chars.length - 1;
        sum_of_a_position = Character.getNumericValue(chars[position]) + 1;
        while (sum_of_a_position > 9) { // 进位。
            if (position == 0) {
                first_carry_bit = true;
                break;
            } else {
                chars[position] = (char) ((sum_of_a_position - 10) + 48);
                position = position - 1;
                sum_of_a_position = Character.getNumericValue(chars[position]) + sum_of_a_position - 9;
            }
        }
        chars[position] = (char) (sum_of_a_position + 48);
        return first_carry_bit;
    }

    private void print_chars(char[] chars_to_print) {
        boolean begin = true;
        for (int i = 0; i < chars_to_print.length; i++) {
            if (chars_to_print[i] != '0' && begin == true) {
                begin = false;
            }
            if (!begin)
                System.out.print(String.valueOf(chars_to_print[i]));
        }
    }


    // 递归调用。
    public void print_n_recursively(int n) {
        char[] chars = new char[n];
        Arrays.fill(chars, '0');
        for (int i = 0; i < 10; i++) {
            chars[0] = (char) (i + '0');
            recursive(chars, n, 0);
        }
    }

    private int recursive(char[] chars, int length, int index) {
        if (index == length - 1) { // 最后一个位置， 打印
            print_chars(chars);
            return 1;
        }
        for (int i = 0; i < 10; i++) {
            chars[index + 1] = (char) (i + '0');
            recursive(chars, length, index + 1);
        }
        return 1;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n <= 0) {
            System.out.println(-1);
        } else {
//        new InterviewQuestion_12_print1_to_n().print_1_to_n(n);
            new InterviewQuestion_12_print1_to_n().print_n_recursively(n);
        }
    }
}
