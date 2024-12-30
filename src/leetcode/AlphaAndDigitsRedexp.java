package leetcode;

public class AlphaAndDigitsRedexp {
    public static void main(String[] args) {
        String alphaAndDigits = "Hello+-^Java+ -Preee123123123123ogrammer^ ^^-- ^***()()()^^ +!".replaceAll("[^a-z A-Z 0-9 + -]+","");
        System.out.println(alphaAndDigits);
    }
}
