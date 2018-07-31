package leetcode.top100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qxiong on 2018/3/28 0028.
 */
public class SubtreeOfAnotherTree572 {
    static List<Integer> listS = new ArrayList<>();
    static List<Integer> listT = new ArrayList<>();

    static public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t==null)return true;
        if (s==null)return false;

        inOrder(s,listS);
        inOrder(t,listT);
        for (int i:listS){
            System.out.print(i+"\t");
        }
        for (int i:listT){
            System.out.print(i+"\t");
        }
        int p = 0;
        for (int i = 0; i < listS.size(); i++) {
            if (listS.get(i) == listT.get(0)){
                for (int j = 1; j < listT.size(); j++) {
                    if (listS.get(++i)!=listT.get(j)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static private void inOrder(TreeNode root,List<Integer> list){
        if (root!=null){
            inOrder(root.left,list);
            list.add(root.val);
            inOrder(root.right,list);
        }
    }

    public static void main(String[] args) {
        TreeNode s = new TreeNode(1);
        TreeNode t = new TreeNode(1);
        System.out.println(isSubtree(s,t));
    }
}
