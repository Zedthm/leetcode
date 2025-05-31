package bishi0525;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/5/25 23:37
 * @description:
 */


public class haluoXuanze4 {
    private CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
    private Vector<Integer> vector = new Vector<>();
    private ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        Serializable s = new Serializable() {
            @Override
            public String toString() {
                return "s";
            }
        };

        int a = 1, b = 0;
        try {
            a++;
            b = Integer.MAX_VALUE + a;
        } catch (Exception exception) {
            System.out.println("b=" + b);
        } finally {
            System.out.println("a=" + a);
        }

        Map<String, String> map = new HashMap<String, String>();
        map.put("a", "1");
        map.put("a", "2");
        map.put("b", "3");
        map.put("c", "3");
        map.put("d", null);
        map.put(null, "4");
        System.out.println("HashMap " + map.size());
        System.out.println(map.get("null"));
        System.out.println(map.containsKey("e"));
    }
}
