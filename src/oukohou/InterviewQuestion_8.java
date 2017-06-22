package oukohou;

/**
 * Created by oukohou on 17-6-14.
 * <Todo> :
 * 1.输入一个递增排序的数组的旋转数组，输出其最小值。
 * 2.同时输出其最大值。
 * <p>
 * solution：
 * 借鉴二分查找，两端取两个值，循环比价中间值与两端值大小。
 */

public class InterviewQuestion_8 {
    public int getMinNumber(int[] list) {
        if (list == null) {
            //　空列表。
            throw new NullPointerException("null list!");
        }
        int result = 0;
        if (list.length == 1) {
            // 只有一个值，直接返回。
            result = list[0];
        }

        int i = 0;
        int j = list.length - 1;
        if (list[i] < list[j]) {
            // 未旋转，直接输出第一个值。
            return list[i];
        } else while (list[i] >= list[j]) {
            if (i == (j - 1)) {
                //　ｉ已经与ｊ相邻，输出较小值。
                result = list[i] > list[j] ? list[j] : list[i];
                break;
            }
            int mid = (i + j) / 2;

            if (list[i] == list[j] && list[j] == list[mid]) {
                //　三个位置的值均相等，无法判断mid所在位置，只有遍历。
                result = list[i];
                for (int k = i; k <= j; k++) {
                    if (result > list[k]) {
                        result = list[k];
                    }
                }
                break;
            }
            if (list[i] <= list[mid]) {
                // ｉ　右移。
                i = mid;
            } else if (list[mid] <= list[j]) {
                //　ｊ　左移。
                j = mid;
            }
            result = list[mid];
        }
        return result;
    }


    public static void main(String[] args) {

        int[] a = {1, 1, 1, 1, 1,};
        int[] b = {3, 4, 4, -21, 2};

        System.out.println(new InterviewQuestion_8().getMinNumber(b));

    }
}
