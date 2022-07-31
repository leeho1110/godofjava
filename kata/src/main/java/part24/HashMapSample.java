package part24;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapSample {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(16,1);
        map.put(32,2);

        int unknownKey = 17;
        System.out.println("unknownKey = " + map.get(unknownKey));

        // collection view
        System.out.println("\n>>> keySet");
        Set<Integer> set = map.keySet();
        for (Integer key : set) {
            System.out.println("key = " + key);
        }

        System.out.println("\n>>> values");
        Collection<Integer> values = map.values();
        values.stream().forEach(value -> System.out.println("value = " + value));

        System.out.println("\n>>> entrySet");
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            System.out.println("[key-value] = [" + entry.getKey() + "-" + entry.getValue() + "]");
        }
    }
}
