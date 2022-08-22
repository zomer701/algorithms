package google;

import java.util.HashSet;
import java.util.Set;

public class Leetcode_929 {

    public static void main(String[] args) {
        String[] data = {"a@leetcode.com","b@leetcode.com","c@leetcode.com"};
        System.out.println(numUniqueEmails(data));
    }

    public static int numUniqueEmails(String[] emails) {
        Set<String> unique = new HashSet<>();

        for (int i = 0;i < emails.length; i++) {
            String[] splitData = emails[i].split("@");
            String localName = splitData[0];
            String domainName = splitData[1];

            String loc = localName.split("\\+")[0].replace(".", "");

            unique.add(loc+"@"+domainName);
        }
        return unique.size();
    }
}
