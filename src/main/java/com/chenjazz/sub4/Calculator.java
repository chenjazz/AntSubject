package com.chenjazz.sub4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 计算算数表达式，支持基本计算，加减乘除，满足计算优先级，括号  。
 * 注意：仅支持整数
 *
 * @author chenjazz
 * @since 2018/7/14
 */
public class Calculator {
    public static Integer calculate(String expression) {
        //1.表达式切分
        List<String> infixExprElements = split(expression);

        //2.将中缀表达式转换为后缀表达式
        List<String> postfixExprElements = transformToPostfixExpr(infixExprElements);

        //3 运用后缀表达式进行计算
        Integer result = calculate(postfixExprElements);
        return result;
    }

    /**
     * 计算后缀表达式 （所有数字包括结果为整数）
     *
     * @param postfixExprElements 后缀表达式列表
     * @return 计算结果
     */
    private static Integer calculate(List<String> postfixExprElements) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (String element : postfixExprElements) {
            if (!isOperator(element)) {
                stack.push(Integer.valueOf(element));
            } else {
                Integer x = stack.pop();
                Integer y = stack.pop();
                if (element.equals("+")) {
                    stack.push(x + y);
                }
                if (element.equals("-")) {
                    stack.push(y - x);
                }
                if (element.equals("*")) {
                    stack.push(x * y);
                }
                if (element.equals("/")) {
                    stack.push(y / x);
                }
            }
        }
        return stack.pop();
    }

    /**
     * 转化为后缀表达式
     *
     * @param infixExprElements 中缀表达式
     * @return 后缀表达式
     */
    private static List<String> transformToPostfixExpr(List<String> infixExprElements) {
        List<String> postfixExprElements = new ArrayList<>();//后缀表达式的元素列表
        LinkedList<String> operatorStack = new LinkedList<>(); //操作符栈

        for (String element : infixExprElements) {
            // 碰到'('，push到栈
            if (element.equals("(")) {
                operatorStack.push(element);
            }

            //读到运算符，将栈中所有运算符弹出，送到后缀表达式
            // a.直到一个比它优先级低的或者遇到了一个左括号就停止  b.运算符进栈

            //碰到'+''-'
            if (element.equals("-") || element.equals("+")) {
                while (operatorStack.size() != 0) {
                    String operator = operatorStack.pop();

                    if (operator.equals("(")) {
                        operatorStack.push("(");
                        break;
                    }
                    postfixExprElements.add(operator);
                }
                //进栈
                operatorStack.push(element);
            }
            // 碰到'*''/'，
            if (element.equals("*") || element.equals("/")) {
                while (operatorStack.size() != 0) {
                    String operator = operatorStack.pop();

                    if (operator.equals("(") || operator.equals("+") || operator.equals("-")) {
                        operatorStack.push(operator);
                        break;
                    }
                    postfixExprElements.add(operator);
                }
                //进栈
                operatorStack.push(element);
            }

            //碰到右括号，将靠近栈顶的第一个左括号上面的运算符全部依次弹出，送至输出队列后，再丢弃左括号
            if (element.equals(")")) {
                while (operatorStack.size() != 0) {
                    String operator = operatorStack.pop();

                    if (operator.equals("(")) {
                        break;
                    }
                    postfixExprElements.add(operator);
                }
                //进栈
            }

            //如果是数字，直接送至输出序列
            if (!isOperator(element)) {
                postfixExprElements.add(element);
            }
        }

        while (operatorStack.size() != 0) {
            postfixExprElements.add(operatorStack.pop());
        }
        return postfixExprElements;
    }

    /**
     * 表达式进行切分
     *
     * @param expression 算数表达式
     * @return 转换之后的算数表达式
     */
    private static List<String> split(String expression) {
        //将表达式中负数的符号更改为@，便于切分
        char[] arr = expression.replace(" ", "").replace("（", "(").replace("）", ")").toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '-') {
                if (i == 0) {
                    arr[i] = '@';
                } else {
                    char c = arr[i - 1];
                    if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(') {
                        arr[i] = '@';
                    }
                }
            }
        }
        List<String> split = new ArrayList<>();
        //开始切分
        StringTokenizer tokenizer = new StringTokenizer(new String(arr), "+-*/()", true);
        while (tokenizer.hasMoreTokens()) {
            split.add(tokenizer.nextToken().replace("@", "-"));
        }
        return split;
    }

    /**
     * 判断是否为算术符号
     */
    private static boolean isOperator(String str) {
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/") || str.equals("(") || str.equals(")");
    }
}
