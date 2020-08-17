/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: HAOYI
 * @date:2020-08-17 09:41
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
        if(root == null){
            return;
        }
        System.out.println(root.val+" ");
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
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val+" ");
    }
    // 遍历思路-求结点个数
    static int size = 0;
    void getSize1(Node root){
        if(root == null){
            return;
        }
        size++;
        getSize1(root.left);
        getSize1(root.right);
    }
    // 子问题思路-求结点个数
    int getSize2(Node root){
        if(root == null){
            return 0;
        }
        return getSize2(root.left)+getSize2(root.right)+1;
    }
    // 遍历思路-求叶子结点个数
    static int leafSize = 0;
    void getLeafSize1(Node root){
        if(root == null){
            return;
        }
        if(root.left == null&&root.right==null){
            leafSize++;
        }else {
            getLeafSize1(root.left);
            getLeafSize1(root.right);
        }
    }
    // 子问题思路-求叶子结点个数
    int getLeafSize2(Node root){
         if(root==null){
             return 0;
         }
         if(root.left==null&&root.right==null){
             return 1;
         }
         return getLeafSize2(root.left)+getLeafSize2(root.right);

    }
    // 子问题思路-求第 k 层结点个数
    int getKLevelSize(Node root,int k) {
        if (root == null) {
            return 0;
        } else if (k == 1) {
            return 1;
        } else {
            return getKLevelSize(root.left, k - 1) + getKLevelSize(root.right, k - 1);
        }
    }
    // 获取二叉树的高度
    int getHeight(Node root){
        if(root == null){
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return left>right?left+1:right+1;
    }
    // 查找 val 所在结点，没有找到返回 null
// 按照 根 -> 左子树 -> 右子树的顺序进行查找
// 一旦找到，立即返回，不需要继续在其他位置查找
    Node find(Node root, char val){
          if(root==null){
              return null;
          }
          if(root.val == val){
             return root;
          }
          Node left = find(root.left,val);
          if(left!=null){
              return left;
          }
          Node right = find(root.right,val);
          if(right!=null){
              return right;
          }
          return null;
    }
    //相同的树
    public boolean isSameTree(Node p, Node q) {
          if((p==null&&q!=null)||(p!=null&q==null)){
              return false;
          }
          if(p==null&&q==null){
              return true;
          }
         if(p.val!=q.val){
            return false;
         }
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
    //给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
    // s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
    public boolean isSubtree(Node s, Node t) {
       if((s==null&&t!=null)||(s!=null&&t==null)){
           return false;
       }
       if(isSameTree(s,t)){
           return true;
       }
       return isSubtree(s.left,t)||isSubtree(s.right,t);
    }
    //对称二叉树
    public boolean isSymmetric(Node root) {
       if(root==null){
          return true;
       }
       return isSymmetricChild(root.left,root.right);
    }
    public boolean isSymmetricChild(Node leftTree,Node rightTree){
        if((leftTree!=null&&rightTree==null)||(leftTree==null&&rightTree!=null)){
            return false;
        }
        if(leftTree==null&&rightTree==null){
            return true;
        }
        return (leftTree.val==rightTree.val)&&isSymmetricChild(leftTree.left,rightTree.right)&&isSymmetricChild(leftTree.right,rightTree.left);
    }
    //平衡二叉树
    public boolean isBalanced(Node root) {
        if(root==null){
            return true;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.abs(left-right)<2&&isSymmetric(root.left)&&isSymmetric(root.right);
    }
}
