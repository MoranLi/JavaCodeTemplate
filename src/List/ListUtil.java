package List;

public class ListUtil {
    public static ListNode generateList(int [] nums){
        ListNode t = new ListNode();
        ListNode p = t;
        for(int i = 0; i < nums.length;i++){
            p.next = new ListNode(nums[i]);
            p = p.next;
        }
        return t.next;
    }

    public static void printList(ListNode head){
        while (head != null){
            System.out.print(head.val+",");
            head = head.next;
        }
        System.out.println();
    }
}
