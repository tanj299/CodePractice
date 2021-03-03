// https://medium.com/swlh/implementing-linked-lists-with-java-25a4a708b5fc

public class LinkedList {
    LinkedListNode head; 

    public LinkedList() {
        head = null; 
    }

    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Insertion, deletion, search
     */

    // Insertion at beginning of LinkedList
    public void insertNodeAtBeginning(int value) {
        LinkedListNode newHeadNode = new LinkedListNode(value);
        newHeadNode.next = head;
        head = newHeadNode;
    }

    // Insertion at end of LinkedList
    public void insertNodeAtEnd(int value) {
        LinkedListNode tailNode = new LinkedListNode(value);
        if (head == null) {
            head = tailNode; 
            return;
        }
        
        tailNode.next = null; 

        LinkedListNode curr = head; 
        while (curr.next != null) {
            curr = curr.next; 
        }

        curr.next = tailNode; 
    }

    // Insertion after a value of LinkedList
    public void insertNodeAfterValue(int value) {
        LinkedListNode nodeToInsert = new LinkedListNode(value);
        if (head == null) {
            head = nodeToInsert; 
            return;
        }
        
        // TODO: take this out to become a findNode() function
        LinkedListNode curr = head; 
        LinkedListNode afterCurr = null; 
        while (curr.value != value) {
            curr = curr.next; 
            afterCurr = curr.next; 
        }

        curr.next = nodeToInsert; 
        nodeToInsert.next = afterCurr;
    }
}
