import java.util.LinkedList;
import java.util.Queue;

class BTNode {
    public char val;//定义一个节点存放字母
    public BTNode left;
    public BTNode right;

    public BTNode(char val) {//提供一个构造方法
        this.val = val;
    }
}



public class BinaryTree {
    /**
     * 首先创建二叉树
     *
     * @return
     */
    public BTNode creatTree() {
        BTNode A = new BTNode('A');
        BTNode B = new BTNode('B');
        BTNode C = new BTNode('C');
        BTNode D = new BTNode('D');
        BTNode E = new BTNode('E');
        BTNode F = new BTNode('F');
        BTNode G = new BTNode('G');
        BTNode H = new BTNode('H');
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
    void preOrderTraversal(BTNode root) {//输入的参数为根节点
        if (root == null) return;
        System.out.print(root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);


    }

    // 中序遍历
    void inOrderTraversal(BTNode root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.val);
        inOrderTraversal(root.right);


    }

    // 后序遍历
    void postOrderTraversal(BTNode root) {
        if (root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val);


    }

    // 遍历思路-求结点个数
    static int size = 0;

    void getSize1(BTNode root) {
        if (root == null) return;
        size++;
        getSize1(root.right);
        getSize1(root.left);


    }

    // 子问题思路-求结点个数
    int getSize2(BTNode root) {
        if (root == null) return 0;
        return getSize2(root.left) + getSize2(root.right) + 1;


    }

    // 遍历思路-求叶子结点个数
    static int leafSize = 0;

    void getLeafSize1(BTNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            leafSize++;
        }
        getLeafSize1(root.left);
        getLeafSize1(root.right);

    }

    // 子问题思路-求叶子结点个数
    int getLeafSize2(BTNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getLeafSize2(root.left) + getLeafSize2(root.right);

    }

    // 子问题思路-求第 k 层结点个数
    int getKLevelSize(BTNode root, int k) {
        if (root == null) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return getKLevelSize(root.left, k - 1) +
                getKLevelSize(root.right, k - 1);

    }

    // 获取二叉树的高度
    int getHeight(BTNode root) {
        if (root == null) return 0;

        return getHeight(root.left) > getHeight(root.right) ?
                getHeight(root.left) + 1 : getHeight(root.right) + 1;
    }


    BTNode find(BTNode root, int val) {
        if (root == null) return null;
        if (root.val == val) {
            return root;
        }
        BTNode ret = find(root.left, val);
        if (ret == null) {
            return ret;
        }
        ret = find(root.right, val);
        if (ret == null) {
            return ret;
        }
        return null;
    }


    // 判断一棵树是不是完全二叉树
    boolean isCompleteTree(BTNode root) {
        if(root == null){
            return true;
        }
        Queue<BTNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            BTNode cur = queue.poll();
            if(cur!=null){
                queue.offer(cur.left);
                queue.offer(cur.right);

            }else {
                break;
            }
        }
        while (!queue.isEmpty()) {
            BTNode cur = queue.peek();
            if (cur != null) {
                return false;
            } else {
                queue.poll();
            }
        }
        return true;
    }
    // 前序遍历
     void preOrderTraversalNor(BTNode root){

    }
    // 中序遍历
    void inOrderTraversalNor(BTNode root){

    }
    // 后序遍历
    void postOrderTraversalNor(BTNode root){

    }
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BTNode root = binaryTree.creatTree();
        System.out.println(binaryTree.isCompleteTree(root));
    }
}

/**判断两个树是否相同
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/*
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q!= null || p!= null && q == null){//判断这两树，其中一个为空，则返回false
            return false;
        }
        if(p == null && q == null){//都为空相等返回true
            return true;
        }
        if(p.val != q.val){//判断这两个树此时位置上的值是否相等，不相等返回false
            return false;
        }
        return isSameTree(p.left,q.left)&& isSameTree(p.right,q.right);//递归思想，重新返回上去去判断他的左子树和右子树是否相等

    }
}*/
/**判断一个树是否是另一个树的子树
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/*class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q!= null || p!= null && q == null){//判断这两树，其中一个为空，则返回false
            return false;
        }
        if(p == null && q == null){//都为空相等返回true
            return true;
        }
        if(p.val != q.val){//判断这两个树此时位置上的值是否相等，不相等返回false
            return false;
        }
        return isSameTree(p.left,q.left)&& isSameTree(p.right,q.right);//递归思想，重新返回上去去判断他的左子树和右子树是否相等
    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null || t == null) {//递归过程中可能为空
            return false;
        }
        if(isSameTree(s,t)) return true;//调用，判断两个数是否是相等的两个树
        if(isSubtree(s.left,t)) return true;//递归判断t是否是s的某一个左树
        if(isSubtree(s.right,t)) return true;//递归判断t是否是s的某一个右树
        return false;//都不是，返回false;

    }
}*/
/**给定一个二叉树，检查它是否是镜像对称的。
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//class Solution {
//    public boolean isSymmetricChild(TreeNode leftTree,TreeNode rightTree) {//判断他的左右树是否是对称的
//        if(leftTree == null && rightTree != null || leftTree != null && rightTree == null ) {
//            return false;//其中一个为空，返回false；
//        }
//        if(leftTree == null && rightTree == null) {
//            return true;//都为空，对称
//        }
//        if(leftTree.val != rightTree.val) return false;//判断相同位置上的节点值是否相等；
//
//        return isSymmetricChild(leftTree.left,rightTree.right) && //继续递归左树的左树，右树的右树；
//                isSymmetricChild(leftTree.right,rightTree.left) ;//和左树的右树，右树的左树，来判断是否对称；
//    }
//
//    public boolean isSymmetric(TreeNode root) {
//        if(root == null) {//根节点为空，对称
//            return true;
//        }
//        return isSymmetricChild(root.left,root.right);//遍历左树和右树看是否对称；
//
//    }
//}
/**是否是是平衡二叉树方法一
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/*
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return leftHeight  > rightHeight  ?
                leftHeight +1 : rightHeight +1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.abs(leftHeight-rightHeight) <= 1
                && isBalanced(root.left) && isBalanced(root.right);
    }

}*/
/**是否是是平衡二叉树方法二
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/*
class Solution {
    public int hight(TreeNode root) {
        if(root == null) return 0;
        int leftHight = hight(root.left);
        int rightHight = hight(root.right);
        // if(leftHight >= 0 && rightHight >= 0 &&
        // Math.abs(leftHight-rightHight) <= 1) {
        //     return Math.max(leftHight,rightHight) + 1;
        // }else {
        //     return -1;
        // }
        if(leftHight == -1 || rightHight == -1 ||
                Math.abs(leftHight-rightHight) > 1) {
            return -1;
        }else {
            return Math.max(leftHight,rightHight) + 1;
        }
    }
    public boolean isBalanced(TreeNode root) {
        if(hight(root) >= 0) {
            return true;
        }
        return false;
        //return hight(root) >= 0;
    }


}*/
/**层序遍历
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();//创建一个ret表；
        if(root == null)  return ret;
        Queue <TreeNode> queue  = new LinkedList<>();//创建一个队列；
        queue.offer(root);//弹出队头元素

        while(!queue.isEmpty()){
            List<Integer> list= new ArrayList<>();//重新定义列表存放每一层的元素；
            int size = queue.size();//计算队列的长度；
            while(size>0){//循环条件size>0；
                TreeNode cur = queue.poll();//弹出队头元素存放在定义的cur中；
                list.add(cur.val);
                if(cur.left!= null){
                    queue.offer(cur.left);
                }
                if(cur.right!= null){
                    queue.offer(cur.right);
                }
                size--;
            }
            ret.add(list);
        }
        return ret;
    }
}*/
