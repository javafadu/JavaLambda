package _faduLambda;

import lambdaTutorial.Lambda01;

import java.util.*;
import java.util.stream.Stream;

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
        harfSayisi7denAzKontrol(menu);
        System.out.println("\n   ****   ");
        //Task7:
        wBaslamaKontrol(menu);
        System.out.println("\n   ****   ");
        //Task8:
        xIleBitenElKontrol(menu);
        System.out.println("\n   ****   ");
        //Task9:
        charSayisiBykElPrint(menu);
        System.out.println("\n   ****   ");
        //Task10:
        ilkElHarcSonHrfSiraliPrint(menu);
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
    public static void harfSayisi7denAzKontrol(List<String> menu) {

        // amele kodu :
        System.out.println("Amele code");
        boolean kontrol=menu.stream().allMatch(t->t.length()<=7);
        if(kontrol){
            System.out.println("List elemanlari 7 harf veya daha az harfden olusuyor");
        } else {
            System.out.println("List elemanlari 7 harften buyuk");
        }

        // cincix kod:
        System.out.println("Cincix code");
        System.out.println(menu.
                stream().
                allMatch(t -> t.length() <= 7) ? "List elemanlari 7 harf veya daha az harfden olusuyor" :
                "List elemanlari 7 harften buyuk");
    }
    //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
    //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
    //noneMatch()--> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.



    // Task7 : List elelmanlarinin "W" ile baslamasını kontrol ediniz.
    public static void wBaslamaKontrol(List<String> menu) {
        System.out.println(menu.stream().noneMatch(t -> t.startsWith("w")) ? "w ile baslayan yemek yok" : "w ile baslayan yemek var");
    }

    // Task8 : List elelmanlarinin "x" ile biten en az bir elemaı kontrol ediniz.

    public static void xIleBitenElKontrol(List<String> menu) {
        System.out.println(menu.stream().anyMatch(t -> t.endsWith("x")) ? "x ile biten yemek var" : "x ile biten yemek yok");
    }

    // Task9 : Karakter sayisi en buyuk elemani yazdiriniz.
    public static void charSayisiBykElPrint (List<String> menu) {
        Stream<String> sonIsim = menu.
                stream().
                sorted(Comparator.comparing(t -> t.toString().length()).reversed()).
                // findFirst());
                limit(3); //limit(a) akısdan cıkan elemanları a parametresine gore ilk a elamanı alır.

        /*
        sonIsim.toArray()--> limit() meth return dan dolayı  stream type olan sonIsim toArray() method ile array type convert edildi
        */

        System.out.println(Arrays.toString(sonIsim.toArray()));//arraya cevrilen sonIsim stream print edildi

        //limit(1) => Sınırlandırma demek. Bu akışın elemanlarından oluşan, uzunluğu maxSize'dan uzun olmayacak
        // şekilde kesilmiş bir akış return eder. Stream return eder.

         /*
    TRİCK : Stream’ler ekrana direk yazdırılamaz. Stream’i toArray() ile Array’e çeviririz. Array’i de Arrays.toString() ‘in içine alıp yazdırabiliriz.
  	Ör; System.out.println(Arrays.toString(stream.toArray())); veya System.out.println(Arrays.asList(***.toArray())); kullanılabilir.
     */

        // akis ciktisi bir variable assign ederek
       Optional<String> enBykKrEl =  menu.
               stream().
               sorted(Comparator.
                       comparing(t -> t.toString().length()).reversed()).
               findFirst();



        System.out.println(enBykKrEl);
    }



    // Task10 : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
    public static void ilkElHarcSonHrfSiraliPrint(List<String> menu) {
        menu.
                stream(). // akisa alindi
                sorted(Comparator.comparing(t->t.charAt(t.length()-1))). // son harfe gore siralandi
                skip(1). // ilk eleman atlandi
                forEach(t->System.out.print(t + " ")); // print etti


        //skip(1) => atlama demek. Akışın ilk n elemanını attıktan sonra bu akışın kalan elemanlarından oluşan bir akış return eder.
        // Bu akış n'den daha az öğe içeriyorsa, boş bir akış döndürülür. Bu, durum bilgisi olan bir ara işlemdir.
        //skip(list.size()-1) => List’in uzunluğunun 1 eksiğini yazarsak son elemanı yazdırırız.
    }

}





