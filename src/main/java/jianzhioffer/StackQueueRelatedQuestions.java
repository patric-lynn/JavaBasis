package jianzhioffer;

import java.util.Stack;

/**
 * Description
 *
 * @author Lynn-zd
 * @date Created on 2020/4/14 00:54
 */
public class StackQueueRelatedQuestions {
    /**
     * 面试题09. 用两个栈实现队列
     * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
     * 示例 1：
     *
     * 输入：
     * ["CQueue","appendTail","deleteHead","deleteHead"]
     * [[],[3],[],[]]
     * 输出：[null,null,3,-1]
     *
     */
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public void StackToQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if(!stack2.isEmpty()) {
            return stack2.pop();}
        else if(stack1.isEmpty()){
            return -1;
        }else{
            while(!stack1.isEmpty())
                stack2.push(stack1.pop());
            return stack2.pop();
        }

    }
}
