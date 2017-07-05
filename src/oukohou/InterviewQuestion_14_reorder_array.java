package oukohou;

import java.util.Arrays;

/**
 * Created by oukohou on 2017/8/22.
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 */
public class InterviewQuestion_14_reorder_array {

    public void reorder_array(int[] array, int begin, int end) {
        if (begin > end || begin > array.length - 1 || end > array.length - 1) {
            System.out.println("error params detected, try again...");
        } else {
            while (begin < end) {
                while (begin < end && !can_mod_3(array[begin]))
                    begin++;
                while (begin < end && can_mod_3(array[end]))
                    end--;
                int temp = array[begin];
                array[begin] = array[end];
                array[end] = temp;
                begin++;
                end--;
            }
        }

    }

    private boolean is_even(int num) {
        return num % 2 == 0;
    }

    private boolean can_mod_3(int num) {
        return num % 3 == 0;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 12, 13};
        new InterviewQuestion_14_reorder_array().reorder_array(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));

    }
}
