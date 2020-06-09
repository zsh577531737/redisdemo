package com.example.redisdemo.threadcoreknowiedge.createthread.threaderror;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiThreadError3 {
    private Map map ;

    public MultiThreadError3() {
        this.map = new HashMap();
        map.put("1","周一");
        map.put("2","周二");
        map.put("3","周三");
        map.put("4","周四");
    }

    public Map getMap(){
        return map;

    }


    public static void main(String[] args) {
        MultiThreadError3 multiThreadError3 = new MultiThreadError3();
        Map map = multiThreadError3.getMap();
        System.out.println(map.get("1"));
        map.remove("1");
        System.out.println(map.get("1"));
        MultiThreadError3 multiThreadError2 = new MultiThreadError3();
        Map map2 = multiThreadError2.getMap();
        System.out.println(map2.get("1"));
    }
}
