package lambdaPractice;

import java.util.ArrayList;
import java.util.List;

public class Q02 {

//        2) Bir class oluşturun, 'Q03' olarak adlandırın
//        3) 5 elemanlı bir tamsayı listesi oluşturun
//        4) Elemanlari doğal sıraya koyun
//        5)Konsoldaki son 3 elemanın karelerinin toplamını bulun.
//        6) Konsoldaki toplamı yazdırın
//        7) 'Fonksiyonel Programlama' kullanın
public static void main(String[] args) {
    List<Integer> list = new ArrayList<Integer>();
    list.add(1);
    list.add(7);
    list.add(3);
    list.add(4);
    list.add(5);
    System.out.println(list.stream().
            sorted().
            filter(t -> list.indexOf(t) > 1).
            map(t -> t * t).
            reduce(0, (x, y) -> x + y));


}



}
