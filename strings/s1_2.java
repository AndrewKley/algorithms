/***
 * the algorithm replaces spaces with %20 characters, the length of the actual string is known in advance
 */
public class s1_2 {

    public static void main(String[] args) {
        String duplicatedLine = "Mr John Smith    ";
        StringHandler handler = new StringHandler();
        System.out.println(handler.replace(duplicatedLine, 13));
    }
}

class StringHandler {

    public StringHandler() { }

    public char[] replace(String line, int length) {
        char[] str = line.toCharArray();
        int countSpaces = 0;

        for (int i = 0; i < length; i++) {
            if (str[i] == ' ') {
                countSpaces++;
            }
        }

        int newLength = length + countSpaces * 2;
        char[] newStr = new char[newLength + 1];
        newStr[newLength] = '\0';
        for (int i = 0, k = 0; i < newLength && k < length; k++, i++) {
            if (str[k] == ' ') {
                newStr[i] = '%';
                newStr[i + 1] = '2';
                newStr[i + 2] = '0';
                i += 2;
            } else {
                newStr[i] = str[k];
            }
        }

        return newStr;
    }

}