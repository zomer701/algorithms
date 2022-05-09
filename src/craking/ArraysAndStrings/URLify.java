package craking.ArraysAndStrings;

public class URLify {
    public static void main(String[] args) {
        System.out.println(new URLify().cleanUrl("Mr John Smith 234".toCharArray()));
    }

    String cleanUrl(char[] data)
    {
        StringBuilder result = new StringBuilder();

        StringBuilder buffer = new StringBuilder();

        for (char value: data)
        {
            if (Character.isLetter(value)) {
                if (buffer.toString().length() > 0) {
                    result.append(buffer);
                    buffer = new StringBuilder();
                }
                result.append(value);
            } else {
                if (Character.isSpace(value)) {
                    buffer.append("%20");
                } else {
                    buffer.append(value);
                }
            }
        }

        return result.toString();
    }
}
