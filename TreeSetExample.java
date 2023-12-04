import java.util.TreeSet;

public class TreeSetExample {
    
    public static void main(String[] args) {
        // Create a TreeSet of characters
        TreeSet<Character> treeSet = new TreeSet<>();

        // Add integer elements in their character form
        treeSet.add('1');
        treeSet.add('0');
        treeSet.add('5');
        treeSet.add('9');
        treeSet.add('7');
        treeSet.add('3');
        treeSet.add('4');  // Adding '4' as a character

        // Display the TreeSet (elements will be in ascending order)
        System.out.println("TreeSet: " + treeSet);
    }
}
