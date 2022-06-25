package org.example.Leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/multiply-strings/submissions/
 * good solution: https://leetcode.com/problems/multiply-strings/discuss/2120250/java-solution-5ms
 */
public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        else if(num1.equals("1")) return num2;
        else if(num2.equals("1")) return num1;
        return mi(num1, num2, num2.length() - 1);
    }

    private String mi(String num1, String num2, int idx){
        if(idx == -1){
            return "0";
        }
        char[] zeros = new char[num2.length() - idx - 1];
        Arrays.fill(zeros, '0');
        String product = multiplyDigit(num1, String.valueOf(num2.charAt(idx))) + new String(zeros);
        String result = add(product, mi(num1, num2, idx - 1));
        print("idx: " + idx + " - " + result);
        return result;
    }

    private String multiplyDigit(String a, String b){
        int n = Integer.valueOf(b);
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = a.length() - 1; i >= 0; i--){
            print(Integer.valueOf(String.valueOf(a.charAt(i))) + " - " + a.charAt(i));
            String product = String.valueOf(
                    (charToInt(a.charAt(i)) * n) + carry
            );
            print("i: " + i + ", product: " + product);
            if(product.length() == 1){
                sb.append(product);
                carry = 0;
            }else{
                sb.append(product.charAt(1));
                carry = charToInt(product.charAt(0));
            }
        }
        if(carry != 0)
            sb.append(carry);
        String result = sb.reverse().toString();
        print(a + " * " + b + " = " + result);
        return result;
    }

    private String add(String a, String b){
        String sm, lg;
        if(a.length() < b.length()){
            sm = a;
            lg = b;
        } else {
            sm = b;
            lg = a;
        }
        int carry = 0;
        int smi = sm.length() - 1;
        int lgi = lg.length() - 1;
        StringBuilder sb = new StringBuilder();
        while(smi >= 0){
            String sum = String.valueOf(
                    charToInt(sm.charAt(smi)) + charToInt(lg.charAt(lgi)) + carry
            );
            if(sum.length() == 1){
                sb.append(sum);
                carry = 0;
            }else{
                sb.append(sum.charAt(1));
                carry = charToInt(sum.charAt(0));
            }
            smi--;
            lgi--;
        }
        while(lgi >= 0){
            String sum = String.valueOf(
                    charToInt(lg.charAt(lgi)) + carry
            );
            if(sum.length() == 1){
                sb.append(sum);
                carry = 0;
            }else{
                sb.append(sum.charAt(1));
                carry = charToInt(sum.charAt(0));
            }
            lgi--;
        }
        if(carry != 0)
            sb.append(carry);
        String result = sb.reverse().toString();
        print(a + " + " + b + " = " + result);
        return result;
    }

    private int charToInt(char c){
        return Integer.valueOf(String.valueOf(c));
    }

    private void print(String mes){
        // System.out.println(mes);
    }

}
