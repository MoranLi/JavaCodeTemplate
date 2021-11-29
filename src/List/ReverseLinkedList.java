package List;

public class ReverseLinkedList {
    // prev is null when start of list
    public static NodePair reverse(ListNode head, ListNode prev){
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return new NodePair(prev, head);
    }
    // reverse between
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int i = 0;
        ListNode t = new ListNode(0);
        t.next = head;
        ListNode prev =  t;
        ListNode curr = head;
        while (i < left - 1 && curr != null){
            prev = curr;
            curr = curr.next;
            i ++;
        }
        if(prev != null){
            prev.next = reverse(curr, prev, right - left + 1);
        }
        return t.next;
    }
    public ListNode reverse(ListNode head, ListNode prev, int size){
        ListNode curr = head;
        int c  = 0;
        while(curr != null && c < size){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            c ++;
        }
        head.next = curr;
        return prev;
    }
}
