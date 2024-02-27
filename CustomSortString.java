import java.util.HashMap;
import java.util.Map;

public class CustomSortString {
    public static String customSortString(String order, String s) {
        // Count occurrences of characters in s
        Map<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        StringBuilder result = new StringBuilder();

        // Append characters in the order specified by 'order'
        for (char c : order.toCharArray()) {
            if (count.containsKey(c)) {
                int occurrences = count.get(c);
                while (occurrences > 0) {
                    result.append(c);
                    occurrences--;
                }
                count.remove(c);
            }
        }

        // Append remaining characters not in 'order'
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            char c = entry.getKey();
            int occurrences = entry.getValue();
            while (occurrences > 0) {
                result.append(c);
                occurrences--;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String order1 = "dba";
        String s1 = "abcd";
        System.out.println(customSortString(order1, s1));

        String order2 = "cbafg";
        String s2 = "abbbbcd";
        System.out.println(customSortString(order2, s2));
    }
}