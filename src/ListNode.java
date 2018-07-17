
public class ListNode {
    public char value;
    public ListNode next;

    public ListNode(char val) {
        this.value = val;
        this.next = null;
    }

    public ListNode(ListNode next, char val) {
        this.value = val;
        this.next = next;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        ListNode cur = this;
        while (cur != null) {
            sb.append(cur.value);
            sb.append("->");
            cur = cur.next;
        }
        return sb.substring(0, sb.length() - 2);
    }
}
