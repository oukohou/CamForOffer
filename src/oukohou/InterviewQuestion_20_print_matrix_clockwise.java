package oukohou;

/**
 * Created by oukohou on 2017/8/23.
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 * <p>
 * 顺时针打印一个矩阵。
 * tips：
 * 想好边界条件！！！！
 */
public class InterviewQuestion_20_print_matrix_clockwise {

    public boolean print_clockwise(int[][] marix, int column, int row) {
        if (marix == null || column <= 0 || row <= 0) {
            return false;
        }
        int coordinate = 0;
        while (coordinate * 2 < Math.min(column, row)) {
            print_a_circle(marix, coordinate, column, row);
            coordinate++;
        }
        return true;
    }


    private void print_a_circle(int[][] matrix, int coordinate, int column, int row) {
        int begin_X = coordinate;
        int begin_Y = coordinate;
        int end_Y = column - 1 - coordinate;
        int end_X = row - 1 - coordinate;

        //left→right
        for (int i = begin_Y; i <= end_Y; i++) {
            System.out.println(matrix[begin_X][i]);
        }

        // top → down
        if (end_X > begin_X) {
            for (int i = begin_X + 1; i <= end_X; i++) {
                System.out.println(matrix[i][end_Y]);
            }
        }

        if (begin_Y < end_Y && begin_X < end_X) {
            for (int i = end_Y - 1; i >= begin_Y; i--) {
                System.out.println(matrix[end_X][i]);
            }
        }

        if (begin_Y < end_Y && begin_X + 1 < end_X) {
            for (int i = end_X - 1; i > begin_X; i--) {
                System.out.println(matrix[i][begin_Y]);
            }
        }

    }

    public static void main(String[] args) {

        int[][] mat = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        mat = null;
        new InterviewQuestion_20_print_matrix_clockwise().print_clockwise(mat, 4, 3);

    }
}
