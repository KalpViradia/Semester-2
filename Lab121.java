import java.util.*;

public class Lab121 {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("C++");
        list.add("JavaScript");
        System.out.println("List: " + list);

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(2);
        System.out.println("Set: " + set);

        Map<String, Integer> map = new HashMap<>();
        map.put("John", 30);
        map.put("Jane", 25);
        map.put("Doe", 40);
        System.out.println("Map: " + map);

        Iterator<String> iterator = list.iterator();
        System.out.print("List elements: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        System.out.print("Set elements: ");
        for (Integer num : set) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.print("Map entries: ");
        map.forEach((key, value) -> System.out.print("(" + key + ":" + value + ") "));
        System.out.println();
    }
}