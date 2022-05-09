package leetcode;

public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(new RomanToInteger().romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s)
    {
        int result = 0;

        int leng = s.length();

       while (leng >= 1 && s.charAt(s.length() - leng) == 'M')
       {
           result = result + 1000;
           leng = leng - 1;
       }

        while (leng >= 2 && s.charAt(s.length() - leng)  == 'C'
                && s.charAt(s.length() - leng + 1)  == 'M')
        {
            result = result + 900;
            leng = leng - 2;
        }

        while (leng >= 1 && s.charAt(s.length() - leng) == 'D')
        {
            result = result + 500;
            leng = leng - 1;
        }

        while (leng >= 2 && s.charAt(s.length() - leng)  == 'C'
                && s.charAt(s.length() - leng + 1)  == 'D')
        {
            result = result + 400;
            leng = leng - 2;
        }

        while (leng >= 1 && s.charAt(s.length() - leng) == 'C')
        {
            result = result + 100;
            leng = leng - 1;
        }

        while (leng >= 2 && s.charAt(s.length() - leng)  == 'X'
                && s.charAt(s.length() - leng + 1)  == 'C')
        {
            result = result + 90;
            leng = leng - 2;
        }

        while (leng >= 1 && s.charAt(s.length() - leng) == 'L')
        {
            result = result + 50;
            leng = leng - 1;
        }

        while (leng >= 2 && s.charAt(s.length() - leng)  == 'X'
                && s.charAt(s.length() - leng + 1)  == 'L')
        {
            result = result + 40;
            leng = leng - 2;
        }

        while (leng >= 1 && s.charAt(s.length() - leng) == 'X')
        {
            result = result + 10;
            leng = leng - 1;
        }

        while (leng >= 2 && s.charAt(s.length() - leng)  == 'I'
                && s.charAt(s.length() - leng + 1)  == 'X')
        {
            result = result + 9;
            leng = leng - 2;
        }

        while (leng >= 1 && s.charAt(s.length() - leng) == 'V')
        {
            result = result + 5;
            leng = leng - 1;
        }

        while (leng >= 2 && s.charAt(s.length() - leng)  == 'I'
                && s.charAt(s.length() - leng + 1)  == 'V')
        {
            result = result + 4;
            leng = leng - 2;
        }

        while (leng >= 1 && s.charAt(s.length() - leng) == 'I')
        {
            result = result + 1;
            leng = leng - 1;
        }
       return result;
    }
}
