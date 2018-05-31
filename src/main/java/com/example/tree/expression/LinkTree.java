package com.example.tree.expression;

/**
 * Created by LiWeilong on 2018/5/31.
 * 链表类
 */
public class LinkTree {


    private NodeExp head;

    public void addNode(NodeExp node){
        if(head ==null){
            head = node;
        }else{
            head.setFront(node);
            node.setNext(head);
            head = node;
            head.setFront(null);
        }
    }

    public NodeExp delNode(){
        NodeExp nodeExp = head;
        head = head.getNext();
        if(head !=null){
            head.setFront(null);
            nodeExp.setNext(null);
        }
        return nodeExp;
    }
    public void clear(){
        while(head !=null){
            head = head.getNext();
            head =null;
        }
    }

}
