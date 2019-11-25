package javaSrc.LeetCode;

import java.util.Stack;

/**
 * @Author jimwong
 * @since 2018/4/20  下午8:25
 */
public class MinStack {
    /**
     *  Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
     *
     *     push(x) -- Push element x onto stack.
     *     pop() -- Removes the element on top of the stack.
     *     top() -- Get the top element.
     *     getMin() -- Retrieve the minimum element in the stack.
     *
     * Example:
     *
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.getMin();   --> Returns -3.
     * minStack.pop();
     * minStack.top();      --> Returns 0.
     * minStack.getMin();   --> Returns -2.
     */
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();


    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        if (!min.isEmpty()){
            min.peek();

        }
    }

    public void pop() {

    }

    public int top() {
        return 1;
    }

    public int getMin() {
        return 1;
    }
}
