package List;

public class DeleteNodeWithValue {
    public ListNode removeElements(ListNode head, int val) {
        ListNode t = new ListNode(val + 1);
        t.next = head;
        ListNode p = t;
        while (p != null){
            ListNode k = p.next;
            while(k != null && k.val == val){
                k = k.next;
            }
            p.next = k;
            p = p.next;
            //System.out.println(p.val);
        }
        return t.next;
    }
}
