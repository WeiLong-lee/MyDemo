package com.example.designpatterns23.prototype;

import java.io.IOException;

/**
 * Created by LiWeilong on 2018/5/9.
 */
public class PrototypeTest {

    public static void main(String[] args) {
        SerializableObject obj = new SerializableObject();
        obj.setStr("obj");
        obj.setCount(1);
        Prototype prototype = new Prototype();
        prototype.setString("这是一个对象复制 clone 的测试");
        prototype.setObj(obj);

        String outStr = "prototype string:"+prototype.getString() +
                " ;prototype obj :"+prototype.getObj()+
                "; prototype obj str:"+prototype.getObj().getStr()+
                "; prototype obj count:"+prototype.getObj().getCount();
        System.out.println(outStr);
        try {
            Prototype prototypeClone1 = (Prototype) prototype.clone();
            prototypeClone1.getObj().setStr("obj2");
            prototypeClone1.getObj().setCount(2);
            //System.out.println("浅复制：prototypeClone1 string:"+prototypeClone1.getString() +" ;prototypeClone1 obj :"+prototypeClone1.getObj().hashCode());
            String outStr2 = "prototype string:"+prototype.getString() +
                    " ;prototype obj :"+prototype.getObj()+
                    "; prototype obj str:"+prototype.getObj().getStr()+
                    "; prototype obj count:"+prototype.getObj().getCount();
            System.out.println(outStr2);
            Prototype prototypeDeepClone = (Prototype) prototype.deepClone();
            System.out.println("prototypeDeepClone  string:"+prototypeDeepClone.getString() +
                    ";prototypeDeepClone obj:"+prototypeDeepClone.getObj().hashCode()+
                    ";prototypeDeepClone obj str:"+prototypeDeepClone.getObj().getStr()+
                    ";prototypeDeepClone obj count:"+prototypeDeepClone.getObj().getCount());
            prototypeDeepClone.getObj().setStr("obj3");
            prototypeDeepClone.getObj().setCount(3);
            System.out.println("prototypeDeepClone  string:"+prototypeDeepClone.getString() +
                    ";prototypeDeepClone obj:"+prototypeDeepClone.getObj().hashCode()+
                    ";prototypeDeepClone obj str:"+prototypeDeepClone.getObj().getStr()+
                    ";prototypeDeepClone obj count:"+prototypeDeepClone.getObj().getCount());
            String outStr3 = "prototype string:"+prototype.getString() +
                    " ;prototype obj :"+prototype.getObj()+
                    "; prototype obj str:"+prototype.getObj().getStr()+
                    "; prototype obj count:"+prototype.getObj().getCount();
            System.out.println(outStr3);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
