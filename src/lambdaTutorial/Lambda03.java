package lambdaTutorial;

import java.util.*;
import java.util.stream.Stream;

public class Lambda03 {
    public static void main(String[] args) {

        List<String> menü = new ArrayList<>(Arrays.asList("küşleme", "adana", "trileçe", "havucDilim", "buryan",
                "yaglama", "kokareç", "arabAşı", "güveç", "waffle", "welemen", "cacix"));


        alfBykTekrrsz(menü);
        System.out.println("\n   ***   ");
        chrSayisiTersSirali(menü);
        System.out.println("\n   ***   ");
        chrSayisiBkSirala(menü);
        System.out.println("\n   ***   ");
        sonHrfBkSirala(menü);
        System.out.println("\n   ***   ");
        charKaresiCiftElSirala(menü);
        System.out.println("\n   ***   ");
        harfSayisi7denAzKontrol(menü);
        System.out.println("\n   ***   ");

        wIleBaslayanElKontrol(menü);
        System.out.println("\n   ***   ");
        xIleBitenElKontrol(menü);
        System.out.println("\n   ***   ");
        charSayisiBykElPrint(menü);
        System.out.println("\n   ***   ");
        ilkElHarcSonHrfSiraliPrint(menü);
        System.out.println("\n   ***   ");
    }

    // Task : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
    public static void alfBykTekrrsz(List<String> yemek) {
        yemek.//akıs kaynagı
                stream().//akısa girdi
                //map(t->t.toUpperCase()).//Jamb.Ex  elemanlar buyuk harf update edildi
                        map(String::toUpperCase).//Meth.Ref elemanlar buyuk harf update edildi
                sorted().//alafabetik(natural dogal) sıra yapıldı
                distinct().// benzersiz: tekrarsız hale getirildi
                forEach(t -> System.out.print(t + " "));//print

        //distinct() => Bu method tekrarlı elemanları sadece bir kere akısa sokar.
        // Bu akışın farklı elemanlarından (Object.equals (Object) 'e göre) oluşan bir akış döndürür.
        // Sıralı akışlar için, farklı elemanın seçimi sabittir
        // (yinelenen öğeler için, karşılaşma sırasında ilk görünen öğe korunur.)
        // Sırasız akışlar için, herhangi bir kararlılık garantisi verilmez. Stream return eder.
    }

    // Task : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
    public static void chrSayisiTersSirali(List<String> menü) {
        menü.
                stream().//akısa alındı
                // map(t->t.length()).
                        map(String::length).//elemanlar karakter sayısına update edildi
                sorted(Comparator.reverseOrder()).//ter sıra yapıldı
                distinct().//benzersiz yapıldı
                //forEach(t->System.out.print(t+" "));
                        forEach(Lambda01::yazdir);//print edildi


    }

    // Task : List elemanlarini character sayisina gore kckten byk e gore print ediniz..
    public static void chrSayisiBkSirala(List<String> menü) {
        menü.
                stream().
                sorted(Comparator.
                        comparing(String::length)).
                forEach(t -> System.out.print(t + " "));
    }

    // Task : list elemanlarinin son harfine gore ters sirali print ediniz.
    public static void sonHrfBkSirala(List<String> menü) {
        menü.
                stream().
                sorted(Comparator.
                        comparing(t -> t.toString().
                                charAt(t.toString().length() - 1)).//elemanin length()-1)-->son inedx'inin karakterini alir
                                reversed()).//elemanin length()-1)-->son inedx'inin karakterini ters siralar z->a
                forEach(t -> System.out.print(t + " "));

    }

    // Task : listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan,ve karelerini tekrarsiz buyukten kucuge sirali  print ediniz...
    public static void charKaresiCiftElSirala(List<String> menu) {
        menu.
                stream().//akısa alndı
                map(t -> t.length() * t.length()).//akısdaki string elemanları boyutlarının karesine update edildi
                filter(Lambda01::ciftBul).//cift elelmalar filtrelendi
                distinct().//tekrarsız yapıldı
                sorted(Comparator.reverseOrder()).//ters b->k sıra yapıldı
                forEach(Lambda01::yazdir);// print edildi
    }
    // Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.

    public static void harfSayisi7denAzKontrol(List<String> menü) {
        //amele code
        System.out.println("amele code");
        boolean kontrol = menü.stream().allMatch(t -> t.length() <= 7);
        if (kontrol) {
            System.out.println("list elemanları 7 ve daha az harften olusuyor");
        } else System.out.println("list elemanları 7 harften  buyuk");
        //cincix code
        System.out.println("cincix code");
        System.out.println(menü.
                stream().
                allMatch(t -> t.length() <= 7) ? "list elemanları 7 ve daha az harften olusuyor" : "list elemanları 7 harften  buyuk");
    }
    //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
    //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
    //noneMatch()--> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.


    // Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.
    public static void wIleBaslayanElKontrol(List<String> menü) {
        System.out.println(menü.
                stream().
                noneMatch(t -> t.startsWith("w")) ? "agam w ile başlayan yemahh olu mu ?" :
                "agam  wenemen ne menen bi şey  ?");

    }

    // Task : List elelmanlarinin "x" ile biten en az bir elemanı kontrol ediniz.

    public static void xIleBitenElKontrol(List<String> menü) {
        System.out.println(menü.
                stream().
                anyMatch(t -> t.endsWith("x")) ? "agam senden bir  cacix olmaz  ?" :
                "agam senin aradigin yemek bu torpaklarda yooogggg");

    }

    // Task : Karakter sayisi en buyuk elemani yazdiriniz.

    public static void charSayisiBykElPrint(List<String> menü) {
        Stream<String> sonIsim = menü.
                stream().
                sorted(Comparator.comparing(t -> t.toString().length()).
                        reversed()).
                //   findFirst();//ilk eleman alındı
                        limit(3);//limit(a) akısdan cıkan elemanları a parametresine gore ilk a elamanı alır.

        // 2. yol... max() ve get() method
        System.out.println(menü.
                stream().
                max(Comparator.comparing(String::length)).
                get());
    /*
    sonIsim.toArray()--> limit() meth return dan dolayı  stream type olan sonIsim toArray() method ile array type convert edildi
     */

        System.out.println(Arrays.toString(sonIsim.toArray()));//arraya cevrilen sonIsim stream print edildi.

        // 3. yol...veriable assign etmeden stream ifade toArray() ile arraya cevirip print edildi
        System.out.println(Arrays.toString(menü.
                stream().
                sorted(Comparator.comparing(t -> t.toString().length()).
                        reversed()).
                limit(1).toArray()));


//limit(1) => Sınırlandırma demek. Bu akışın elemanlarından oluşan, uzunluğu maxSize'dan uzun olmayacak
// şekilde kesilmiş bir akış return eder. Stream return eder.

         /*
    TRİCK : Stream’ler ekrana direk yazdırılamaz. Stream’i toArray() ile Array’e çeviririz. Array’i de Arrays.toString() ‘in içine alıp yazdırabiliriz.
  	Ör; System.out.println(Arrays.toString(stream.toArray())); veya System.out.println(Arrays.asList(***.toArray())); kullanılabilir.
     */
        // akıs cıktısını bir veriable assaign edilebilir
        Optional<String> enBykKrEl = menü.
                stream().
                sorted(Comparator.comparing(t -> t.toString().length()).
                        reversed()).
                findFirst();//ilk eleman alındı

    }

    // Task : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
    public static void ilkElHarcSonHrfSiraliPrint(List<String> menü) {

        menü.
                stream().//akısa alındı
                sorted(Comparator.comparing(t -> t.charAt(t.length() - 1))).//son harfe göre sıralandı
                skip(1).//ilk eleman atlandı -->adana
                forEach(t -> System.out.print(t + " "));//print edildi
//skip(1) => atlama demek. Akışın ilk n elemanını attıktan sonra bu akışın kalan elemanlarından oluşan bir akış return eder.
// Bu akış n'den daha az öğe içeriyorsa, boş bir akış döndürülür. Bu, durum bilgisi olan bir ara işlemdir.
//skip(list.size()-1) => List’in uzunluğunun 1 eksiğini yazarsak son elemanı yazdırırız.
    }

}
