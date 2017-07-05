package oukohou;

/**
 * Created by oukohou on 2017/8/28.
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 */

class BST {
    public BST(int value, BST left, BST right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    private int value;
    private BST left, right;

    public BST getRight() {
        return right;
    }

    public void setRight(BST right) {
        this.right = right;
    }

    public BST getLeft() {
        return left;
    }

    public void setLeft(BST left) {
        this.left = left;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

public class InterviewQestion_27_BST_to_2D_linkedlist {

    public void convert_to_2d_linkedlist(BST node,) {

    }

    public static void main(String[] args) {


    }
}
