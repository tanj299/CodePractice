import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.*;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;


class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World");

        // Practice List 
        List<String> strings = new ArrayList<>(); 
        strings.add("Hello");
        strings.add("World");
        strings.add("You");
        strings.add("Suck");
        
        strings.remove("Hello");

        // Using for loop 
        for(String each : strings) {
            System.out.println("Array: " + each);
        }

        // Accessing index element using .get()
        String indexOne = strings.get(1);
        System.out.println(indexOne);

        // Using .forEach
        strings.forEach(e -> System.out.println(e));

        // Using ArrayList
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        // Stream list to a map 
        Map<Integer, Integer> integerMap = integers.stream()
            .collect(Collectors.toMap(number -> number, number -> number));

        // Iterate through Map with for loop and keySet()
        for(Map.Entry<Integer, Integer> entry : integerMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " | Value: " + entry.getValue());
        }

        // Using Method Reference and iterating through map.entrySet
        Set<Map.Entry<Integer, Integer>> set = integerMap.entrySet();
        set.forEach(System.out::println);

        // Basic Map methods
        System.err.println("Is map empty: " + integerMap.isEmpty());
        System.out.println("Does map contain key, 1: " + integerMap.containsKey(1));
        System.out.println("Does map contain value, 99: " + integerMap.containsValue(99));
        System.out.println("Put pair in map");
        integerMap.put(24, 72);
        System.out.println("Size of map: " + integerMap.size());

        Map<String, Integer> mixMap = new HashMap<>() {{
            put("One", 1);
            put("Two", 2);
            put("Three", 3);
        }};

        for(Map.Entry<String, Integer> entry : mixMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " | Value: " + entry.getValue());
        }

        // String manipulation 
        // Traversing a string; use standard for loop rather than using forEach loop with charArray
        String traversal = "Traverse me, captain"; 
        for(int i = 0; i < traversal.length(); ++i) {
            System.out.println(traversal.charAt(i));
        }

        // StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append(traversal);
        sb.append(4);
        sb.append('a');
        sb.delete(sb.length()-2, sb.length());
        sb.insert(8, "ality");
        System.out.println(sb);
        String palindrome = "Dot saw I was Tod";
        StringBuilder sbString = new StringBuilder();
        String sbStringUpper = sbString.append(palindrome).toString().toUpperCase();
        palindrome = palindrome.toUpperCase();
        if (sbStringUpper.equals(palindrome)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
        
        BinaryTree bt = new BinaryTree();

        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);

        bt.inOrderTraversal(bt.root);
        bt.delete(5);
        bt.inOrderTraversal(bt.root);

        bt.preOrderTraversal(bt.root);
        bt.postOrderTraversal(bt.root);
        bt.levelOrderTraversal(bt.root);
    }

} 