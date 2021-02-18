package dbelousov.petprojects.util;

public class StringAppender {

    private static final int EXTENSION_RATE = 2;

    private int size;
    private char[] chars;

    public StringAppender(String s) {
        size = s.length();
        chars = new char[size];
        for (int i = 0; i < size; i++) {
            chars[i] = s.charAt(i);
        }
    }

    public boolean append(String s) {
        if (s == null) {
            return false;
        }
        if (chars.length - size < s.length()) {
            extendArray();
        }
        for (char ch : s.toCharArray()) {
            chars[size] = ch;
            size++;
        }
        return true;
    }

    private void extendArray() {
        char[] newChars = new char[chars.length * EXTENSION_RATE];
        for (int i = 0; i < size; i++) {
            newChars[i] = chars[i];
        }
        chars = newChars;
    }

    @Override
    public String toString() {
        char[] trimmedChars = new char[size];
        int i = 0;
        while (i < size) {
            trimmedChars[i] = chars[i];
            i++;
        }
        return new String(trimmedChars);
    }
}
