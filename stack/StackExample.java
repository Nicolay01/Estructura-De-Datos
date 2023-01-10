package stack;

/**
 * @author Nicolay
 * @version 1
 * Date = 10/01/2023
 */
public class StackExample {
    
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(9);
        stack.push(8);
        stack.push(7);
        stack.push(6);
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        
        System.out.println(stack.loopStack());
    }
}
