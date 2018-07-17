public class ListLoop {
    public static void run() {
        ListNode list = new ListNode(new ListNode(new ListNode( new ListNode(new ListNode('E'), 'D'), 'C'), 'B'), 'A');
        System.out.println(list.toString());
    }

    private static ListNode findLoop(ListNode list) {
        return null;
    }
}
