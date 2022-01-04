package lambdaPractice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Q03 {
    //String isimlerden olusan bir list olusturun
    //Konsoldaki farklı öğeleri uzunluklarıyla birlikte yazdırın.
//Konsoldaki farklı öğeleri yazdırın, uzunluklarına göre sıralayın.
//Konsoldaki farklı öğeleri yazdırın, son karakterlerine göre sıralayın.
//Konsoldaki farklı öğeleri ters sırada yazdırın.
//Uzunluğu 7'den küçük olan farklı öğeleri ters sırada konsolda büyük harflerle yazdırın.
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Lutfullah");
        list.add("Emine");
        list.add("Emine");
        list.add("Yusuf");
        list.add("Seyfullah");
        list.add("Hakan");
        //Konsoldaki farklı öğeleri uzunluklarıyla birlikte yazdırın.
        //list.stream().distinct().sorted().forEach(t -> System.out.print(t + "="+t.length()+" "));
        //Konsoldaki farklı öğeleri yazdırın, uzunluklarına göre sıralayın.
        //list.stream().distinct().sorted(Comparator.comparing(t->t.length())).forEach(t -> System.out.println(t));
        //Konsoldaki farklı öğeleri yazdırın, son karakterlerine göre sıralayın.
        //list.stream().distinct().sorted(Comparator.comparing(t ->t.charAt(t.length()-1))).forEach(t -> System.out.println(t));
        //Konsoldaki farklı öğeleri ters sırada yazdırın.
        //list.stream().distinct().sorted(Comparator.reverseOrder()).forEach(t -> System.out.print(t+" "));
        //Uzunluğu 7'den küçük olan farklı öğeleri ters sırada konsolda büyük harflerle yazdırın.
        list.
                stream().
                filter(t->t.length()<7).
                distinct().
                sorted(Comparator.reverseOrder()).
                map(t ->t.toUpperCase()).
                forEach(System.out::print);


    }





}
