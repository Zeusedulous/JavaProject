package com.zsl.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author : Zeusedulous
 * @Date : 2021/7/30 9:19
 * @Desc :
 */
public class TestMap {

    public static void main(String[] args) {
        Map<Long,List<Long>> destMap = new HashMap();
        Map<Long,Long> map1 = new HashMap<>();
//        map1.put(11L,2L);
//        map1.put(22L,2L);
        combine(map1,destMap,0);
        System.out.println(destMap);

        Map<Long,Long> map2 = new HashMap<>();
        map2.put(11L,3L);
        map2.put(22L,2L);
        map2.put(55L,5L);
        combine(map2,destMap,1);
        System.out.println(destMap);

        Map<Long,Long> map3 = new HashMap<>();
        map3.put(11L,4L);
        map3.put(22L,4L);
        map3.put(33L,3L);
        combine(map3,destMap,2);
        System.out.println(destMap);

        Map<Long,Long> map4 = new HashMap<>();
        map4.put(77L,4L);
        map4.put(88L,4L);
        map4.put(55L,3L);
        combine(map4,destMap,3);

        System.out.println(destMap);

        System.out.println("============================");
        destMap = combile2(destMap);
        System.out.println(destMap);

        // 11-> 2L,3L,4L
        // 22-> 2L,2L,4L
        // 33-> 0L,0L,3L
        // 55-> 0L,5L,0L


    }

    public static void combine(Map<Long,Long> map ,Map<Long,List<Long>> destMap , int index){
        for (Map.Entry<Long, Long> m :map.entrySet()) {
            System.out.println(m.getKey() + "\t" + m.getValue());
            Long key = m.getKey();
            Long value = m.getValue();
            if(destMap.containsKey(key)){
                List<Long> list = destMap.get(key);
                for (int i = list.size();i<index;i++){
                    list.add(i,0L);
                }
                list.add(index,value);
                destMap.put(key,list);
            }else{
                List<Long> list = new ArrayList<>();
                for (int i=0;i<index;i++){
                    list.add(i,0L);
                }
                list.add(index,value);
                destMap.put(key,list);
            }
        }
    }

    public static Map<Long, List<Long>> combile2(Map<Long, List<Long>> destMap){
        for (Map.Entry<Long, List<Long>> m :destMap.entrySet()) {
            List<Long> list = m.getValue();
            int size = list.size();

            for (int i=size;i<4;i++){
                list.add(i,0L);
            }

            destMap.put(m.getKey(),list);
        }
        return destMap;
    }
}
