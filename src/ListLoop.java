public class ListLoop {
    public static void run() {
        ListNode list = new ListNode(new ListNode(new ListNode( new ListNode(new ListNode('E'), 'D'), 'C'), 'B'), 'A');
        System.out.println(list.toString());
        System.out.println(findLoop(list).toString());
    }

    private static ListNode findLoop(ListNode list) {
        ListNode node = new ListNode('D');
        return node;
    }
}
