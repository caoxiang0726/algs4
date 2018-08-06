package edu.cx.ch1.section1;


public class PlusPlusTestInArray {
    public static void main(String[] args) {
        int[] a = new int[]{0, 1, 2, 3};
        int i = 0;
        System.out.println("a[i++]="+a[i++]);//0


        int[] b = new int[]{0, 1, 2, 3};
        int j = 0;
        System.out.println("b[++j]="+b[++j]);//1


        int[] c = new int[]{0, 1, 2, 3};
        int k = 2;
        System.out.println("c[k]="+c[k]);//2
        System.out.println("c[k++]="+c[k--]);//2


    }
}
