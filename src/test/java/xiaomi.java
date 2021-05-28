import javax.swing.tree.TreeNode;
import java.util.*;
import java.util.ArrayList;
import java.util.Queue;

/**
 *
 * 作者：牛客题霸-大厂社招面试题
 * 链接：https://ac.nowcoder.com/discuss/597533?type=1&order=3&pos=27&page=0&channel=-1&source_id=discuss_center_1_nctrack
 * 来源：牛客网
 *
 * NC14二叉树的之字形层序遍历
 *
 * 2、NC2重排链表
 *
 * 3、NC5二叉树根节点到叶子节点的所有路径和
 *
 * 4、NC33合并有序链表
 *
 * 5、NC68跳台阶
 *
 * 6、NC22合并两个有序的数组
 *
 * 7、NC25删除有序链表中重复的元素
 *
 * 8、NC16判断二叉树是否对称
 *
 * 9、NC3链表中环的入口节点
 *
 * 10、NC15求二叉树的层序遍历
 *
 * 11、NC83子数组最大乘积
 *
 * 12、NC1大数加法
 *
 * 13、NC7买卖股票的最佳时机
 *
 * 14、NC13二叉树的最大深度
 *k
 * 15、NC4判断链表中是否有环
 *
 * 16、NC32求平方根
 *
 * 17、NC21链表内指定区间反转
 *
 * 18、NC128容器盛水问题
 *
 * 19、NC52括号序列
 *
 * 20、NC115栈和排序
 *
 * 21、NC69链表中倒数第k个结点
 *
 * 22、NC51合并k个已排序的链表
 *
 * 23、NC31转圈打印矩阵
 *
 * 24、NC24删除有序链表中重复出现的元素
 *
 * 25、NC37合并区间
 *
 * 26、NC123序列化二叉树
 *
 * 27、 NC53 删除链表的倒数第 n个节点
 * @author zengsong
 * @date 2021/3/218:30
 */
public class xiaomi {


    /**
     * 二叉树的之字形层序遍历
     * 该二叉树之字形层序遍历的结果是
     *
     * [
     * [3],
     * [20,9],
     * [15,7]
     * ]
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList<>>
     */
//    public ArrayList<ArrayList<Integer>> zigzagLevelOrder (TreeNode root) {
//        // write code here
//        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
//        if(root == null) return res;
//
//        boolean reverse = false;
//        Queue<TreeNode> queue = new ArrayDeque();
//        queue.add(root);
//
//        while(!queue.isEmpty()){
//            int size = queue.size();
//            ArrayList<Integer> list = new ArrayList<>();
//            while(size-- > 0){
//                TreeNode tmp = queue.poll();
//                list.add( tmp.val );
//                if(tmp.left!=null) queue.add(tmp.left);
//                if(tmp.right!=null) queue.add(tmp.right);
//            }
//            if(reverse) Collections.reverse(list);
//            res.add(list);
//            reverse = !reverse;
//        }
//
//        return res;
//
//    }



    /**
     * C实现重排链表
     * 对于给定的单链表{10,20,30,40}，将其重新排序为{10,40,20,30}.
     * @param head
     */
//    public void reorderList(ListNode head) {
//        if (head == null) {
//            return;
//        }
//        // 快满指针找到中间节点
//        ListNode fast = head, slow = head;
//        while (fast != null && fast.next != null) {
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//
//        // 拆分链表，并反转中间节点之后的链表
//        ListNode cur = slow.next, pre = null, next = null;
//        slow.next = null;
//        while (cur != null) {
//            next = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = next;
//        }
//
//        // 合并两个链表
//        ListNode p1 = head, p2 = pre;
//        while (p1 != null && p2 != null) {
//            next = p2.next;
//            p2.next = p1.next;
//            p1.next = p2;
//            p1 = p2.next;
//            p2 = next;
//        }
//    }


    /**
     * 合并有序链表
     * @param l1
     * @param l2
     * @return
     */
//    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
//        //存放新链表的头节点
//        ListNode resNode=new ListNode(0);
//        ListNode cur=resNode;
//        //每次将两个链表中值最小的节点加入
//        if(l1!=null&&l2!=null){
//            if(l1.val<=l2.val){
//                cur.next=l1;
//                l1=l1.next;
//            }else {
//                cur.next=l2;
//                l2=l2.next;
//            }
//            cur=cur.next;
//        }
//        //将剩余的链表加入
//        if(l1!=null){
//            cur.next=l1;
//        }
//        if(l2!=null){
//            cur.next=l2;
//        }
//        return cur.next;
//    }
//
//
//    public void ddd(){
//
//    }
//
//    public int maxProfit (int[] prices) {
//        // 最便宜的时候买，最贵的时候卖，并且买在前，卖在后
//        if (prices.length == 0) return 0;
//        int min = prices[0], maxP = 0;
//        for (int i = 1; i < prices.length; i++) {
//            min = prices[i] < min ? prices[i] : min;
//            maxP = (prices[i] - min) > maxP ? (prices[i] - min) : maxP;
//        }
//        return maxP;
//    }

}
