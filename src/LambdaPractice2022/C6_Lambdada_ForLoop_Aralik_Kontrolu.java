package LambdaPractice2022;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class C6_Lambdada_ForLoop_Aralik_Kontrolu {

    public static void main(String[] args) {

        sirala(30);
        System.out.println();
        sirala2(30);
        System.out.println();
        System.out.println("sayiAraligiTopla(1,5) = " + sayiAraligiTopla(1, 5));
        System.out.println("sayiAraligiOrtalama(30,40) = " + sayiAraligiOrtalama(30, 40));
        sekizeBolunen(325,468);
        sekizeBolunenYaz(325,468);
        System.out.println();
        System.out.println("sekizeBolunenToplam(325,468) = " + sekizeBolunenToplam(325, 468));
        System.out.println("tekSayilarinCarpimi(7,15) = " + tekSayilarinCarpimi(7, 15));
        pozitifIlkOnEleman(10);
        System.out.println("Yedi nin katlari");
        yedininKatTekSayilar(21);

    }

    // S1:1 den 30 kadar olan sayilari (30 dahil degil) 1 2 3 .... seklinde siralayalim (for loopsuz)
    //range(int startInclusive, int endExclusive)

    public static void sirala(int sayi) {
        IntStream.range(1,sayi).forEach(Methods::yazInteger);
    }



    //S2 1 den 30 kadar olan sayilari (30 dahil ) 1 2 3 .... seklinde siralayalim (for loopsuz)
    //rangeClosed(int startInclusive, int endInclusive)

    public static void sirala2 (int sayi) {
        IntStream.rangeClosed(1,sayi).forEach(Methods::yazInteger);
    }

    //S3 Istenen iki deger(dahi) arasindaki sayilari toplayalim

    public static int sayiAraligiTopla(int a, int b) {
        return IntStream.rangeClosed(a,b).sum();
    }


    //S4: 30 ile 40 arasindaki sayilarin (dahi) ortalamasini bulalim

    public static OptionalDouble sayiAraligiOrtalama(int a, int b) {
        return IntStream.rangeClosed(a,b).average();

    }

    //S5: 325 ile 468 arasinda 8 e bolunen kac sayi vardir?

    public static void sekizeBolunen(int a, int b) {
        System.out.println(IntStream.rangeClosed(a, b).filter(t -> t % 8 == 0).count());
    }

    //S6: 325 ile 468 arasinda 8 e bolunen sayilari yazdiralim
    public static void sekizeBolunenYaz(int a, int b) {
        IntStream.rangeClosed(a, b).filter(t -> t % 8 == 0).forEach(t-> System.out.print(t+ " "));
    }

    // S7:325 ile 468 arasinda 8 e bolunen sayilarin toplamini bulalim
    public static Integer sekizeBolunenToplam(int a, int b) {
        return IntStream.rangeClosed(a, b).filter(t -> t % 8 == 0).sum();
    }

    // S8: 7ile 15 arasindaki tek sayilarin carpimini bulalim

    public static OptionalInt tekSayilarinCarpimi(int a, int b) {
        return IntStream.rangeClosed(a, b).filter(t -> t % 2 == 1).reduce(Math::multiplyExact);
    }


    //S9: pozitif tek sayilarin ilk 10 elemanin yazdiralim
    public static void pozitifIlkOnEleman(int a) {
        IntStream.iterate(1,t->t+2).
                limit(10).
                forEach(Methods::yazInteger);
    }

    //S10: 21 den baslayan 7 nin katlarinin tek olanlari ilk 10 teriminin yaziralim
    public static void yedininKatTekSayilar(int a) {
        IntStream.rangeClosed(a,Integer.MAX_VALUE).
                filter(t-> t%7==0).
                filter(Methods::tekMi).
                limit(10).
                forEach(Methods::yazInteger);
    }


    //S11: 21 den baslayan 7 nin katlarinin ilk 20 teriminin toplayalim

}
//iterate bize sayilari istedigimiz sekilde yineletmeyi saglar yani buradaki ornekte 7ser7ser artmayi saglar
//iterate icin bir baslangic degeri girilmeli ve artisin nasil olacagi belirtilmeli nerede biteceginide
// limit() ile belirliyoruz