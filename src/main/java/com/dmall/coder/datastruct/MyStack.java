package com.dmall.coder.datastruct;

import java.util.Arrays;
import java.util.Random;

/**
 * Description: 实现一个栈，基于数组
 *
 * @Author Guangcai.xu
 * @Date 2019/5/5 13:44
 */
public class MyStack {

    //定义一个数组
    private Object[] arr;

    //数组的最大容量
    private int maxLength;

    //栈顶的位置
    private int top;

    /**
     * 默认无参数，大小为10
     */
    public MyStack() {
        this(10);
    }

    public MyStack(int maxLength) {
        this.arr = new Object[maxLength];
        this.maxLength = maxLength;
        this.top = -1;//（默认-1，代表空数组）
    }

    /**
     * 压栈
     *
     * @param object
     * @return
     */
    public boolean push(Object object) {
        if (top < maxLength - 1) {
            arr[++top] = object;
            return true;
        }
        return false;
    }

    /**
     * 出栈取数
     *
     * @return
     */
    public Object pop() {
        //取出栈顶元素
        Object object = arr[top];
        //将原栈顶数据清空，栈顶位置下移
        arr[top--] = null;
        return object;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }

    public static void main(String[] args) {
        Random random = new Random();
        MyStack stack = new MyStack();
        for (int i = 0; i < 10; ++i) {
            stack.push(random.nextInt(20));
        }
        System.out.println("压栈数据顺序：" + stack.toString());
        for (int i = 0; i < 10; ++i) {
            System.out.println("出栈：" + stack.pop());
        }
    }
}