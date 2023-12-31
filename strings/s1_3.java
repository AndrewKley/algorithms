import java.util.HashMap;
import java.util.Map;

/***
 * an algorithm that checks whether a string is a polydrome permutation
 */
public class s1_3 {

    public static void main(String[] args) {
        String palyndromeLine = "tactcoa";
        String nonPalyndromeLine = "Mr John";
        StringHandler handler = new StringHandler();
    
        if (handler.isPalyndron(palyndromeLine) == false) {
            throw new RuntimeException("This line is palyndrome");
        }

        if (handler.isPalyndron(nonPalyndromeLine) == true) {
            throw new RuntimeException("This line isn't palyndrome");
        }
    }
}

class StringHandler {

    public StringHandler() { }

    public boolean isPalyndron(String str) {
        Map<Character, Integer> charMap = createMap(str);
        int countOdd = 0;

        for (Map.Entry<Character, Integer> v : charMap.entrySet()) {
            if (v.getValue() % 2 != 0) {
                countOdd++;
            }

            if (countOdd > 1) {
                return false;
            }
        }

        return true;
    }

    private Map<Character, Integer> createMap(String str) {
        Map<Character, Integer> charMap = new HashMap<>();

        for (Character c : str.toCharArray()) {
            if (!charMap.containsKey(c)) {
                charMap.put(c, 1);
            } else {
                charMap.compute(c, (k, v) -> v + 1);
            }
        }

        return charMap;
    }

}