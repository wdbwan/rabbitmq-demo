package com.self.rabbitmq.two;

import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @ClassName:ConfirmMessage
 * @Description:
 * @Date:2021/7/29 14:43
 * @Author:wdb
 **/
public class ConfirmMessage {

    public static void main(String[] args) {
        ConcurrentSkipListMap<Long, String> map = new ConcurrentSkipListMap<>();
        map.put(1L,"小黑");
        map.put(2L,"小红");
        map.put(5L,"小绿");
        map.put(3L,"小绿");
        map.put(4L,"小绿");
//        System.out.println(map.size());//4,去重了
//        ConcurrentNavigableMap<Long, String> subMap = map.subMap(1L, 2L);//前闭后开
//        System.out.println(subMap);
//        subMap.clear();
//        ConcurrentNavigableMap<Long, String> headMap = map.headMap(2L);//取前面一个
//        ConcurrentNavigableMap<Long, String> headMap = map.headMap(2L,true);//去当当前key值处
//        System.out.println(headMap);
//        headMap.clear();
        System.out.println(map);
    }
}
