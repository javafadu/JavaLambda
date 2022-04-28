package _faduLambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda01 {
    public static void main(String[] args) {


        List<Integer> sayi = new ArrayList<>(Arrays.asList(34,22,16,11,35,20,63,21,65,44,66,64,81,38,15));
        printElStructured(sayi);
        System.out.println("\n   ***   ");
        printElFunctional(sayi);
        System.out.println("\n   ***   ");
        printElFunctional1(sayi);
        System.out.println("\n   ***   ");
        printElFunctional2(sayi);
        System.out.println("\n   ***   ");
        printCiftElStructured(sayi);
        System.out.println("\n   ***   ");
        printCiftElFunctional(sayi);
        System.out.println("\n   ***   ");
        printCiftElFunctional1(sayi);
        System.out.println("\n   ***   ");
        printCiftOtxDrtKucukElFunctional(sayi);
        System.out.println("\n   ***   ");
        printCiftOtzBuyukElFunctional(sayi);
    }

    // Task1 : "Structured Programing" kullanarak list elemanlarini ayni satirda aralarinda bosluk olacak sekilde print ediniz
    public static void printElStructured(List<Integer> sayi) {
        for (Integer each:sayi
        ) {
            System.out.print(each+" ");
        }
    }

    // Task2 : "Functional Programing" kullanarak list elemanlarini ayni satirda aralarinda bosluk olacak sekilde print ediniz
    public static void printElFunctional(List<Integer> sayi) {
        sayi.stream().forEach(t->System.out.print(t+" "));  // each = t
    }

    /*
 stream() : datalari yukaridan asagiya akis sekline getirir. Stream bir interface olduğundan dolayı doğrudan nesne almaz.
 forEach() :datanin parametresine gore her bir elemanı isler
 t-> : Lambda operatoru
  Lambda Expression-->(parameter list) -> {action body}
      Parameter list: Fonksiyonun parametreleri tanımlanır. Hiç parametre geçirmeden boşta olabilir.
      -> Arrow-token: Argüman listesi ile expression gövdesini birbirine bağlamak için kullanılır.
      Body: Expressionları ve statementları içerir.

     Bir kod bloğundan oluşan bir body...
     Bu tip lambda body, block body olarak bilinir. Blok gövdesi, lambda gövdesinin birden çok ifade içermesine izin verir.
     Bu ifadeler parantez içine alınır ve parantezlerden sonra noktalı virgül eklemeniz gerekir.

         () -> {
          double pi = 3.1415;
             return pi;
         };
  TRICK : Lambda Expression  yapisi cok tavsiye edilmez daha cok METHOD REFERENCE kullanilir

 */

    public static void printElFunctional1(List<Integer> sayi) {
        sayi.stream().forEach(System.out::print);  // methoda reference --> System.out yapisindan print methodu refere et
    }                                           // bu action ayni satir yazdirir ama bosluk birakmaz bunun icin seed method
    // create etmemiz gerekiyor.

    public static void yazdir(int a){ // verilen int degeri ayni satirda bosluk birakara
        // yazdirma aksiyonu yapan seed method create edin
        System.out.print(a+" ");
    }

    public static void printElFunctional2(List<Integer> sayi) {
        sayi.stream().forEach(Lambda01::yazdir);  // methoda reference --> System.out yapisindan print methodu refere et
    }


    // Task3 : Structured Programing ile list elemanlarinin cift olanlarini ayni satira aralarinda bosluk birakrak yazdirin

    public static void printCiftElStructured (List<Integer> sayi) {
        for (Integer each:sayi
        ) {
            if(each%2==0) {
                System.out.print(each+" ");
            }
        }
    }

    // Task4 : Functional Programing ile list elemanlarinin cift olanlarini ayni satira aralarinda bosluk birakrak yazdirin

    public static void printCiftElFunctional (List<Integer> sayi) {
        sayi.stream().filter(t->t%2==0).forEach(Lambda01::yazdir);
    }

    public static boolean ciftBul(int a) {
        return a%2==0;
    }

    public static void printCiftElFunctional1 (List<Integer> sayi) {
        sayi.
                stream(). // list elemanlari islem akisina sok
                filter(Lambda01::ciftBul).// ciftBul method refere edilerek akistaki elemanlar filtrelendi
                forEach(Lambda01::yazdir); // filtreden gelen elemanlar yazdir method refere edilerek print edildi
    }

    // Task5 : Functional Programing ile list elemanlarinin 34 den kucuk
    // cift olanlarini ayni satira aralarinda bosluk birakrak yazdirin

    public static void printCiftOtxDrtKucukElFunctional (List<Integer> sayi) {
        sayi.
                stream().
                filter(t->t%2==0 && t<34).
                // filter(Lambda01::ciftBul).  (method ref)
                // filter(t->t<34).            (lambda exp)
                        forEach(Lambda01::yazdir);
    }

    // Task6 : Functional Programing ile list elemanlarinin 34 den buyuk veya
    // cift olanlarini ayni satira aralarinda bosluk birakrak yazdirin
    public static void printCiftOtzBuyukElFunctional (List<Integer> sayi) {
        sayi.
                stream().
                filter(t->t%2==0 || t>34).

                forEach(Lambda01::yazdir);
    }


}
