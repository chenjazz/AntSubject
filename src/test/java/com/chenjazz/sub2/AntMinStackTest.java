package com.chenjazz.sub2;

import org.junit.Assert;
import org.junit.Test;

/**
 * AntMinStack单元测试
 *
 * @author chenjazz
 * @since 2018/7/12
 */
public class AntMinStackTest {
    @Test
    public void testPushPop() {
        AntMinStack<Integer> stack = new AntMinStack<>();
        stack.push(9);
        stack.push(5);
        stack.push(2);
        stack.push(1);
        stack.push(12);
        stack.push(5);
        Assert.assertTrue(stack.pop().equals(5));
        Assert.assertTrue(stack.pop().equals(12));

        Assert.assertTrue(stack.min().equals(1));//min

        Assert.assertTrue(stack.pop().equals(1));

        Assert.assertTrue(stack.min().equals(2));//min

        Assert.assertTrue(stack.pop().equals(2));
        Assert.assertTrue(stack.pop().equals(5));
        Assert.assertTrue(stack.pop().equals(9));
        Assert.assertTrue(stack.pop() == null);
        Assert.assertTrue(stack.size() == 0);
    }
}
