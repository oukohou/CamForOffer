package oukohou;

import java.util.logging.Logger;

/**
 * Created by oukohou on 2017/8/28.
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 * to do :
 * to convert a BST into double direction linkedList.
 *
 * tips:
 * 从根节点中序遍历，根节点的前驱节点是其左子树的根节点或者左子树的右子树的根节点，
 * 根节点的后继节点同理。记得更新当前节点的前驱和后继节点时，其前驱和后继节点的相应后继和前驱也要更新。
 */


public class InterviewQestion_27_BST_to_2D_linkedlist {
    static class BST {
        public BST(int value, BST left, BST right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public int value;
        public BST left = null, right = null;

    }

    public void convert_to_2d_linkedlist(BST node) {
        if (node == null)
            return;
        convert_to_2d_linkedlist(node.left);
        convert_to_2d_linkedlist(node.right);

        BST pre_node = find_pre_node(node);
        BST next_node = find_next_node(node);
        node.left = pre_node;
        if (pre_node != null)
            pre_node.right = node;
        node.right = next_node;
        if (next_node != null)
            next_node.left = node;
    }

    public void display(BST node) {
        BST temp = node;
        while (temp.left != null) {
            temp = temp.left;
        }
        while (temp != null) {
            System.out.print("value: " + temp.value + "\t");
            temp = temp.right;
        }
    }

    public void display_BST(BST node) {
        if (node == null)
            return;
        if (node.left != null)
            display_BST(node.left);
        System.out.print("value: " + node.value + "\t");

        if (node.right != null)
            display_BST(node.right);

    }

    private BST find_pre_node(BST node) {
        if (node == null || node.left == null) {
            return null;
        }

        BST temp_node = node;
        while (temp_node.left != null) {
            temp_node = temp_node.left;
            if (temp_node.right != null)
                return temp_node.right;
            else {
                return temp_node;
            }
        }
        return null;
    }


    private BST find_next_node(BST node) {
        if (node == null || node.right == null) {
            return null;
        }

        BST temp_node = node;
        while (temp_node.right != null) {
            temp_node = temp_node.right;
            if (temp_node.left != null)
                return temp_node.left;
            else return temp_node;
        }
        return null;
    }

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(InterviewQestion_27_BST_to_2D_linkedlist.class.getName());
        BST node = new BST(10, null, null);
        node.left = new BST(6, null, null);
        node.right = new BST(14, null, null);

        node.left.left = new BST(4, null, null);
        node.left.right = new BST(8, null, null);

        node.right.left = new BST(12, null, null);
        node.right.right = new BST(16, null, null);

        InterviewQestion_27_BST_to_2D_linkedlist temp = new InterviewQestion_27_BST_to_2D_linkedlist();
        temp.display_BST(node);
        temp.convert_to_2d_linkedlist(node);
        temp.display(node);
    }
}
