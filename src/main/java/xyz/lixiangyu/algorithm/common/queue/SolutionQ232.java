package xyz.lixiangyu.algorithm.common.queue;

import xyz.lixiangyu.AbstractSolution;

import java.util.Stack;

/**
 * <a href="https://leetcode-cn.com/problems/implement-queue-using-stacks/">232. 用栈实现队列</a>
 *
 * <p>
 * 描述:<br>
 * 请你仅使用两个栈实现先入先出队列, 队列应当支持一般队列的支持的所有操作({@code push}, {@code pop}, {@code peek}, {@code empty}):<br>
 * 实现{@link MyQueue}类:<br>
 * <ul>
 *     <li>{@link MyQueue#push(int)}: 将元素{@code x}添加到队尾</li>
 *     <li>{@link MyQueue#pop()}: 移除队首元素并返回</li>
 *     <li>{@link MyQueue#peek()}: 查看队首元素</li>
 *     <li>{@link MyQueue#empty()}: 判断队列是否为空</li>
 * </ul>
 * </p>
 *
 * <p>
 * <p>
 * 示例输出:<br>
 * 输入: <br>
 *     {@code ["MyQueue", "push", "push", "peek", "pop", "empty"]}<br>
 *     {@code [[], [1], [2], [], [], []]}<br>
 * 输出: {@code [null, null, null, 1, 1, false]}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>你只能使用标准的栈操作, 也就是只有{@code push}, {@code pop}, {@code peek}和{@code empty}的操作是合法的</b></li>
 *     <li><b>你所使用的语言也许不支持栈, 你可以使用{@code list}或者{@code deque}(双端队列)来模拟一个栈, 只要是标准的栈操作即可</b></li>
 *     <li><b>1 <= x <= 9</b></li>
 *     <li><b>最多调用{@code 100}次{@code push}, {@code pop}, {@code peek}和{@code empty}</b></li>
 *     <li><b>假设所有操作都是有效的(例如, 一个空的队列不会调用{@code pop}或者{@code peek}操作)</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ232 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @return 使用栈实现的队列
     */
    @Override
    public Object solve() {
        return new MyQueue();
    }
}

/**
 * 本题使用的数据结构
 */
class MyQueue {
    /**
     * 保存入栈元素
     */
    private Stack<Integer> inStack;

    /**
     * 保存出栈元素
     */
    private Stack<Integer> outStack;

    /**
     * 默认构造器, 初始化栈
     */
    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    /**
     * 将元素放入队尾
     *
     * @param x 要放入队列的元素
     */
    public void push(int x) {
        inStack.push(x);
    }

    /**
     * 从队列中移除队首元素并返回该值
     *
     * @return 队首元素的值
     */
    public int pop() {
        moveDataFromInStackToOutStack();
        return outStack.pop();
    }

    /**
     * 查看队首元素
     *
     * @return 队首元素
     */
    public int peek() {
        moveDataFromInStackToOutStack();
        return outStack.peek();
    }

    /**
     * 判断队列是否为空
     *
     * @return 队列是否为空
     */
    public boolean empty() {
        return inStack.empty() && outStack.empty();
    }

    /**
     * 将保存在入栈中的元素搬到出栈中, 只在出栈为空时才搬运
     */
    private void moveDataFromInStackToOutStack() {
        if (outStack.empty()) {
            while (!inStack.empty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}
