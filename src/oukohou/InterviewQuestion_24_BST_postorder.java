package oukohou;

/**
 * Created by oukohou on 2017/8/24.
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 * <p>
 * 判断一个数组是否是二叉搜索树的后序遍历结果。
 * <p>
 * tips:
 * 递归判断每个子序列是否为子树的后序遍历结果。
 */
public class InterviewQuestion_24_BST_postorder {
    public boolean is_post_order(int[] array, int begin_index, int end_index) {
        // 防御性编程!!!!!!
        if (array == null || begin_index < 0 || end_index < begin_index || end_index > array.length - 1) {
            System.out.println("error input...");
            return false;
        }

        boolean result = false;
        int index_count = begin_index;
        for (; index_count < end_index; index_count++) {
            if (array[index_count] > array[end_index])
                break;
        }

        int index = index_count - 1;
        for (; index_count < end_index; index_count++) {
            if (array[index_count] < array[end_index])
                return false;
        }

        boolean left_flag = true;
        boolean right_flag = true;
        if (index > begin_index)
            left_flag = is_post_order(array, begin_index, index);
        if (index + 1 < end_index)
            right_flag = is_post_order(array, index + 1, end_index - 1);
        result = left_flag && right_flag;
        return result;
    }


    public static void main(String[] args) {

        int[] a_list = {5, 7, 6, 9, 11, 8, 10};
        System.out.println(new InterviewQuestion_24_BST_postorder().is_post_order(a_list, 0, a_list.length - 1));
    }
}
