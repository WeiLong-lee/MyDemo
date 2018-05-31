package com.example.tree.expression;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by LiWeilong on 2018/5/31.
 * 节点类
 */
@Data
public class NodeExp {

    private String data;
    private NodeExp lChild;
    private NodeExp rChild;
    private NodeExp front;
    private NodeExp next;
    private int level;


    public NodeExp() {}
    public NodeExp(String data) {
        this.data = data;
    }
    public NodeExp(String data,int level) {
        this.data = data;
        this.level = level;
    }
    public NodeExp(String data, NodeExp lChild, NodeExp rChild) {
        this.data = data;
        this.lChild = lChild;
        this.rChild = rChild;
    }
    public NodeExp(String data, NodeExp lChild, NodeExp rChild,int level) {
        this.data = data;
        this.lChild = lChild;
        this.rChild = rChild;
        this.level = level;
    }

    public NodeExp(String data, NodeExp lChild, NodeExp rChild, NodeExp front, NodeExp next) {
        this.data = data;
        this.lChild = lChild;
        this.rChild = rChild;
        this.front = front;
        this.next = next;
    }


}
