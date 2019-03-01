package com.example.mycalculator;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class InfixToPostFix {
    boolean check_error = false;

    public String standardizedDouble(double num) {
        int a = (int) num;
       return Integer.toString(a);
       else return Double.toString(num);
    }

    public boolean isCharPi(char c) {
        if (c == 'π' ) return true;
        else return false;
    }

    //Check if number is Pi

    public boolean isNumPi(double num) {
        if (num == Math.PI) return true;
        else return  false;
    }

    public boolean isNum(char c) {
        if (Character.isDigit(c) || isCharPi(c)) return true;
        else return false;
    }
    //convert number to string
    public String NumToString(double num) {
        if (isNumPi(num)) return "π";
        else return standardizedDouble(num);
    }

    public double StringToNum(String s) {
        if (isCharPi(s.charAt(0))) return Math.PI;
        else return Double.parseDouble(s);
    }

    public boolean isOperator(char c) {
        char operator[] = {'+' , '-' , '/' , '*', '%', '^', '@' , 't', 'c' , 's', '~', '(' , ')', '!'};

        Arrays.sort(operator);
        if (Arrays.binarySearch(operator, c) >-1 ) return true;
        else return false;
    }
    //Setting priority

    public int priority(char c) {
        switch (c) {
            case '+': case '-' : return 1;
            case '*': case '/' : return 2;
            case '~': return 3;
            case '@': case '!' : case '^': return 4;
            case 's': case 'c' : case 't': return 5;

        }
        return 0;
    }

    public boolean isOneMath(char c) {
        char operator[] = {'s','c','t','@','('};
        Arrays.sort(operator);
        if (Arrays.binarySearch(operator, c) >-1 ) return true;
        else return false;
    }

    public String standardized(String s) {
        String s1 ="";
        s = s.trim();
        s = s.replaceAll("\\s+", "");
        int open = 0, close = 0;

        for(int i = 0; i <s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') open++;
            if( c == ')') close++;
        }
        for (int i = 0; i < (open-close); i++) s+= ')';
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && isOneMath(s.charAt(i)) && (s.charAt(i-1) == ')' || isNum(s.charAt(i-1))))
                s1 = s1 + "*";

            if ((i ==0 || (i > 0 && !isNum(s.charAt(i-1)))) && s.charAt(i) == '-'
                    && !isNum(s.charAt(i+1)) ) {
                s1 = s1 + "~";
            }

            else if(i > 0 && (isNum(s.charAt(i-1)) || s.charAt(i-1) == ')') && isNumPi(s.charAt(i)))
                s1 = s1 + "*" + s.charAt(i);
            else s1 = s1 + s.charAt(i);
        }
        return s1;

    }

    public String [] processString (String sMath) {
        String s1 = "", elementMath[] = null;
        sMath = standardized(sMath);
        InfixToPostFix ITP = new InfixToPostFix();
        for (int i = 0; i<sMath.length(); i++) {
            char c = sMath.charAt(i);
            if (i < sMath.length() -1 && isCharPi(c) && !ITP.isOperator(sMath.charAt(i+1))) {
                check_error = true;
                return null;
            }
            else
            if (!ITP.isOperator(c)) s1 = s1 + c;
            else s1 = s1 + "" + c + "";

        }

        s1 = s1.trim();
        s1 = s1.replaceAll("\\s+", "");
        elementMath = s1.split("");
        return elementMath;

    }

    public String[] postFix(String [] elementMath) {
        InfixToPostFix ITP = new InfixToPostFix();
        String s1 = "", E[];
        Stack <String> S = new Stack<String>();
        for (int i = 0; i < elementMath.length; i++) {
            char c = elementMath[i].charAt(0);

            if(!ITP.isOperator(c)) s1 = s1 + elementMath[i] + "";
            else {
                if (c == '(') S.push(elementMath[i]);
                else {
                    if (c ==')') {
                        char c1;
                        do {
                            c1 = S.peek().charAt(0);
                            if (c1 != '(') s1 = s1+ S.peek() + "";
                            S.pop();
                        } while (c1 != ')');
                    }
                    else {
                        while (!S.isEmpty() && ITP.priority(S.peek().charAt(0)) >= ITP.priority(c))
                            S.push(elementMath[i]);
                    }
                }
            }
        }
        while (!S.isEmpty()) s1 = s1+ S.pop() + "";

        E = s1.split("");
        return E;
    }
}

