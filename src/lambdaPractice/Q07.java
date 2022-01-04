package lambdaPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q07 {
    //String isimlerden olusan bir list olusturnuz
    //List'deki isimlerden "a" ve "n" icerenlerin harf sayilarinin toplamini ekrana yazdiriniz
    //List'deki isimlerden ilk harfi son harfinden alfabetik olarak onde olan isimleri ekrana yazdirin
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("Emrah", "Ahmet", "ali", "Hikmet", "Adnan", "Osman", "avni"));
        System.out.println(" ===== Task 01 =====");
        aNIcerenKrkSayisiTopla(list);
        System.out.println(" ===== Task 02 =====");
        ilkHarfSonHarfdenOnde(list);
    }

    // Task 01 ->  List'deki isimlerden "a" ve "n" icerenlerin harf sayilarinin toplamini ekrana yazdiriniz
    public static void aNIcerenKrkSayisiTopla(List<String> list) {
        System.out.println(list.
                stream().
                filter(t -> t.contains("a") && t.contains("n")).
                map(t -> t.length()).
                //.mapToInt(t -> t.length()).
                //sum());
                reduce(Integer::sum));
    }

    // Task 02 -> List'deki isimlerden ilk harfi son harfinden alfabetik olarak onde olan isimleri ekrana yazdirin
    public static void ilkHarfSonHarfdenOnde(List<String> list) {
        list.
                stream().
                filter(t -> t.charAt(0) < t.charAt(t.length() - 1)).
                forEach(t -> System.out.print(t + " "));
    }
}
