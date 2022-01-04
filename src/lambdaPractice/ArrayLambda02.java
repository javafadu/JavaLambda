package lambdaPractice;


import java.util.ArrayList;
import java.util.Arrays;

import java.util.Scanner;

public class ArrayLambda02 {
    /*
      Girilen Stringdeki  tüm sesli harfleri saymak için bir Java Methodu yazınız.
      Test Data:java is fun
      Beklenen Çıktı: 4

     */
    public static <List> void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        System.out.println("Bir metin giriniz:");
        String str = scan.nextLine();
        java.util.List<String> str1 = new ArrayList<>(Arrays.asList(str.split("")));


        System.out.println(str1.stream().
                filter(t -> t.equalsIgnoreCase("a")||
                        t.equalsIgnoreCase("i")||
                        t.equalsIgnoreCase("u")||
                        t.equalsIgnoreCase("e")||
                        t.equalsIgnoreCase("o")).
                count());
    }
}

