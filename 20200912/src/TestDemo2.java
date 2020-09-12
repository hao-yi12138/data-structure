import java.util.ArrayList;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: HAOYI
 * @date:2020-09-12 22:17
 **/
 class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
//反转链表
 class Solution2 {
    public ListNode ReverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode cur = head;
        ListNode prev = null;
        while(cur!=null){
            ListNode curNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return prev;
    }
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
 }
 //二叉树层序遍历牛客
class Solution {
    /**
     *
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        if(root == null){
            return ret;
        }
        ArrayList<TreeNode> arraylist = new ArrayList<>();
        arraylist.add(root);
        while(!arraylist.isEmpty()){
            int size = arraylist.size();
            ArrayList<Integer> list = new ArrayList<>();
            int i;
            for(i=0;i<size;i++){
                TreeNode root2 = arraylist.get(0);
                list.add(root2.val);
                if(root2.left!=null){
                    arraylist.add(root2.left);
                }
                if(root2.right!=null){
                    arraylist.add(root2.right);
                }
                arraylist.remove(0);

            }
            ret.add(list);
        }
        return ret;
    }
}
public class TestDemo2 {

}
