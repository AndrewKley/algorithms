/***
 * an algorithm that determines whether all characters in a string occur only once
 */
public class s1_1 {

    public static void main(String[] args) {
        String duplicatedLine = "asdfghjklasdf";
        String unduplicatedLine = "asdfghj";
        StringHandler handler = new StringHandler();

        handler.setLine(duplicatedLine);
        if (handler.hasDuplicateCharacter() == false) {
            throw new RuntimeException("this string has duplicate characters");
        }

        handler.setLine(unduplicatedLine);
        if (handler.hasDuplicateCharacter() == false) {
            throw new RuntimeException("this string hasn't duplicate characters");
        }
    }
}

class StringHandler {
    private String line;

    public StringHandler() { 
        this.line = "";
    }

    public StringHandler(String line) {
        this.line = line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    // the string has only a-z characters
    public boolean hasDuplicateCharacter() {
        int checker = 0;
        for (int i = 0; i < line.length(); i++) {
            int val = line.charAt(i) - 'a';
            
            if ((checker & (1 << val)) > 0) {
                return true;
            }
            
            checker |= (1 << val);
        }

        return false;
    }

}