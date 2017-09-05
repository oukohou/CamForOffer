package oukohou.problems;

/**
 * Created by oukohou on 2017/9/5.
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 */
public class _29_numberMoreThanHalf {

    public static int findMostFrequentNumebr(int[] ints, int start, int end) {
        if (ints.length < 2) {
            return ints[0];
        }

        int result = -1;
        int temp = ints[start];
        int start_temp = start;
        int end_temp = end;

        while (start < end) {
            while (start < end && ints[end] >= temp) end--;
            ints[start] = ints[end];

            while (start < end && ints[start] <= temp) start++;
            ints[end] = ints[start];
        }

        if (start == ((ints.length) / 2)) {
            if (isMoreThanHalf(ints, temp))
                return temp;
            else return -1;
        } else {
            ints[start] = temp;
            if (start < ints.length / 2) {
                result = findMostFrequentNumebr(ints, start + 1, end_temp);
            } else {
                result = findMostFrequentNumebr(ints, start_temp, start - 1);
            }
        }
        return result;
    }

    public static boolean isMoreThanHalf(int[] ints, int number) {
        int counter = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == number)
                counter++;
        }
        return counter * 2 > ints.length;
    }

    public static int findUseAnotherMethod(int[] ints) {
        int temp = ints[0];
        int counter = 0;
        for (int i = 0; i < ints.length; i++) {
            if (temp == ints[i]) {
                counter++;
            } else {
                if (counter > 0) {
                    counter--;
                } else {
                    temp = ints[i];
                    counter++;
                }
            }
        }
        if (counter > 0 && isMoreThanHalf(ints, temp))
            return temp;
        else return -1;

    }


    public static void main(String[] args) {
        int[] ints = {2, 2};
//        int result = findMostFrequentNumebr(ints, 0, ints.length - 1);
        int result = findUseAnotherMethod(ints);
        System.out.println(result);

    }
}
