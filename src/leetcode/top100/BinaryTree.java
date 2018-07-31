package leetcode.top100;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by qxiong on 2018/1/31 0031.
 */
public class BinaryTree {
    public static TreeNode build(List<Integer> list) {
        List<TreeNode> nodeList = new LinkedList<>();
        /*for (int i : list) {
            nodeList.add(new TreeNode(i));
        }*/
        for (int i = 0, len = list.size(); i < len; i++) {
            if (list.get(i) == null) {
                nodeList.add(null);
            } else {
                nodeList.add(new TreeNode(list.get(i)));
            }
        }
        int lp = list.size() / 2 - 1;
        for (int i = 0; i < lp; i++) {
            if (nodeList.get(i)!=null) {
//            left child
                nodeList.get(i).left = nodeList.get(i * 2 + 1);
//            right child
                nodeList.get(i).right = nodeList.get(i * 2 + 2);
            }
        }
        nodeList.get(lp).left = nodeList.get(lp * 2 + 1);
        if (list.size() % 2 != 0) {
            nodeList.get(lp).right = nodeList.get(lp * 2 + 2);
        }
        return nodeList.get(0);
    }


}
