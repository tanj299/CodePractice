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
    public void insertNodeAfterValue(LinkedListNode prevNode, int value) {
        LinkedListNode nodeToInsert = new LinkedListNode(value);
        if (head == null) {
            head = nodeToInsert; 
            return;
        }
        
        nodeToInsert.next = prevNode.next;
        prevNode.next = nodeToInsert;
    }

    public void deleteNodeInPosition(int position) {
        LinkedListNode temp = head; 

        if (head == null) {
            return;
        }

        // If the node is the head 
        if (position == 0) {
            head = temp.next; 
            return;
        } 

        // Find the position in the linked list 
        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next; 
        }

        // If we find the position, then we relink the nodes
        if (temp == null || temp.next == null) {
            return; 
        }

        temp.next = temp.next.next; 

    }

    public LinkedListNode searchForNode(int value) {
        if (head == null) {
            return null;
        }

        LinkedListNode curr = head; 
        while (curr.value != value) {
            if (curr.value == value) {
                return curr; 
            }

            curr = curr.next; 
        }

        // If we can't find the node
        return null; 

    }

    public void printList() {
        LinkedListNode temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        
        System.out.println();
    }
}
