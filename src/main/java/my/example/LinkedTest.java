package my.example;


import java.util.LinkedList;

/**
 * @author zengsong
 * @date 2021/4/12 17:06
 */
public class LinkedTest {

    public Node reverRestList(Node head){
       if(head==null||head.getNext()==null){
           return head;
       }
       Node proNode=null;
       Node currentNode=head;
       Node nextNode=null;
       while(currentNode!=null){
           currentNode=currentNode.getNext();
           currentNode.setNext(proNode);
           proNode=currentNode;
           currentNode=nextNode;
       }
       return proNode;
    }
    //数据合并
    public void fffd(LinkedList data){
        LinkedList newList=new LinkedList();
        for (Object d:data){
            newList.add(d);
        }
    }


    /**
     * 前序遍历(中、左、右)
     * @param root
     */
    public void preData(TreeNode root){
        if(root!=null){
            System.out.print(root.getRoot()+"\t");
            preData(root.getLeftNode());
//            中序遍历(左中右)
//            System.out.print(root.getRoot()+"\t");
            preData(root.getRightNode());
            //后序左右中
            System.out.print(root.getRoot()+"\t");
        }
    }

    //求树的结点
    public int treeNodeNum(TreeNode root){
        if(root==null){
            return 0;
        }
        return treeNodeNum(root.getLeftNode())+treeNodeNum(root.getRightNode())+1;
    }
    //求树的叶子数
    public int notRootNum(TreeNode root){
        if(root==null){
            return 0;
        }
        if(root.getLeftNode()==null&&root.getRightNode()==null){
            return 1;
        }
        return notRootNum(root.getLeftNode())+notRootNum(root.getRightNode());
    }
    //求树的深度
    public int getTreeNodeLenght(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftNum=getTreeNodeLenght(root.getLeftNode());
        int rightNum=getTreeNodeLenght(root.getRightNode());
        return leftNum>rightNum?leftNum+1:rightNum+1;
    }

    //二叉树求第K层的节点个数
    public int getTreeNodeNum(TreeNode root,int k){
        if(root==null){
            return 0;
        }
        if(k==0){
            return 1;
        }
        int leftNum=getTreeNodeNum(root.getLeftNode(),k-1);
        int rightNum=getTreeNodeNum(root.getRightNode(),k-1);
        return leftNum+rightNum;
    }

    //二叉树路径最大和,枚举每个必经节点,然后找到该节点为根的左子树以及右子树路径最大值,上边到该点的值
    public int maxPathSum(TreeNode root){
        if(root==null){
            return 0;
        }
        dfs(root,0);
        return ans;
    }
    int ans=Integer.MIN_VALUE;
    public int dfs(TreeNode root,int data){

        if(root==null)
        {
            return 0;
        }
        if(root.getLeftNode()==null&&root.getRightNode()==null){
            return root.getRoot();
        }
        if(root.getRoot()<0){
            data=0;
        }
        int sumNum=data+root.getRoot();
        int leftNum=dfs(root.getLeftNode(),sumNum);
        int rightNum=dfs(root.getRightNode(),sumNum);

        ans=Math.max(ans,data+leftNum+root.getRoot());
        ans=Math.max(ans,data+rightNum+root.getRoot());

        ans=Math.max(ans,leftNum+rightNum+root.getRoot());
        leftNum=Math.max(leftNum,rightNum)+root.getRoot();
        return leftNum>0?leftNum:0;
    }
    //两个左右下子节点加起来的高度不超过1就是一颗平衡二叉树。
}
