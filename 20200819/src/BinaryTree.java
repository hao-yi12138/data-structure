import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: HAOYI
 * @date:2020-08-19 09:54
 **/
class Node{
    public char val;
    public Node left;
    public Node right;
    public Node(char val) {
        this.val = val;
    }
}
public class BinaryTree {
    public Node buildTree(){
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        Node H = new Node('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.right = H;
        C.left = F;
        C.right = G;
        return A;
    }
    //前序遍历
    void preOrderTraversalNor(Node root) {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null||!stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                System.out.print(cur.val + " ");
                cur = cur.left;
            }
            Node top = stack.pop();
            cur = top.right;
        }
        System.out.println();
    }
    // 中序遍历
    void inOrderTraversal(Node root){
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null||!stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            Node top = stack.pop();
            System.out.println(top.val+" ");
            cur = top.right;
        }
        System.out.println();
    }
    // 后序遍历
    void postOrderTraversal(Node root){
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        Node prev = null;
        while (cur != null||!stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if(cur.right==null||cur.right == prev){
                System.out.print(cur.val+" ");
                stack.pop();
                prev = cur;
                cur=null;
            }else{
                 cur = cur.right;
            }
        }
        System.out.println();
    }
    //层序遍历
    void levelOrderTraversal(Node root){
        if(root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            if(cur!=null){
                System.out.print(cur+" ");
            }
            if(cur.left!=null){
                queue.offer(cur.left);
            }
            if(cur.right!=null){
                queue.offer(cur.right);
            }
        }
        System.out.println();
    }
    public Node prev = null;
    public void ConvertChild(Node pRootOfTree){
        if(pRootOfTree==null){
            return;
        }
       ConvertChild(pRootOfTree.left);
       pRootOfTree.left = prev;
       if(prev!=null){
           prev.right = pRootOfTree;
       }
       prev = pRootOfTree;
       ConvertChild(pRootOfTree.right);
    }
    public Node Convert(Node pRootOfTree) {
         if(pRootOfTree==null){
             return null;
         }
        ConvertChild(pRootOfTree);
         Node head = pRootOfTree;
       while(head.left!=null){
           head= head.left;
       }
       return head;
    }
    //从前序与中序遍历序列构造二叉树
    /*public int preIndex = 0;
    public Node buildTreeChild(int[] preorder, int[] inorder,int inbegin,int inend) {
        if(inbegin>inend){
            return null;
        }
        Node root = new Node(preorder[preIndex]);
        int i = findIndexOfInorder(inorder,inbegin,inend,root.val);
        preIndex++;
        if(i==-1){
            return null;
        }
        root.left  =  buildTreeChild(preorder,inorder,inbegin,i-1);
        root.right =  buildTreeChild(preorder,inorder,i+1,inend);
        return root;
    }
    public int  findIndexOfInorder(int[]inorder,int inbegin,int inend,int val){
        for(int i=inbegin;i<=inend;i++){
            if(inorder[i] == val){
                return i;
            }
        }
        return -1;
    }
    public Node buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder==null){
            return null;
        }
        if(preorder.length<=0||inorder.length<=0){
            return null;
        }
        return buildTreeChild(preorder,inorder,0,inorder.length-1);

    }*/
}
