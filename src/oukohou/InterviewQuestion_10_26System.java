package oukohou;

import java.util.ArrayList;

/**
 * Created by oukohou on 17-6-23.
 * <Todo> :
 */

public class InterviewQuestion_10_26System {


    public long compute_decimal(String string) {
        if (string.length() == 0) {
            System.out.println("got null string!");
            return -1;
        }
        char[] stringList = string.toCharArray();

        for (char ch :
                stringList) {
            if ((int) ch > 90 || (int) ch < 65) {
                System.out.println("got illegal string!must be A-Z");
                return -1;

            }
        }

        ArrayList<Character> alpahList = get_alpha();

        long result = 0;
        for (int i = 0; i < stringList.length; i++) {
            char ch = stringList[i];
            int index = alpahList.indexOf(ch) + 1;
            int position = stringList.length - i - 1;
            result += index * Math.pow(26, position);
        }
        return result;

    }


    private ArrayList<Character> get_alpha() {
        ArrayList<Character> arrayList = new ArrayList<>();
        char A = 'A';
        for (int i = 0; i < 26; i++) {
            arrayList.add(A);
            A++;
        }
//        String alphaList =String.valueOf(stringBuffer);
        return arrayList;
    }

    public static void main(String[] args) {
        String string_1 = "ABC";
        String string_2 = "EREWFD";
//        System.out.println(((int)'Z'));
//        System.out.println(((int)'A'));
        System.out.println(new InterviewQuestion_10_26System().compute_decimal(string_2));
    }
}
