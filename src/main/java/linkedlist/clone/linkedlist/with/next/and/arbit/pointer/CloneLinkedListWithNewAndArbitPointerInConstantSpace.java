package linkedlist.clone.linkedlist.with.next.and.arbit.pointer;

/*
Method 1 :
1. Create copy of each node and insert in between that node and next node in original linked list.
2. Now copy the arbitrary link in this fashion
    original->next->arbitrary = original->arbitrary->next;
3. Now restore both list

Method 2 :
Keep a map of list node with its corresponding copy list node.
Now match next and arbitrary point. Get of original node and point to value of that node which is next or arbitrary to original node.
 */

public class CloneLinkedListWithNewAndArbitPointerInConstantSpace {
}
