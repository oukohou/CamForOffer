package oukohou.problems;

/**
 * Created by oukohou on 2017/9/7.
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 * problem:
 * 求整形数组的所有子数组的和的最大值；
 * tips：
 * 与滴滴的机试题一样，统计max和sum，更新max值即可。
 */
public class _31_largestSumOfArray {

    public int findLargestSum(int[] array) {
        if (array.equals(null)) {
            System.out.println("null list.");
            return -1;
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            if (max < sum) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }

    /* 主意！！！ 该题动态规划算法的思路，需要额外的变量太统计最大值！！
     * 例如：{4，-1，-1，-1，4，-1}
     * 若按照题目思路，pre(3) = 4，pre(4) = 5，但是递归中只能返回最终的sum值，不能返回历次递归中的最大sum值，
     * 所以需要一个额外的全局变量this.max 来记录。最终返回的应该是这个this.max值。
     */
    public int findUsingDynamicProgramming(int[] array, int index, int sum, int max) {
        if (index == 0) {
            this.max = max;
            return array[index];
        }

        int pre = findUsingDynamicProgramming(array, index - 1, sum, max);
        if (pre > max) {
            max = pre;
        }
        if (pre > 0) {
            sum = pre + array[index];
        } else {
            sum = array[index];
        }
        if (sum > max) {
            this.max = sum;
        }
        return sum;
    }

    public int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int[] array = {-1, 4, -2, 5, 8, -1};
        int max = Integer.MIN_VALUE;
        _31_largestSumOfArray object = new _31_largestSumOfArray();
//        int sum = object.findLargestSum(array);
        object.findUsingDynamicProgramming(array, array.length - 1, 0, max);
        System.out.println(object.max);
    }
}
