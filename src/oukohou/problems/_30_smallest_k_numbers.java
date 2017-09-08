package oukohou.problems;

/**
 * Created by oukohou on 2017/9/6.
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 */
public class _30_smallest_k_numbers {

    public int[] fingSmallestKNumbers(int[] ints, int topK) {
        int[] topKs = new int[topK];
        int index = 0;
        for (; index < topK; index++) {
            topKs[index] = ints[index];
        }

        convert_arrays_to_heap(topKs);
        for (; index < ints.length; index++) {
            if (ints[index] < topKs[0]) {
                topKs[0] = ints[index];
                adjustMaxHeap(topKs, 0);
            }
        }
        return topKs;
    }

    public void convert_arrays_to_heap(int[] ints) {
        int index = ints.length / 2 - 1;
        for (int i = index; i >= 0; i--) {
            adjustMaxHeap(ints, i);
        }
    }

    private void adjustMaxHeap(int[] ints, int index) {
        int length = ints.length;
        int l_child = index * 2 + 1;
        int temp_idnex = index;
        if (l_child + 1 < length && ints[temp_idnex] < ints[l_child + 1]) {
            temp_idnex = l_child + 1;
        }
        if (l_child < length && ints[temp_idnex] < ints[l_child]) {
            temp_idnex = l_child;
        }
        if (temp_idnex != index) {
            l_child = ints[temp_idnex];
            ints[temp_idnex] = ints[index];
            ints[index] = l_child;
            adjustMaxHeap(ints, temp_idnex);
        }
    }

    public void display(int[] ints) {
        for (Integer integer :
                ints) {
            System.out.print(integer + "\t");
        }
    }


    public static void main(String[] args) {
        int[] ints = {4, 5, 1, 6, 2, 7, 3, 8};
        _30_smallest_k_numbers object_a = new _30_smallest_k_numbers();
        int[] topKs = object_a.fingSmallestKNumbers(ints, 4);
        object_a.display(topKs);
    }
}
