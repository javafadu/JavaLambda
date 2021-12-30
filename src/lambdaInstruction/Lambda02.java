package lambdaInstruction;

import java.util.*;

public class Lambda02 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(12, -3, 3, 65, 7, 34, 22, -60, 42, 15));
        ciftKareMax(list);
        System.out.println();
        System.out.println(" *** ");
        toplaEl1(list);
        System.out.println();
        System.out.println(" *** ");
        carpCiftEl1(list);
        System.out.println();
        System.out.println(" *** ");
        carpCiftEl2(list);
        System.out.println();
        System.out.println(" *** ");
        min1(list);
        System.out.println();
        System.out.println(" *** ");
        min2(list);
        System.out.println();
        System.out.println(" *** ");
        min3(list);
        System.out.println();
        System.out.println(" *** ");
        min4(list);
        System.out.println();
        System.out.println(" *** ");
        onbestenBykKckTekSayi(list);
        System.out.println();
        System.out.println(" *** ");
        ciftKareKckByg(list);
        System.out.println();
        System.out.println(" *** ");
        tekKareBygKck( list);
    }

    //List'in cift olan elemanlarin karelerini aliniz ve en buyugunu yazdiriniz
    public static void ciftKareMax(List<Integer> list) {
        // Optional<Integer> maxEl = list.stream().filter(Lambda01::ciftBul).map(t -> t * t).reduce(Integer::max);
        Optional<Integer> maxEl = list.stream().filter(Lambda01::ciftBul).map(t -> t * t).reduce(Math::max);
        //reduce(Math::max) da kullanilabilir ancak reduce(Integer::max); daha specific  oldugu icin hzili calisir

        // int maxEl = list.stream().filter(Lambda01::ciftBul).map(t -> t * t).reduce(Integer::max);
        // reduce() returne edilen elelman null yada int 'den buyuk olur ihtimali icin Java guvenlik olarak handle ederek
        //Optional class' sart kosuyor
        System.out.println(maxEl);
    }

    //List'teki tum elemanlarin toplamini yazdiriniz.
    //LAmbda Expression...
    public static void toplaEl1(List<Integer> list) {
        int toplam = list.stream().reduce(0, (x, y) -> x + y);
      /*
        x  her zaman ilk degerini atanan degerden (0) alır
        y her zaman degerini list.stream()'den alır(akis)
        x ilk degerden sonraki degerlerini islemden alir
       */
        System.out.println(toplam);
        // System.out.println(list.stream().reduce(0,(x, y) -> x + y));
    }

    //List'teki tum elemanlarin toplamini yazdiriniz.
    //Method Reference...
    public static void toplaEl2(List<Integer> list) {
        Optional<Integer> toplam = list.stream().reduce(Math::addExact);
        // Optional<Integer> toplam = list.stream().reduce(Integer::sum);

      /*
        x  her zaman ilk degerini atanan degerden (0) alır
        y her zaman degerini list.stream()'den alır(akis)
        x ilk degerden sonraki degerlerini islemden alir
       */
        System.out.println(toplam);
        // System.out.println(list.stream().reduce(0,(x, y) -> x + y));
    }

    //List'teki cift elemanlarin carpimini  yazdiriniz.
    //Method Reference...
    public static void carpCiftEl1(List<Integer> list) {
        Optional<Integer> carp = list.stream().filter(Lambda01::ciftBul).reduce(Math::multiplyExact);
        System.out.println(carp);
    }

    //List'teki cift elemanlarin carpimini yazdiriniz.
    //Lambda expression...
    public static void carpCiftEl2(List<Integer> list) {
        Integer carp = list.stream().filter(Lambda01::ciftBul).reduce(1, (x, y) -> (x * y));
        //pozitif deger uretiniz
        Integer carpPoz = list.stream().filter(Lambda01::ciftBul).reduce(-1, (x, y) -> (x * y));
        System.out.println(carp);
        System.out.println(carpPoz);
    }

    //List'teki elemanlardan en kucugunu 4 farklı yontem ile yazdiriniz
    //1. yontem Method Reference --> Integer class
    public static void min1(List<Integer> list) {
        Optional<Integer> min = list.stream().reduce(Integer::min);
        System.out.println(min);
    }

    //2. yontem Method Reference --> Math class
    public static void min2(List<Integer> list) {
        Optional<Integer> min = list.stream().reduce(Math::min);
        System.out.println(min);
    }

    //3. yontem Method Reference --> Haluk class

    public static int minBul(int x, int y) {
        return x < y ? x : y;//ternary

    }

    public static void min3(List<Integer> list) {
        Optional<Integer> min = list.stream().reduce(Lambda02::minBul);
        System.out.println(min);
    }

    //4. yontem Lambda Expression
    public static void min4(List<Integer> list) {
        Integer min = list.
                stream().
                reduce(Integer.MAX_VALUE, (x, y) -> x < y ? x : y);
        System.out.println(min);
    }

    //List'teki 15'ten buyuk en kucvuk tek sayiyi yazdiriniz
    public static void onbestenBykKckTekSayi(List<Integer> list) {
        // list.stream().filter(t->t % 2 == 1).filter(t-> t>15).reduce(Integer::min);
        System.out.println(list.
                stream().//akısa girdi
                        filter(t -> t % 2 == 1 & t > 15).//tek ve 15 den byk sarti
                        reduce(Integer::min));//min deger reduce edildi
    }
    //list'in cift  elemanlarinin kareleri ni  kucuge buykten yazdiriniz
    public static void ciftKareKckByg(List<Integer> list){
        list.
                stream().
                filter(Lambda01::ciftBul).
                map(t->t*t).
                sorted().//akısa giren elelmanlar naturel order'e gore siralanir
                forEach(Lambda01::printEl);//144 484 1156 1764 3600

    }
    //list'in tek  elemanlarinin kareleri ni buykten kucuge  yazdiriniz

    public static void tekKareBygKck(List<Integer> list){
        list.
                stream().
                filter(t->t%2!=0).
                map(t->t*t).
                sorted(Comparator.reverseOrder()).//akısa giren elelmanlar ters siralanir
                forEach(Lambda01::printEl);//144 484 1156 1764 3600

    }
}
