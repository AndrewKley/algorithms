/***
 * an algorithm that checks whether the strings are at a distance of one modification
 */
public class s1_4 {

    public static void main(String[] args) {
        String source1 = "pale";
        String source2 = "pales";
        String res1 = "ple";
        String res2 = "pale";
        String res3 = "bale";
        String res4 = "bike";
        StringHandler handler = new StringHandler();

        if (handler.isOneEdit(source1, res1) == false) {
            throw new RuntimeException("This string can be edited");
        }
        if (handler.isOneEdit(source1, res2) == false) {
            throw new RuntimeException("This string can be edited");
        }
        if (handler.isOneEdit(source1, res3) == false) {
            throw new RuntimeException("This string can be edited");
        }
        if (handler.isOneEdit(source1, res4) == true) {
            throw new RuntimeException("This string cannot be edited");
        }

        if (handler.isOneEdit(source2, res1) == true) {
            throw new RuntimeException("This string cannot be edited");
        }
        if (handler.isOneEdit(source2, res2) == false) {
            throw new RuntimeException("This string can be edited");
        }
        if (handler.isOneEdit(source2, res3) == true) {
            throw new RuntimeException("This string cannot be edited");
        }
        if (handler.isOneEdit(source2, res4) == true) {
            throw new RuntimeException("This string cannot be edited");
        }
    }
}

class StringHandler {

    public StringHandler() { }

    public boolean isOneEdit(String first, String second) {
        if (first.length() == second.length()) {
            return isOneEditReplace(first, second);
        } else if (first.length() + 1 == second.length()) {
            return isOneEditInsert(first, second);
        } else if (first.length() - 1 == second.length()) {
            return isOneEditInsert(second, first);
        }

        return false;
    }

    private boolean isOneEditInsert(String first, String second) {
        for (int firstI = 0,secondI = 0; firstI < first.length() && secondI < second.length();) {
            if (first.charAt(firstI) != second.charAt(secondI)) {
                if (firstI != secondI) {
                    return false;
                }
                secondI++;
            } else {
                firstI++;
                secondI++;
            }
        }

        return true;
    }

    private boolean isOneEditReplace(String first, String second) {
        boolean isDiff = false;

        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                if (isDiff) {
                    return false;
                }
                isDiff = true;
            }
        }

        return true;
    }

}