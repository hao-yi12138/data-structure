import java.util.Stack;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: HAOYI
 * @date:2020-08-20 09:10
 **/
class Node{
    public char val;
    public Node left;
    public Node right;
    public Node(char val){
        this.val = val;
    }
}
public class BinaryTree {
    static int i = 0;
    public static Node buildTree(String str){
        Node root = null;
        if(str.charAt(i)!='#'){
            root = new Node(str.charAt(i));
            i++;
            root.left = buildTree(str);
            root.right = buildTree(str);
        }else{
            i++;
        }
        return root;
    }
    //从中序与后序遍历序列构造二叉树
    /*public int postIndex ;
    public TreeNode buildTreeChild(int[] inorder, int[] postorder,int inbegin,int inend) {
        if(inbegin>inend){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postIndex]);
        postIndex--;
        int i = findInOrderIndex(inorder,inbegin,inend,root.val);
        if(i==-1){
            return null;
        }
        root.right= buildTreeChild(inorder,postorder,i+1,inend);
        root.left = buildTreeChild(inorder,postorder,inbegin,i-1);
        return root;
    }
    public int findInOrderIndex(int[] inorder,int inbegin,int inend,int val){
        for(int i=inbegin;i<=inend;i++){
            if(inorder[i]==val){
                return i;
            }
        }
        return -1;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null||postorder==null){
            return null;
        }
        if(inorder.length<=0 || postorder.length<=0){
            return null;
        }
        postIndex = postorder.length-1;
        return buildTreeChild(inorder,postorder,0,inorder.length-1);
    }*/

}
