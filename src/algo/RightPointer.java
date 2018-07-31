package algo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author hustxq.
 * @Date 2017/9/21 9:32
 */
public class RightPointer {
    public static void main(String[] args) {
//        ConstructBinaryTree con = new ConstructBinaryTree();
        RightPointer $ = new RightPointer();
        int[] iarr={1,2,3,4,5,6,7};
        TreeLinkedNode root = $.buildTreeByBfs(iarr);
        $.connect(root);
        System.out.println(root.next);
        System.out.println(root.left.next);
    }

    public void connect(TreeLinkedNode root){
        if (root == null) return;
        TreeLinkedNode p = root;
        TreeLinkedNode first = null;

        while(p!=null){
            if (first == null){
                first = p.left;
            }
            if (p.left!=null){
                p.left.next = p.right;
            }else {
                break;
            }
            if (p.next!=null){
                p.right.next = p.next.left;
                p = p.next;
            }else {
                p = first;
                first = null;
            }
        }

    }

    /*
    * 根据层序构建完全二叉树
    * */
    TreeLinkedNode buildTreeByBfs(int[] iarr) {
        List<TreeLinkedNode> list = new ArrayList<>();
        int len = iarr.length;
        for (int i = 0; i < len; i++) {
            list.add(new TreeLinkedNode(iarr[i]));
        }
        int p = 0;
        while (p <= (len - 2) / 2) {
//            left
            if (2 * p + 1 < len) {
                list.get(p).left = list.get(2 * p + 1);
            }
            if (2 * p + 2 < len) {
                list.get(p).right = list.get(2 * p + 2);
            }
            p++;
        }
        return list.get(0);
    }
}
class TreeLinkedNode{
    public int value;
    public TreeLinkedNode left;
    public TreeLinkedNode right;
    public TreeLinkedNode next;

    public TreeLinkedNode(int value) {
        this.value = value;
    }
}