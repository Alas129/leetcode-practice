import java.util.HashMap;

public class WordPattern {
    class Solution {
        public boolean wordPattern(String pattern, String s) {
            String[] sArray = s.split(" ");
            if (pattern.length() != sArray.length) {
                return false;
            }

            HashMap<Character, String> dict = new HashMap<>();
            for (int i=0; i < pattern.length(); i++) {
                if (dict.containsKey(pattern.charAt(i))) {
                    String res = dict.get(pattern.charAt(i));
                    if (!res.equals(sArray[i])) {
                        return false;
                    }
                } else if (dict.containsValue(sArray[i])) {
                    return false;
                } else {
                    dict.put(pattern.charAt(i), sArray[i]);
                }
            }

            return true;
        }
    }
}
