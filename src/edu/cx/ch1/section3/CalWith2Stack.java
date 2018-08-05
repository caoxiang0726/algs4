package edu.cx.ch1.section3;

import java.util.Stack;

/**
 * Created by caoxiang on 2018/8/5.
 */
public class CalWith2Stack {

    public static void main(String[] args) {
        String exp = "(((1+  (2+3) * (4*5))))";
        System.out.println("result:"+cal(exp));

    }

    public static double cal(String exp) {
        String calExp = exp.replace(" ", "");
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        for (int i = 0; i < calExp.length() - 1; i++) {
            String s = calExp.charAt(i) + "";
            if (s.equals("(")) {

            } else if (s.equals("+")) {
                ops.push(s);
            } else if (s.equals("-")) {
                ops.push(s);
            } else if (s.equals("*")) {
                ops.push(s);
            } else if (s.equals("/")) {
                ops.push(s);
            } else if (s.equals(")")) {//开始运算
                String op = ops.pop();
                Double v2 = vals.pop();
                Double v1 = vals.pop();
                Double vNew = 0.0;
                if (op.equals("+")) {
                    vNew = v1+v2;
                } else if (op.equals("-")) {
                    vNew = v1-v2;

                } else if (op.equals("*")) {
                    vNew = v1*v2;

                }
                else if (op.equals("/")) {
                    vNew = v1/v2;
                }
                vals.push(vNew);
            }else {
                vals.push(Double.parseDouble(s));
            }
        }


        return vals.pop();
    }
}
