package _faduLambda;

import lambdaTutorial.Lambda01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambda03 {

    public static void main(String[] args) {

        List<String> menu=new ArrayList<>(Arrays.asList("küşleme","adana","trileçe","havucDilim","buryan",
                "yaglama","kokareç","arabAşı","güveç","trileçe","trileçe","trileçe"));

        //Task1:
        elAlfUcDistPrint(menu);
        System.out.println("\n   ****   ");
        //Task2:
        elCharSayTersSirali(menu);
        System.out.println("\n   ****   ");
        //Task3:
        elCharSayBkTersSirala(menu);
        System.out.println("\n   ****   ");
        //Task4:
        elSonHarfTersSirali(menu);
        System.out.println("\n   ****   ");
        //Task5:
        elCiftCharSayKareTekrarsiz(menu);
        System.out.println("\n   ****   ");
        //Task6:
        elCharSayiYedi(menu);
        System.out.println("\n   ****   ");
        //Task7:
        wBaslamaKontrol(menu);
        System.out.println("\n   ****   ");








    }

    // Task1 : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.

    public static void elAlfUcDistPrint(List<String> menu) {

        menu.
                stream(). // akisa sokuldu
                //map(t->t.toUpperCase()).//Jamb.Ex  elemanlar buyuk harf update edildi
                map(String::toUpperCase).//Meth.Ref elemanlar buyuk harf update edildi
                sorted(). // natural order (alfabetik) siralandi
                distinct(). // benzersiz tekrarsiz hale getirildi
                forEach(t->System.out.print(t+" ")); // print edildi

        //distinct() => Bu method tekrarlı elemanları sadece bir kere akısa sokar.
        // Bu akışın farklı elemanlarından (Object.equals (Object) 'e göre) oluşan bir akış döndürür.
        // Sıralı akışlar için, farklı elemanın seçimi sabittir
        // (yinelenen öğeler için, karşılaşma sırasında ilk görünen öğe korunur.)
        // Sırasız akışlar için, herhangi bir kararlılık garantisi verilmez. Stream return eder.
    }

    // Task2 : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..

    public static void elCharSayTersSirali(List<String> menu) {
        menu.
                stream().
                map(t->t.length()).
                // map(String::length).
                sorted(Comparator.reverseOrder()).
                distinct().
                // forEach(t->System.out.print(t+" "));
                forEach(Lambda01::yazdir);
    }

    // Task3 : List elemanlarini character sayisina gore kckten byk e gore print ediniz..

    public static void elCharSayBkTersSirala (List<String> menu) {
        menu.
                stream(). // akisa soktu
                sorted(Comparator.// siralama yap
                        comparing(String::length)). // uzunluklarina gore natural order Asc
                forEach(t->System.out.print(t+" ")); // print et
    }

    // Task4 : list elemanlarinin son harfine gore ters sirali print ediniz.

    public static void elSonHarfTersSirali(List<String> menu) {
        menu.
                stream().
                sorted(Comparator.
                        comparing(t -> t.toString().
                                charAt(t.toString().length() - 1)).
                        reversed()).
                forEach(t -> System.out.print(t + " "));
    }

    // Task5 : listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan,
    // ve karelerini tekrarsiz buyukten kucuge sirali  print ediniz..
    public static void elCiftCharSayKareTekrarsiz(List<String> menu) {
        menu.stream().filter(t->t.length()%2==0).map(t->t.length()*t.length()).distinct().sorted(Comparator.reverseOrder()).forEach(Lambda01::yazdir);
    }

    // Task6 : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
    public static void elCharSayiYedi(List<String> menu) {
        menu.stream().filter(t->t.length()<=7).forEach(t -> System.out.print(t + " "));
    }

    // Task7 : List elelmanlarinin "W" ile baslamasını kontrol ediniz.
    public static void wBaslamaKontrol(List<String> menu) {
        menu.stream().filter(t->t.startsWith("w")).forEach(t -> System.out.print(t + " "));
    }

    // Task8 : List elelmanlarinin "x" ile biten en az bir elemaı kontrol ediniz.


}





