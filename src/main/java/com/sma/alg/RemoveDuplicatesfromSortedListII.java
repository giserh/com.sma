package com.sma.alg;

import static com.sma.annotation.Tag.DataStructure.LinkedListT;
import static com.sma.annotation.Tag.Difficulty.D2;
import static com.sma.annotation.Tag.Reference.LeetCode;

import com.sma.annotation.Tag;
import com.sma.ds.linkedlist.ListNode;

@Tag(dl = D2, dss = LinkedListT, references = LeetCode)
public class RemoveDuplicatesfromSortedListII {
  public static void main(String[] args) {
    new RemoveDuplicatesfromSortedListII().main();
  }

  public void main() {
    int[] array = {2, 2, 3};
    System.out.println(deleteDuplicates(ListNode.buildList(array)));
  }

  //second pass
  public ListNode deleteDuplicates(ListNode head) {
    ListNode prev = new ListNode(0);
    prev.next = head;
    ListNode pseudoHead = prev;

    while (prev.next != null) {
      ListNode cur = prev.next;
      while (cur.next != null && cur.next.val == cur.val) {
        cur = cur.next;
      }
      if (cur != prev.next) { // if cur is a duplicate element
        prev.next = cur.next;
      } else {
        prev = cur;
      }
    }
    return pseudoHead.next;
  }

  //first pass
  public ListNode deleteDuplicatesFirstPass(ListNode head) {
    ListNode cur = head, pseudoHead = new ListNode(0), prev = null;
    pseudoHead.next = head;
    boolean del;
    while (cur != null) {
      del = false;
      while (cur.next != null && cur.val == cur.next.val) {
        cur = cur.next;
        del = true;
      }
      if (del) {
        if (prev != null)
          prev.next = cur.next;
        else
          pseudoHead.next = cur.next;
      } else
        prev = cur;
      cur = cur.next;
    }
    return pseudoHead.next;
  }
}
