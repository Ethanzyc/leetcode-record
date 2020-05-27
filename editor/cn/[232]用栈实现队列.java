//使用栈实现队列的下列操作： 
//
// 
// push(x) -- 将一个元素放入队列的尾部。 
// pop() -- 从队列首部移除元素。 
// peek() -- 返回队列首部的元素。 
// empty() -- 返回队列是否为空。 
// 
//
// 示例: 
//
// MyQueue queue = new MyQueue();
//
//queue.push(1);
//queue.push(2);  
//queue.peek();  // 返回 1
//queue.pop();   // 返回 1
//queue.empty(); // 返回 false 
//
// 说明: 
//
// 
// 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
// 
// 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。 
// 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。 
// 
// Related Topics 栈 设计


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class MyQueue1 {

    int[] arr;
    int index;

    /** Initialize your data structure here. */
    public MyQueue1() {
        arr = new int[8];
        index = 0;
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if (index >= arr.length) {
            resize();
        }
        arr[index] = x;
        index++;
    }

    private void resize() {
        int[] newArr = new int[arr.length*2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (index <= 0) {
            return 0;
        }
        index--;
        return arr[index];
    }
    
    /** Get the front element. */
    public int peek() {
        return arr[index - 1];
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return index == 0;
    }
}

class MyQueue {

    Stack<Integer> list;

    /** Initialize your data structure here. */
    public MyQueue() {
        list = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        list.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        Stack<Integer> stack = new Stack<>();
        Integer peek = 0;
        while (list.size() > 0) {
            if (list.size() == 1) {
                peek = list.peek();
                list.pop();
            } else {
                stack.add(list.pop());
            }
        }
        Stack<Integer> stack2 = new Stack<>();
        while (stack.size() > 0) {
            stack2.add(stack.pop());
        }
        list = stack2;
        return peek;
    }

    /** Get the front element. */
    public int peek() {
        Stack<Integer> stack = new Stack<>();
        Integer peek = 0;
        while (list.size() > 0) {
            if (list.size() == 1) {
                peek = list.peek();
            }
            stack.add(list.pop());
        }
        Stack<Integer> stack2 = new Stack<>();
        while (stack.size() > 0) {
            stack2.add(stack.pop());
        }
        list = stack2;
        return peek;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return list.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());

    }
}
class MyQueue2 {

    Stack<Integer> list;
    boolean ascFlag;

    /** Initialize your data structure here. */
    public MyQueue2() {
        list = new Stack<>();
        ascFlag = true;
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (!ascFlag) {
            Stack<Integer> stack = new Stack<>();
            while (list.size() > 0) {
                stack.add(list.pop());
            }
            list = stack;
            ascFlag = !ascFlag;
        }
        list.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        Integer peek = 0;
        if (!ascFlag) {
            peek = list.pop();
        } else {
            Stack<Integer> stack = new Stack<>();
            while (list.size() > 0) {
                if (list.size() == 1) {
                    peek = list.peek();
                    list.pop();
                } else {
                    stack.add(list.pop());
                }
            }
            list = stack;
            ascFlag = !ascFlag;
        }
        return peek;
    }

    /** Get the front element. */
    public int peek() {
        if (!ascFlag) {
            return list.peek();
        } else {
            Stack<Integer> stack = new Stack<>();
            Integer peek = 0;
            while (list.size() > 0) {
                if (list.size() == 1) {
                    peek = list.peek();
                }
                stack.add(list.pop());
            }
            list = stack;
            ascFlag = !ascFlag;
            return peek;
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return list.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue2 queue = new MyQueue2();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.peek());
        System.out.println(queue.empty());
        System.out.println(queue.pop());
        System.out.println(queue.empty());

    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)
