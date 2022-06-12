package elements.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//  123     738
//  456    615
//       492
//          56088
public class MultiplyStrings {
    public static void main(String[] args) {
        String val = "222";
        String val2 = "0";

        System.out.println(new MultiplyStrings().multiply(val, val2));
    }
//3*6 = 18
//3*5 = 15
//3*4 = 12
    //1368
    //12
    //1488
    public String multiply(String num1, String num2) {
        List<Integer > values
                = new ArrayList <>(Collections.nCopies (num1 .length () + num2.length(), 0));
        for (int i = num1.length() - 1;i>=0 ; i--) {
            for (int j = num2.length() - 1;j>=0 ; j--) {


                int val = Integer.parseInt(String.valueOf(num1.charAt(i))) * Integer.parseInt(String.valueOf(num2.charAt(j)));
                int data = values.get(i+j+1) != null ? values.get(i+j+1) : 0;
                int lastValue = data + val;
                int lastDigit = lastValue%10;
                values.set(i+j+1, lastDigit);
                values.set(i+j, values.get(i+j) + (lastValue - lastDigit) / 10);
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int data: values) {
            builder.append(data);
        }

        String data = builder.toString();
        while (data.startsWith("0") && data.length() != 1) {
            data = data.substring(1);
        }

       return data;
    }
}
