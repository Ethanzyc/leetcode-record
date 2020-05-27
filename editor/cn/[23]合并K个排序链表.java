//合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。 
//
// 示例: 
//
// 输入:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//输出: 1->1->2->3->4->4->5->6 
// Related Topics 堆 链表 分治算法


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution23 {
    public static ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        List<ListNode> arr = new ArrayList<>();

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                arr.add(lists[i]);
            }
        }
        if (arr.size() == 0) {
            return null;
        }

        ListNode firstList = arr.get(0);
        ListNode returnPoint = firstList;

        for (int i = 1; i < arr.size(); i++) {
            ListNode secondList = arr.get(i);
            while (firstList != null && secondList != null) {

                if (firstList.next == null) {
                    if (firstList.val <= secondList.val) {
                        firstList.next = secondList;
                        continue;
                    } else {
                        continue;
                    }
                }

                if (firstList.next.val > secondList.val) {
                    ListNode insertStartPoint = findBigger(firstList, secondList);
                    ListNode insertEndPoint = findSmaller(firstList.next, secondList);

                    if (insertEndPoint == null) {
                        insertEndPoint = insertStartPoint;
                    }

                    ListNode next1 = firstList.next;
                    ListNode next2 = insertEndPoint.next;
                    insertStartPoint.next = secondList;
                    insertEndPoint.next = next1;
                    firstList = next1;
                    secondList = next2;
                } else {
                    if (secondList.next == null) {
                        while (true) {
                            firstList = firstList.next;
                            if (firstList.next == null) {
                                firstList.next = secondList;
                                break;
                            }
                        }
                    }
                    firstList = firstList.next;
                }
            }
            firstList = returnPoint;
        }

        return returnPoint;
    }


    private static ListNode findBigger(ListNode firstNode, ListNode secondNode) {

        while (firstNode.next != null) {
            if (secondNode.val >= firstNode.val && secondNode.val <= firstNode.next.val) {
                return firstNode;
            }
            firstNode = firstNode.next;
        }
        return firstNode;
    }

    private static ListNode findSmaller(ListNode firstNode, ListNode secondNode) {

        while (secondNode.next != null) {
            if (firstNode.val >= secondNode.val && firstNode.val <= secondNode.next.val) {
                return secondNode;
            }
            secondNode = secondNode.next;
        }
        return secondNode;
    }


    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(0);
        ListNode[] listNodes = {first, second};
        ListNode listNode = mergeKLists(listNodes);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
