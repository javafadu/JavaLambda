package _faduLambda;

import java.util.*;

public class Lambda02 {
    public static void main(String[] args) {

        List<Integer> sayi = new ArrayList<>(Arrays.asList(4, 2, 6, 11, -5, 7, 3, 15));

        ciftKarePrint(sayi);  // 16 4 36
        System.out.println("\n   ***   ");
        tekKupBirFazlaPrint(sayi); // 1332 344 28 3376
        System.out.println("\n   ***   ");
        ciftKarekokPrint(sayi); // 2.0 1.4142135623730951 2.449489742783178
        System.out.println("\n   ***   ");
        maxElBul(sayi);  // Optional[15]   // halukca : Optional[15]
        System.out.println("\n   ***   ");
        ciftElKareMax(sayi);
        System.out.println("\n   ***   ");
        elTopla(sayi);
        System.out.println("\n   ***   ");
        cifElCarpim(sayi);
        System.out.println("\n   ***   ");
        enKucukBul(sayi);
        System.out.println("\n   ***   ");
        bestenBykEnKck(sayi);
        System.out.println("\n   ***   ");
        ciftKareKbPrint(sayi);
        System.out.println("\n   ***   ");
        tekKareBkPrint(sayi);
        System.out.println("\n   ***   ");



    }

    // Task1 : Functional Programming ile listin cift elemanlarinin  karelerini ayni satirda aralarina bosluk bırakarak print ediniz

    public static void ciftKarePrint(List<Integer> sayi) {
        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(t -> t * t). //map()--> Stream içerisindeki elemanları başka tiplere dönüştürmek veya üzerlerinde işlem yapmak (update) için Map kullanılmaktadır.
                forEach(Lambda01::yazdir);

    }

    // Task2 : Functional Programming ile listin tek elemanlarinin  kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak print edi

    public static void tekKupBirFazlaPrint(List<Integer> sayi) {
        sayi.
                stream(). // sayilar akisa alindi
                filter(t->t%2!=0). // tek elemanlar filtrelendi
                map(t->(t*t*t)+1). // tek elemanlarin kuplerinin 1 fazlasia update edildi
                forEach(Lambda01::yazdir); // print edildi
    }


    // Task3 : Functional Programming ile listin cift elemanlarinin   karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz

    public static void ciftKarekokPrint(List<Integer> sayi) {
        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(Math::sqrt). //math ref
                //forEach(lambdaTutorial.Lambda01::yazdir)--> yazdir() method int.  çalıştığı için map den çıkan dataları çalıştırmaz
                        forEach(t->System.out.print(t+" "));
    }

    // Task4 : list'in en buyuk elemanini yazdiriniz

    public static void maxElBul(List<Integer> sayi) {

        Optional<Integer> maxSayi = sayi.stream().reduce(Math::max); // akisa giren elemanlarin aksiyon sonrasi tek eleman haline getirir
        System.out.println(maxSayi);
        System.out.println("halukca : "+sayi.stream().reduce(Math::max));
        /*
        reduce()-->azaltmak ... bir cok datayi tek bir dataya(max min carp top vs islemlerde) cevirmek icin kullanilir.
        kullanımı yaygındır pratiktir.
        Bir Stream içerisindeki verilerin teker teker işlenmesidir. Teker teker işleme sürecinde, bir önceki adımda elde edilen sonuç
        bir sonraki adıma girdi olarak sunulmaktadır. Bu sayede yığılmlı bir hesaplama süreci elde edilmiş olmaktadır.
        reduce metodu ilk parametrede identity değeri, ikinci parametrede ise BinaryOperator türünden bir obj kullanılır.
        reduce işleminde bir önceki hesaplanmış değer ile sıradaki değer bir işleme tabi tutulmaktadır.
        İşleme başlarken bir önceki değer olmadığı için bu değer identity parametresinde tanımlanmaktadır.
        */
    }


    // Task5 : List'in cift elemanlarin karelerinin en buyugunu print ediniz

    public static void ciftElKareMax(List<Integer> sayi) {
        System.out.println(sayi.stream().filter(Lambda01::ciftBul).map(t -> t * t).reduce(Math::max));
        // Optional[36]

        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(t -> t * t).
                reduce(Integer::max));  // Optional[36] daha specific class daha hizli run olur (Integer)

    }

    // Task6 : List'teki tum elemanlarin toplamini yazdiriniz.
    //Lambda Expression...

    public static void elTopla(List<Integer> sayi) {

        int toplam = sayi.stream().reduce(0,(a,b)->a+b);
        System.out.println("Lamba exp: "+toplam);  // Lamba exp: 43
        /*
        a ik degeri her zaman atanan degerden (identity) alir
        b degerini her zaman stream() den alir
        a ilk degerinden sonraki her degeri action(islem) den alir
         */
        Optional<Integer> toplam2 = sayi.stream().reduce(Integer::sum);
        System.out.println("Method Ref: "+toplam2); // method reference // Method Ref: Optional[43]
    }

    // Task7 : List'teki cift elemanlarin carpimini  yazdiriniz.
    public static void cifElCarpim(List<Integer> sayi) {
        // method ref
        System.out.println("Method Ref: " +sayi.
                stream().
                filter(Lambda01::ciftBul).
                reduce(Math::multiplyExact)); // Optional[48]



        // Lambda exp
        System.out.println("Lambda exp. : " + sayi.   // Lambda exp. : 48
                stream().
                filter(Lambda01::ciftBul).
                reduce(1, (a, b) -> (a * b)));
    }

    // Task8 : List'teki elemanlardan en kucugunu 4 farklı yontem ile print ediniz.


    public static void enKucukBul(List<Integer> sayi) {
        //1. yontem Method Reference --> Integer class
        Optional<Integer> minSayiInteger = sayi.stream().reduce(Integer::min);
        System.out.println(minSayiInteger);
        //2. yontem Method Reference --> Math class
        Optional<Integer> minSayiMath = sayi.stream().reduce(Math::min);
        System.out.println(minSayiMath);
        //3. yontem Lambda Expression
        int minSayiLJambda = (sayi.stream().reduce(Integer.MAX_VALUE, (x, y) -> x < y ? x : y));
        System.out.println(minSayiLJambda);
        //4. yontem Method Reference --> Haluk class
        Optional<Integer> minSayiHaluk = sayi.stream().reduce(Lambda02::byHalukMin);
        System.out.println(minSayiHaluk);

    }
    public static int byHalukMin(int a, int b) {//bu method kendisine verilen iki int degerin en kücügunu return eder
        return a < b ? a : b;
    }


    // Task9 : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.
    public static void bestenBykEnKck(List<Integer> sayi) {

        System.out.println(sayi.stream().filter(t -> t > 5 && t % 2 == 1).reduce(Lambda02::byHalukMin));
    }

    // Task10 : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.
    public static void ciftKareKbPrint(List<Integer> sayi) {
        sayi.stream(). // akisa alindi
                filter(Lambda01::ciftBul). // cift sayilar filtrelendi
                map(t->t*t). // alinanlarin karesi alindi
                sorted(). // karesi alinan elemanlar dogal sira (natural ASC) siralandi
                forEach(Lambda01::yazdir); // print edildi

        //sorted() => Doğal düzene göre sıralanmış, bu akışın elemanlarında oluşan bir akış döndürür.
        //Sorted() methodu tekrarlı kullanılırsa en son kullanılan aktif olur.

    }

    // Task : list'in tek  elemanlarinin kareleri ni buykten kucuge  print ediniz.

    public static void tekKareBkPrint(List<Integer> sayi) {
        sayi.
                stream(). // akisa alindi
                filter(t->t%2==1). // tek sayilar filtrelendi
                map(t->t*t).// tek sayilarin kareleri alindi
                sorted(Comparator.reverseOrder()).// ters siralandi (buyukten kucuge)
                forEach(Lambda01::yazdir); // print edildi
    }

}
