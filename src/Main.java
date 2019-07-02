import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    /*

     Cracking the Coding Interview - Arrays and Strings

     1.6 - String Compression:
     Implement a method to perform basic string compression using the counts
     of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the
     "compressed" string would not become smaller than the original string, your method should return
     the original string. You can assume the string has only uppercase and lowercase letters (a - z).

     */

    public static void main(String[] args) {
        System.out.println(stringCompression("aabcccccaaa"));
    }

    public static String stringCompression(String string) {
        StringBuilder newString = new StringBuilder();
        List<Character> characters = new ArrayList<>();
        List<Integer> numOfChars = new ArrayList<>();
        int index = 0;
        int numberOfChars = 0;
        Character lastChar = string.charAt(index);
        while (index < string.length()) {
            Character currentChar = string.charAt(index);
            if (!characters.contains(currentChar) || lastChar != currentChar) {
                characters.add(currentChar);
            }
            if (currentChar.equals(lastChar)) {
                numberOfChars++;
                lastChar = currentChar;
                index++;
            } else {
                numOfChars.add(numberOfChars);
                lastChar = currentChar;
                numberOfChars = 1;
                index++;
            }
        }
        numOfChars.add(numberOfChars);
        for (int i = 0; i < characters.size(); i++) {
            newString.append(characters.get(i));
            newString.append(numOfChars.get(i));
        }
        return newString.toString();
    }

}
