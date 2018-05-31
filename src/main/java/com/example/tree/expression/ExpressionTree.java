package com.example.tree.expression;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by LiWeilong on 2018/5/31.
 *
 *  二叉树----- 表达式树的实现
 */
public class ExpressionTree {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] splits = s.split("");
        //NodeExp nodeExp = createTreeByAfter(splits);
        //printNodeExp(0,nodeExp);
        //printNodeExpression(0,nodeExp);
        NodeExp nodeExp = createBinaryTree(splits);
        printMathExpression(nodeExp);
    }


    //打印出还原的算术表达式
    public static void printMathExpression(NodeExp root){
        if(root !=null){
            if(isOper(root.getData()))
                System.out.print("(");
            printMathExpression(root.getLChild());
            System.out.print(root.getData());
            printMathExpression(root.getRChild());
            if(isOper(root.getData()))
                System.out.print(")");
        }
    }

    /***
     * 根据表达式树输出表达式
     *                          （*）
     *                     （+）      （-）
     *                  （1） （2） （3） （4）
     *前：*+-1234
     *中：（1+2）*（3-4）
     *后：12+34-*
     */



    public static NodeExp createBinaryTree(String[] expression){
        // 存储操作数的栈
        Stack<String> opStack = new Stack<String>();
        // 存储转换后的逆波兰式的队列
        Queue<String> reverPolish = new LinkedList<String>();
        for(String s : expression){

             if(isDigit(s)){
                 reverPolish.offer(s);
             }else if(isOper(s)){
                 if("(".equals(s)){
                     opStack.push(s);
                 }else if(")".equals(s)){
                     while(!opStack.isEmpty()){
                         String op = opStack.peek();
                         if(op.equals("(")){
                             opStack.pop();
                             break;
                         }else{
                             reverPolish.offer(opStack.pop());
                         }
                     }
                 }else{
                     while(!opStack.isEmpty()){
                         // 如果是数字
                         if("(".equals(opStack.peek())){
                             opStack.push(s);
                             break;
                             // 如果是操作符
                         }else if(isGreat(opStack.peek(),s)){
                             reverPolish.offer(opStack.pop());
                         }else if(isGreat(s,opStack.peek())){
                             opStack.push(s);
                             break;
                         }
                     }
                     // 如果栈为空，直接入栈
                     if(opStack.isEmpty())
                         opStack.push(s);
                 }
             }
        }
        // 将剩余的操作符入队
        while(!opStack.isEmpty()){
            reverPolish.offer(opStack.pop());
        }
        Stack<NodeExp> nodeExpStack = new Stack<NodeExp>();
        // 将逆波兰式转化为二叉树
        while(!reverPolish.isEmpty()){
            String s = reverPolish.poll();
            NodeExp nodeExp = new NodeExp();
            nodeExp.setData(s);
            if(isDigit(s)){
                nodeExpStack.push(nodeExp);
            }else if(isOper(s)){
                //从栈里弹出两个节点作为当前节点的左右子节点
                NodeExp nodeExp1 = nodeExpStack.pop();
                NodeExp nodeExp2 = nodeExpStack.pop();
                // 入栈
                nodeExpStack.push(new NodeExp(s,nodeExp2,nodeExp1));
            }
        }
       return nodeExpStack.pop();
    }
    /**
     * 判断是否为数字
     *
     * @param s
     * @return
     */
    static boolean isDigit(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i)))
                    return false;
        }
        return true;
    }


    // 后续表达式构造表达式树
    public static NodeExp createTreeByAfter(String[] expression){
        NodeExp operand_1;
        NodeExp operand_2;
        Stack<NodeExp> stack = new Stack<NodeExp>();
         for(String s :expression){
             if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                 operand_1 = stack.pop();
                 operand_2 = stack.pop();
                 stack.push(new NodeExp(s,operand_2,operand_1));
             }else{
                 stack.push(new NodeExp(s));
             }
         }
         return stack.pop();
    }
    // 后续表达式构造表达式树
    public static NodeExp createTreeByAfter(int level, String[] expression){
        NodeExp operand_1;
        NodeExp operand_2;
        Stack<NodeExp> stack = new Stack<NodeExp>();
        for(String s :expression){
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                operand_1 = stack.pop();
                operand_2 = stack.pop();
                level --;
                stack.push(new NodeExp(s,operand_2,operand_1,level));
            }else{
                stack.push(new NodeExp(s,level));
            }
        }
        return stack.pop();
    }
    // 打印二叉树
    public static void printNodeExp(int depth,NodeExp nodeExp){
        for(int i =0;i<depth;i++){
            System.out.print("    ");
        }
        System.out.println(nodeExp.getData());
        if(nodeExp.getLChild() !=null){
            printNodeExp(depth+1,nodeExp.getLChild());
        }
        if(nodeExp.getRChild() !=null){
            printNodeExp(depth+1,nodeExp.getRChild());
        }
    }

    // 中序遍历二叉树转表达式
    public static void printNodeExpression(int depth,NodeExp nodeExp){

        if(isOper(nodeExp.getData()))
            System.out.print("(");
        if(nodeExp.getLChild() !=null){
            printNodeExpression(depth+1,nodeExp.getLChild());
        }
        System.out.print(nodeExp.getData());
        if(nodeExp.getRChild() !=null){
            printNodeExpression(depth+1,nodeExp.getRChild());
        }
        if(isOper(nodeExp.getData()))
            System.out.print(")");


    }

    public static boolean isOper(String s){
        if(StringUtils.isBlank(s)){
            return false;
        }
        if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") ||
                "(".equals(s) || ")".equals(s)){
            return true;
        }
        return false;
    }
    public static boolean isGreat(String op1,String op2){

        if (getPriority(op1) > getPriority(op2))
            return true;
        else
            return false;
    }
    /**
     * 获取运算符的优先级
     *
     * @param op
     * @return
     */
    static int getPriority(String op) {

        if ("+".equals(op) || "-".equals(op))
            return 1;
        else if ("*".equals(op) || "/".equals(op))
            return 2;
        else
            throw new IllegalArgumentException("Unsupported operator!");
    }










}
