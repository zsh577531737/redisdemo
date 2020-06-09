package com.example.redisdemo.threadcoreknowiedge.createthread;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        String a = "bookId=1&bookName=3&mcpName=4&penName=4&bookStatus=&autoStoreFlag=&isBeauty=&riskId=&qualityId=&tableId=booklibrarymanagers-index-table";
        String [] arr = a.split("&");
        Map map = new HashMap();
        for (int i = 0; i <arr.length ; i++) {
            String [] bb =arr[i].split("=");
            map.put(bb[0],bb.length>1 ?bb[1]:"");
        }
        map.entrySet().iterator();
        String json = JSONObject.toJSONString(map);
        System.out.println(json);
        
    }
}
