package lambdaPractice;

import java.util.ArrayList;
import java.util.List;

public class Q01 {
      /*    2) "Q01" olarak adlandırılan bir class oluşturun
            3) 5 String öğesi içeren bir String listoluşturun.
            4) 3 tanesi "A" harfi ile başlayacak
            5) Elemanlar "A" harfi ile başlıyorsa ve elemanların uzunlukları
            5'ten küçükse, konsolda list olarak buyuk harflerle yazdırın.

       */
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("Angle");
        list.add("Tahsin");
        list.add("Andy");
        list.add("Ali");
        list.add("Emrah");

        list.stream().
                filter(t -> t.startsWith("A")).
                filter(t -> t.length()<5).
                map(t->t.toUpperCase()).
                forEach(System.out::println);


    }

}
