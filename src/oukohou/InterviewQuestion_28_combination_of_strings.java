package oukohou;

/**
 * Created by oukohou on 2017/9/5.
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 */
public class InterviewQuestion_28_combination_of_strings {

    public void get_combination(char[] chars) {

        String string = "";
        for (int i = 1; i <= chars.length; i++) {
            get_combination(chars, 0, i, string);
        }
    }

    public void get_combination(char[] chars, int index, int length, String string) {
        if (string.length() == length) {
            System.out.println(string);
            return;
        }
        if (index == chars.length) {
            return;
        }

        get_combination(chars, index + 1, length, string);

        // 此处就是要生成不一样的多个string实例对象，不可用stringbuilder！
        string = string + chars[index];
        get_combination(chars, index + 1, length, string);
    }


    public static void main(String[] args) {
        String s = "abc";
        char[] chars = s.toCharArray();
        new InterviewQuestion_28_combination_of_strings().get_combination(chars);

    }
}
