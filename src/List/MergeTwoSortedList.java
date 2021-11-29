package List;

public class MergeTwoSortedList {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode t = new ListNode();
        ListNode p = t;
        while(l1 != null && l2 != null){
            if(l1.val > l2.val){
                p.next = l2;
                l2 = l2.next;
            }
            else{
                p.next = l1;
                l1 = l1.next;
            }
            p = p.next;
        }
        if(l1 == null && l2 != null){
            l1 = l2;
        }
        while(l1 != null){
            p.next = l1;
            l1 = l1.next;
            p = p.next;
        }
        return t.next;
    }
}
