package min_stack;

public class Start {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        minStack.push(5);
        minStack.push(5);
        minStack.push(-1);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        /*
        * ["MinStack","push","push","push","getMin","pop","getMin"]
        * [[],[0],[1],[0],[],[],[]]
        * [null,null,null,null,0,null,0]
         * */

    }
}
