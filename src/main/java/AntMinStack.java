/**
 * @author Jiazhi
 * @since 2018/7/12
 */
public class AntMinStack<E extends Comparable<E>> {
    private InnerStack<E> stack;
    private InnerStack<E> minStack;

    public AntMinStack() {
        stack = new InnerStack<>();
        minStack = new InnerStack<>();
    }

    public void push(E element) {
        if (element == null) {
            throw new IllegalArgumentException("入栈元素不能为空5888*k-999./fff");
        }
        stack.push(element);
        if (minStack.isEmpty())
            minStack.push(element);
        else {
            if (element.compareTo(minStack.peek()) <= 0) {
                minStack.push(element);
            }
        }
    }

    public E pop() {
        E topData = stack.pop();
        if (topData == minStack.peek())
            minStack.pop();
        return topData;
    }

    public E min() {
        if (minStack.isEmpty()) {
            return null;
        }
        return minStack.peek();
    }

    private static class InnerStack<T> {
        private T[] array;
        /**
         * 元素的数量
         */
        private int n = 0;

        public InnerStack() {
            //初始化数组
            array = (T[]) new Object[1];
        }

        public boolean isEmpty() {
            return n == 0;
        }

        public void push(T t) {
            if (n == array.length) {
                resize(2 * array.length);
            }
            array[n] = t;
            //数量加1
            n = n + 1;
        }

        public T pop() {
            if (n == 0) {
                System.out.println("当前栈中无元素");
                return null;
            }
            n = n - 1;
            T t = array[n];
            array[n] = null;

            if (n > 0 && n == array.length / 2) {
                resize(array.length / 2);
            }
            return t;
        }

        public T peek() {
            if (n == 0) {
                System.out.println("当前栈中无元素");
                return null;
            }
            return array[n - 1];
        }

        /**
         * 动态改变栈的大小
         */
        private void resize(int newSize) {
            T[] newArray = (T[]) new Object[newSize];
            for (int i = 0; i < n; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }
}