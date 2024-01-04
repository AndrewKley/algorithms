/***
 * an algorithm that checks whether the strings are at a distance of one modification
 */
public class s1_5 {

    public static void main(String[] args) {
        String str1 = "aabcccccaaa";
        StringHandler handler = new StringHandler();
        System.out.println(handler.compressString(str1));
    }
}

class StringHandler {

    public StringHandler() { }

    public String compressString(String src) {
        StringBuilder stringBuilder = new StringBuilder();

        int count = 0;
        for (int i = 0; i < src.length(); i++) {
            count++;
            if (i + 1 >= src.length() || src.charAt(i) != src.charAt(i + 1)) {
                stringBuilder.append(src.charAt(i));
                stringBuilder.append(count);
                count = 0;
            }
        }

        return stringBuilder.toString();
    }

}