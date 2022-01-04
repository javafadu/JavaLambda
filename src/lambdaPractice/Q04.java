package lambdaPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q04 {
    //        3) "Ali", "John", "Ali", "Alexander", "Taylor", "Ali", "Jackson" öğelerini içeren bir Dize listesi oluşturun
//        4) "J" ile baslayin olan öğeleri almayın
//        5) Farklı öğeleri seçin
//        6)Karakter sayısına göre doğal sıraya koyun
//        7) Tüm öğeleri büyük harfe dönüştürün
//        8) Konsoldaki öğeleri yazdırın
//        9)Fonksiyonel Programlama'yı kullanın
//        */
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(Arrays.asList("Ali", "John", "Ali", "Alexander",
                "Taylor", "Ali", "Jackson"));
        jIleBaslamayacakFarkliOgeKrkSysSiraYaz(list);
    }

    public static void jIleBaslamayacakFarkliOgeKrkSysSiraYaz(List<String> list) {
        System.out.print(" SONUC == > ");
        list.stream()
                .filter(t->t.startsWith("J"))//j ile baslayanlari
                .distinct()//farkli olanlari aldik
                .sorted(Comparator.comparing(t->t.length())) //karakter sayisina gore natural sıra
                .map(t->t.toUpperCase())
                .forEach(t-> System.out.println(t));
    }
}
