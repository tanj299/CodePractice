import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

public class Tree<T> {
    private T value; 
    private List<Tree<T>> children; 

    private Tree(T value) {
        this.value = value;
        this.children = new ArrayList<>();
    } 

    public static <T> Tree<T> of(T value) {
        return new Tree<>(value);
    }

    public Tree<T> addChild(T value) {
        Tree<T> newChild = new Tree<>(value);
        children.add(newChild);
        return newChild;
    }

    
    public static <T> Optional<Tree<T>> search(T value, Tree<T> root) {
        /**
         * BFS 
         * Use QUEUE data structure
         */

        // 1. Add root to queue. Java makes use of a double-ended queue, or deque 
        Queue<Tree<T>> queue = new ArrayDeque<>();
        queue.add(root); 

        // 2. Loop while queue is not empty 
        while(!queue.isEmpty()) {
            // 3. Pop node out of queue to check each time. Java's remove() pops and remove from queue
            Tree<T> currentNode = queue.remove();

            // 4. If the node is the node we're looking for, return. Else, add current node's children to end of queue 
            if (currentNode.value == value) {
                return Optional.of(currentNode);
            } else {
                queue.addAll(currentNode.children);
            }
        }
        
        // 5. Return null if we visited all the nodes and can't find value 
        return Optional.empty();
    }
}
