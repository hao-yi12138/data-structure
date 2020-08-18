import java.util.*;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: HAOYI
 * @date:2020-08-18 14:32
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
    // 前序遍历
    void preOrderTraversal(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.val+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    // 中序遍历
    void inOrderTraversal(Node root){
        if(root == null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.val+" ");
        inOrderTraversal(root.right);
    }
    // 后序遍历
    void postOrderTraversal(Node root){
        if(root == null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val+" ");
    }
    //层序遍历
    void levelOrderTraversal(Node root){
        if(root==null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur != null) {
                System.out.print(cur.val + " ");
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        System.out.println();
    }
    /*public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new LinkedList<>();
        if(root == null) return ret;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            //1、求当前队列的大小  size
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            //2、while(size > 0)  -->控制当前每一层的数据个数
            while(size>0){
                Node cur = queue.poll();
                if(cur!=null) {
                    list.add(cur.val);
                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                }
                size--;
            }
            ret.add(list);
        }
        return ret;
    }*/
    // 判断一棵树是不是完全二叉树
    boolean isCompleteTree(Node root){
        if(root==null) return true;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            if(cur!=null){
                queue.offer(cur.left);
                queue.offer(cur.right);
            }else {
                break;
            }
        }
        while (!queue.isEmpty()){
            Node cur2 = queue.poll();
            if(cur2!=null){
                return false;
            }
        }
        return true;
    }
    // 前序遍历
    void preOrderTraversalNor(Node root){
        if(root==null) return;
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while(cur!=null||!stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                System.out.print(cur.val+" ");
                cur = cur.left;
            }
            Node top = stack.pop();
            cur = top.right;
        }
    }
    // 中序遍历
    void inOrderTraversalNor(Node root){
        if(root==null) return;
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while(cur!=null||!stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
             Node top = stack.pop();
            System.out.print(top.val+" ");
            cur = top.right;
        }
        System.out.println();
    }
    // 后序遍历
    void postOrderTraversalNor(Node root){
        if(root==null) return;
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        Node prev = null;
        while(cur!=null||!stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if(cur.right == null || cur.right == prev){
                System.out.print(cur.val+" ");
                stack.pop();
                prev = cur;
                cur =null;
            }else{
               cur = cur.right;
            }
        }
        System.out.println();
    }
}
