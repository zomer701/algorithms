package meta;

public class WrongAnswers {
    public static void main(String[] args) {
        System.out.println(new WrongAnswers().getWrongAnswers(3, "ABA"));
    }

    public String getWrongAnswers(int N, String C) {
        StringBuilder memo = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (C.charAt(i) == 'A') {
                memo.append("B");
            } else {
                memo.append("A");
            }
        }
        return memo.toString();
    }
}
