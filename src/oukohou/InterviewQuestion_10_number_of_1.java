package oukohou;


import java.util.Calendar;

/**
 * Created by oukohou on 17-6-26.
 * <Todo> :
 * 计算二进制中1的个数。
 * solution:
 * 几种方法：
 * <p>
 * 1.我的：             number_of_1_standard
 * 取二进制表示成charArray, 然后将其每一位进行是否为1的判断，但，显然，我的方法速度最慢，而且比最差方法慢了2倍....
 * <p>
 * 2.普通解法：          number_of_1_standard
 * 很显然的想法，将其与1进行按位与，然后右移n，依次进行。但这样的话，由于负数右移是左端补1，会产生死循环....
 * <p>
 * 3.优化的普通解法：     number_of_1_optimized
 * 反向思考：既然不能右移n，那我可以左移1呀：-） 比较机智，不过这个需要循环固定次数，比如int是4位，就要32次，有点慢....
 * （但也比我的快了将近3倍[捂脸]....）
 * <p>
 * 4.最好解法：          number_of_1_best
 * 将n与n-1进行按位与，因为这个运算会将n的最右边的一个1置为0，显而易见该数有几个二进制1，就会循环几次，好算法！
 */

public class InterviewQuestion_10_number_of_1 {

    public int number_of_1_my(int n) {
        char[] charArray = Integer.toBinaryString(n).toCharArray();
        int count = 0;
        for (char ch : charArray) {
            count += ch - '0';
        }

        return count;
    }

    public int number_of_1_standard(int n) {
        int count = 0;
        if (n < 0) return -1;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public int number_of_1_optimized(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((flag & n) != 0)
                count++;
            flag = flag << 1;
        }
        return count;
    }

    public int number_of_1_best(int n) {
        int count = 0;
        while (n != 0) {
            n = (n & (n - 1));
            count++;
        }

        return count;
    }

    public int[] get_number_3methods(int n) {
        int[] count = new int[4];
        count[0] = number_of_1_my(n);
        count[1] = number_of_1_my(n);

        return count;
    }

    public int time_compute(int choice) {
        int a = (int) (Math.random() * 100);
        a = 123;
        int n = 1000000;
        long start_time = Calendar.getInstance().getTimeInMillis();

        if (choice == 1) {
            while (n-- > 0) {
//                System.out.print(n+"\t");
                number_of_1_my(a);
            }
        }

        if (choice == 2) {
            while (n-- > 0) {
                number_of_1_standard(a);
            }
        }

        if (choice == 3) {
            while (n-- > 0) {
                number_of_1_optimized(a);
            }
        }

        if (choice == 4) {
            while (n-- > 0) {
                number_of_1_best(a);
            }
        }


        long end_time = Calendar.getInstance().getTimeInMillis();
        int time = (int) (end_time - start_time);

        return time;
    }

    public static void main(String[] args) {
        InterviewQuestion_10_number_of_1 interview10 = new InterviewQuestion_10_number_of_1();
        int number = 123445;
        System.out.println("number's binary radix:\t" + Integer.toBinaryString(number));
        int reslut1 = interview10.number_of_1_my(number);
        int reslut2 = interview10.number_of_1_standard(number);
        int reslut3 = interview10.number_of_1_optimized(number);
        int reslut4 = interview10.number_of_1_best(number);
//        System.out.println("my meth");

        int choice = 1;
        System.out.println("my method costs time: " + interview10.time_compute(choice) + ",\t\t\tget result: " + reslut1);
        choice = 2;
        System.out.println("standard method costs time: " + interview10.time_compute(choice) + ",\t\tget result: " + reslut2);

        choice = 3;
        System.out.println("optimized method costs time: " + interview10.time_compute(choice) + ",\tget result: " + reslut3);

        choice = 4;
        System.out.println("best method costs time: " + interview10.time_compute(choice) + ",\t\t\tget result: " + reslut4);

    }
}
