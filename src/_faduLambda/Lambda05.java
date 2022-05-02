package _faduLambda;

import java.util.Arrays;
import java.util.stream.IntStream;

import static java.awt.SystemColor.menu;

public class Lambda05 {
    public static void main(String[] args) {

        // TASK1:
        System.out.println("---TASK1-----");
        System.out.println("Task1 Structured : "+xeKadarSayilariToplaStructured(20));
        System.out.println("Task1 Functional : "+xeKadarSayilariToplaFunctional(20));
        System.out.println("Task1 FaDu : "+xeKadarSayilariToplaFaDu(20));

        // TASK2:
        System.out.println("---TASK2-----");
        System.out.println("Task2 Structured : "+xeKadarCiftSayilariToplaStructured(20));
        System.out.println("Task2 Structured : "+xeKadarCiftSayilariToplaFunctional(20));

        // TASK3:
        System.out.println("---TASK3-----");
        System.out.println("Task3 Functional : "+ilkxPozitifCiftSayiToplaFunctional(5));

        // TASK4:
        System.out.println("---TASK4-----");
        System.out.println("Task3 Functional : "+ilkxPozitifTekSayiToplaFunctional(5));

        // TASK5:
        System.out.println("---TASK5-----");
        ikininIlkXKuvvetiPrintFunctional(3);
        System.out.println();

        // TASK6:
        System.out.println("---TASK6-----");
        sayininIlkXKuvvetiPrintFunctional(5,5);
        System.out.println();

        // TASK7:
        System.out.println("---TASK7-----");
        System.out.println("Task7 Functional : "+sayiFaktoriyelHesaplaFunctional(5));
        System.out.println();

        // TASK8:
        System.out.println("---TASK8-----");
        sayininXKuvvetiPrintFunctional(3,5);
        System.out.println();





    }

    //TASK 01 --> Structured Programming ve Functional Programming
    // ile 1'den x'e kadar tamsayilari toplayan bir program create ediniz.

    //Structured(AMELE) Programming

    public static int xeKadarSayilariToplaStructured(int x) {
        int toplam=0;
        for (int i = 0; i < x+1; i++) {
            toplam+=i;
        }
        return toplam;
    }


    //Functional(cincix Programming
    public static int xeKadarSayilariToplaFunctional(int x) {
        return IntStream.range(0,x+1).reduce(0,Math::addExact);
    }

    public static int xeKadarSayilariToplaFaDu(int x) {
        return x*(x+1)/2;
    }


    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.

    //Structured(AMELE) Programming
    public static int xeKadarCiftSayilariToplaStructured(int x) {
        int toplam=0;
        for (int i = 0; i < x+1; i++) {
            if(i%2==0) {
                toplam+=i;
            }
        }
        return toplam;
    }

    //Functional(cincix Programming
    public static int xeKadarCiftSayilariToplaFunctional(int x) {
        return IntStream.range(0,x+1).filter(t->t%2==0).reduce(0,Math::addExact);
    }

    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.

    public static int ilkxPozitifCiftSayiToplaFunctional(int x) {
        return IntStream.range(0,Integer.MAX_VALUE).filter(t->t%2==0).limit(x+1).reduce(0,Integer::sum);
    }

    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.
    public static int ilkxPozitifTekSayiToplaFunctional(int x) {
        return IntStream.range(1,Integer.MAX_VALUE).filter(t->t%2==1).limit(x).reduce(0,Integer::sum);
    }

    //TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void ikininIlkXKuvvetiPrintFunctional(int x) {
        IntStream.range(0,Integer.MAX_VALUE).limit(x).mapToDouble(t->Math.pow(2,t)).forEach(t->System.out.print(t+" , "));
    }

    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void sayininIlkXKuvvetiPrintFunctional(int sayi, int x) {
        IntStream.range(0,Integer.MAX_VALUE).limit(x).mapToDouble(t->Math.pow(sayi,t)).forEach(t->System.out.print(t+" , "));
    }

    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.
    public static int sayiFaktoriyelHesaplaFunctional(int sayi) {
        return IntStream.range(1,sayi+1).reduce(1,Math::multiplyExact);

    }

    //TASK 08 --> Istenilen bir sayinin  x. kuvvetini ekrana yazdiran programi  create ediniz.
    public static void sayininXKuvvetiPrintFunctional(int sayi, int x) {
        IntStream.range(0,Integer.MAX_VALUE).limit(1).mapToDouble(t->Math.pow(sayi,x)).forEach(t->System.out.print(t+" "));
    }

}
