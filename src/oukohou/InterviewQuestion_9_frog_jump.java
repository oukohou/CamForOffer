package oukohou;

/**
 * Created by oukohou on 17-6-22.
 * <Todo> :
 * 青蛙一次跳2级台阶或者2级，求其跳上一个n级台阶共多少中跳法。
 * <p>
 * # solution:
 * 同斐波那契数列的解法，很自然地想到递归，但递归计算太冗余，不如循环。
 */

public class InterviewQuestion_9_frog_jump {

    public long loop_compute(int n) {
        int[] result = {0, 1, 2};
        if (n < 0) {
            System.out.println("wrong input! N must bigger than 0.");
            return -1;
        }
        if (n < 3) return result[n];

        long jump_1 = 1, jump_2 = 2;
        long jump_n = 0;
        for (int i = 3; i <= n; i++) {
            jump_n = jump_1 + jump_2;
            jump_2 = jump_1;
            jump_1 = jump_n;
        }
        return jump_n;

    }


    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            System.out.println("for " + i + ",\tthe result of jumps is " + new InterviewQuestion_9_frog_jump().loop_compute(i));
        }


    }
}
