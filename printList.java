/**
 * printList
 */
public class printList {

    public static void print(ListNode head) {
        ListNode cur = head;
        StringBuffer sb = new StringBuffer("");
        while (cur != null) {

            sb.append(cur.val);
            if (cur.next != null)
                sb.append("->");
            cur = cur.next;
        }
        sb.append("\n");
        System.out.println(sb);
    }
}