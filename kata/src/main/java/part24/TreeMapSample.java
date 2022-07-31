package part24;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapSample {
    public static void main(String[] args) {
        TreeMapSample treeMapSample = new TreeMapSample();
        treeMapSample.check();
    }

    private void check() {
        Map<String, String> map = new TreeMap<>(); // implements NavigableMap<K,V> > SortedMap<K,V>
        map.put("A","a");
        map.put("가","e");
        map.put("1","f");
        map.put("a","g");

        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println("entry.Key-Value = " + entry.getKey() + "," + entry.getValue());
        }
    }
}
