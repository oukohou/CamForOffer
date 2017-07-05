package oukohou;

import java.util.Stack;

/**
 * Created by oukohou on 2017/8/23.
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 * <p>
 * 判断一个序列是否能够通过另一个序列的压栈、弹栈得到。
 * tips：
 * 建栈，遍历 b ，若 b 中元素在栈顶，则弹出栈顶，下一个；
 * 若 b 中元素不在，则压入 a 中元素，直到 b 中元素在栈顶。
 */
public class InterviewQuestion_22_stack_push_and_pop {

    public boolean is_pop_order(int[] a_list, int[] b_list) {
        if (a_list == null || b_list == null) {
            System.out.println("null list...");
            return false;
        }

        if (a_list.length != b_list.length) {
            System.out.println("lists don't have same length...");
            return false;
        }
        Stack<Integer> stack_a = new Stack<>();
        int a_index = 0;
        boolean end = false;
        for (int b_index = 0; b_index < b_list.length; b_index++) {
            while ((stack_a.isEmpty() || stack_a.lastElement() != b_list[b_index]) && a_index < a_list.length) {
                stack_a.push(a_list[a_index++]);
            }
            if (stack_a.lastElement() != b_list[b_index])
                break;
            stack_a.pop();
        }
        if (a_index == a_list.length && stack_a.isEmpty())
            end = true;
        return end;
    }


    public static void main(String[] args) {
        int[] a_list = {1, 2, 3, 4, 5};
        int[] b_list = {4, 5, 3, 2, 1};
        b_list = null;
        boolean result = new InterviewQuestion_22_stack_push_and_pop().is_pop_order(a_list, b_list);
        System.out.println(result);

    }
}
