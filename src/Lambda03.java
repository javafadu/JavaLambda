import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambda03 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("mehmet",
                "emre", "nilgun", "cincix", "kader",
                "emine", "islam", "islam", "kokorec"));
        bykHrfTekrarsizSira(list);
        System.out.println();
        System.out.println(" *** ");
        karakterSayisiTekrarsizTersSirali(list);
        System.out.println();
        System.out.println(" *** ");
        karakterSayisiSiraliEl(list);
        System.out.println();
        System.out.println(" *** ");
        sonHarfTersSiraliEl(list);
        System.out.println();
        System.out.println(" *** ");
        ciftKareTekrarsizTersSira(list);
        System.out.println();
        System.out.println(" *** ");
        harfSayisi7Kontrol( list);
        System.out.println();
        System.out.println(" *** ");
        wBaslamaKontrol(list);
        System.out.println(" *** ");
        wBaslamaKontrol(list);
        System.out.println();
        System.out.println(" *** ");
        xbitmeKontrol( list);
        System.out.println();
        System.out.println(" *** ");
        karakteriEnBuyukEl( list);
    }

    //List elemanlarini alafabetik buyuk harf ve  tekrarsiz yazdiriniz
    public static void bykHrfTekrarsizSira(List<String> list) {
        list.
                stream().//akisa girdi
                // map(t->t.toUpperCase()).//elelmanlar byk harf update edildi
                        map(String::toUpperCase).//elelmanlar byk harf update edildi
                sorted().//alfabetik sira
                distinct().//tekrarsiz  yapildi....cooook onmeli ahanda TRICk....
                forEach(t -> System.out.print(t + " "));//yazdirilidi
        //EMRE EMİNE KADER MEHMET NİLGUN YILDIZ İSLAM
    }

    //list elelmanlarinin character sayisini ters sirali olarak tekrarsiz yazdiriniz
    public static void karakterSayisiTekrarsizTersSirali(List<String> list) {
        list.
                stream().
                map(t -> t.length()).//String data character sayisina update edildi
                sorted(Comparator.reverseOrder()).//ters sira
                distinct().//tekrarsiz
                forEach(Lambda01::printEl);//yazdirildi
    }

    //List elemanlarini character sayisina gore kckten byk e gore yazdiriniz.
    public static void karakterSayisiSiraliEl(List<String> list) {
        list.
                stream().
                sorted(Comparator.comparing(t -> t.length())).//eleman character  sayisina gore ozel siralama yapildi
                forEach(t -> System.out.print(t + " "));
    }

    //list elemanlarinin son harfine gore ters sirali yazdiriniz
    public static void sonHarfTersSiraliEl(List<String> list) {
        list.
                stream().
                sorted(Comparator.
                        comparing(t -> t.toString().
                                charAt(t.toString().length() - 1)).//elemanin length()-1)-->son inedx'inin karakterini alir
                                reversed()).//elemanin length()-1)-->son inedx'inin karakterini ters siralar z->a
                forEach(t -> System.out.print(t + " "));
    }

    //listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan,ve karelerini tekrarsiz buyukten kucuge sirali  yaziniz.
    public static void ciftKareTekrarsizTersSira(List<String> list) {
        list.
                stream().
                //filter(t->t.length()%2==0).
                        map(t -> t.length() * t.length()).//string elemnalr character sayisine cevirildi
                filter(Lambda01::ciftBul).//cift sarti calisti
                distinct().//tekrarsiz
                sorted(Comparator.reverseOrder()).//ters sira b->k
                forEach(Lambda01::printEl);//yazdirilidiş

    }

    //List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz
    public static void harfSayisi7Kontrol(List<String> list) {
  // boolean  kontrol=  list.stream().
       //     allMatch(t->t.length()<=7);//her bir elemanı harf syisini <=7 ye eslesmesine bakti
    //    if (kontrol ) {
    //        System.out.println("list elemanlari 7 harfden buyuk degil");
//
    //    }else{
    //        System.out.println("AGAM list elemanlari 7 harfden BUYUK ");
    //    }
        //System.out.println(kontrol);
        System.out.println(list.stream().allMatch(t -> t.length() <= 7)?"list elemanlari 7 harfden buyuk degil":"AGAM list elemanlari 7 harfden BUYUK ");
    }

//List elelmanlarinin "W" ile baslamasını kontrol ediniz
    public static void wBaslamaKontrol(List<String> list){
        System.out.println(list.
                stream().
                noneMatch(t -> t.startsWith("w"))?"w ile baslayan isim kimse ayaga kalksin":"AGAM w ile baslayan isim oluuuurrr ");


    }
    //List elelmanlarinin "x" ile biten en az bir elemaı kontrol ediniz
    public static void xbitmeKontrol(List<String> list){
        System.out.println(list.
                stream().
                anyMatch(t -> t.endsWith("x"))?"x ile biten isim kimse ayaga kalksin":"AGAM x ile biten isim oluuuurrr ");
//anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
//allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
//noneMatch() --> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.

    }
    //Karakter sayisi en buyuk elemani yazdiriniz.
   public static void karakteriEnBuyukEl(List<String> list){
       System.out.println(list.
               stream().
               sorted(Comparator.comparing(t -> t.toString().length()).//lenght karakter uzunluguna gore siraladi k->b
                       reversed()).//ters sirlad b->k
               findFirst());//ilk elelmani aldi

   }
}
