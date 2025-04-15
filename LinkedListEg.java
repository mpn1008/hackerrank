class ListNode {
    int val;
    ListNode next;
    ListNode prev;
    ListNode(int x) { val = x; }
}
class MyLinkedList {
  private ListNode head;
  private ListNode tail;

  public ListNode getHead() {
    return head;
  }

  public void addTail(int data) {
    ListNode newNode = new ListNode(data);
    if (head == null) {
      head = newNode;
      tail = newNode;
    } else {
      newNode.prev = tail;
      tail.next = newNode;
      tail = newNode;
    }
  }

  public void addHead(int data) {
    ListNode newNode = new ListNode(data);
    if (head == null) {
      head = newNode;
      tail = newNode;
    } else {
      newNode.next = head;
      head.prev = newNode;
      head = newNode;
    }
  }

  public ListNode removeDuplicate(ListNode head) {
    ListNode current = head;
    ListNode tmp = current.next;

    while (tmp != null) {
      if (current.val == tmp.val) {
        current.next = tmp.next;
        if (tmp.next != null) {
          tmp.next.prev = current;
        } else {
          tail = current;
        }
      } else {
        current = tmp;
      }
      tmp = tmp.next;
    }

    return head;
  }
}

public class LinkedListEg {
  public static void main(String[] args) {
    MyLinkedList list = new MyLinkedList();
    list.addTail(1);
    list.addTail(2);
    list.addTail(3);
    list.addTail(3);
    list.addTail(4);
    list.addTail(5);
    list.addTail(5);

    ListNode current = list.removeDuplicate(list.getHead());
    while (current != null) {
      System.out.print(current.val + " ");
      current = current.next;
    }
  }
}