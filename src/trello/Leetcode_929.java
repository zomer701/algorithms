package trello;

import java.util.HashSet;
import java.util.Set;

public class Leetcode_929 {
    public static void main(String[] args) {
        String[] data = {"a@leetcode.com","b@leetcode.com","dd@lee.tcode.com"};
        System.out.println(numUniqueEmails(data));
    }

    public static int numUniqueEmails(String[] emails) {
        Set<String> unique = new HashSet<>(emails.length);
        for (String email: emails) {
            String[] splitEmail = email.split("@");
            String[] finalEmail = splitEmail[0].replaceAll("\\.", "").split("\\+");
            unique.add(finalEmail[0]+"@"+splitEmail[1]);
        }

        return unique.size();
    }
}
