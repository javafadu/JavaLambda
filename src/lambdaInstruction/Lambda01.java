package lambdaInstruction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda01 {
    /*
	 	1) Lambda "Functional Programming"
	 		"Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
	 	2) "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur
	 	3) "Functional Programming" hiz, code kisaligi, code okunabilirligi
	 	ve hatasiz code yazma acilarindan cok faydalidir.
	 	4) Lambda sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak map'lerde kullanılmaz.
        Lambda kullanmak hatasız code kullanmaktır.
	 */
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(12, 13, 65, 3, 7, 34, 22, 60, 42, 55));
        printElStructured(list);//method call
        System.out.println();
        System.out.println("   ***   ");
        printElfunctional(list);//lambda expression
        System.out.println();
        System.out.println("   ***   ");
        printElfunctional1(list);//method reference
        System.out.println();
        System.out.println("   ***   ");
        printCiftElStuructured(list);
        System.out.println();
        System.out.println("   ***   ");
        printCiftElFunctional1(list);
        System.out.println();
        System.out.println("   ***   ");
        printCiftElFunctional2(list);
        System.out.println();
        System.out.println("   ***   ");
        printCiftAltmısKucuk(list);
        System.out.println();
        System.out.println("   ***   ");
        tekYirmidenbuyukPrint(list);
        System.out.println();
        System.out.println("   ***   ");
        ciftKarePrint(list);
        System.out.println();
        System.out.println("   ***   ");
        kupBirFazlaTekFunction(list);
        System.out.println();
        System.out.println("   ***   ");
        karekokCiftfunctional(list);
        System.out.println();
        System.out.println("   ***   ");
        maxElfunction(list);
    }

    //structured Programming ile list elemanlerinin  tamamini aralarina bosluk birakarak yazdiriniz
    public static void printElStructured(List<Integer> list) { //12 13 65 3 7 34 22 60 42 55
        for (Integer w : list) {
            System.out.print(w + " ");

        }
    }

    //Functional Programming ile list elemanlerinin  tamamini aralarina bosluk birakarak yazdiriniz
    public static void printElfunctional(List<Integer> list) {
        list.stream().forEach(t -> System.out.print(t + " "));//Lambda Expression :Lambda ifadesi
        //stream() : datalari yukaridan asagiya akis sekline getirir.
        //forEach() :datanin parametresine gore her bir elemanı isler
        //t-> : Lambda operatoru
        // Lambda Expression  yapisi cok tavsiye edilmez daha cok METHOD REFERENCE kullanilir

    }
    //Method Reference --> kendi create ettigimiz veya java'dan aldigimiz method ile
    // ClassName::MethodName--> ez- ber- leeeeee

    public static void printEl(int t) {//refere eddilecek method create edildi
        System.out.print(t + " ");
    }

    public static void printElfunctional1(List<Integer> list) {
        list.stream().forEach(Lambda01::printEl);//iste lambda budur...
    }

    //structured Programming ile list elemanlarinin  cift olanalrini ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void printCiftElStuructured(List<Integer> list) {
        for (Integer w : list) {
            if (w % 2 == 0) {
                System.out.print(w + " ");
            }
        }
    }

    //Functional Programming ile list elemanlarinin  cift olanalrini ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void printCiftElFunctional1(List<Integer> list) {
        list.stream().filter(t -> t % 2 == 0).forEach(Lambda01::printEl);
        //filter()--> ais icersindeki elemanlari istenen sarta göre filtreleme yapar
    }

    public static boolean ciftBul(int i) {//refere edilecek tohum method creATE EDİLDİ

        return i % 2 == 0;

    }

    public static void printCiftElFunctional2(List<Integer> list) {
        list.stream().filter(Lambda01::ciftBul).forEach(Lambda01::printEl);//İKİ TANE METHOD REFERE
        //filter()--> ais icersindeki elemanlari istenen sarta göre filtreleme yapar
    }

    //Functional Programming ile list elemanlarinin  cift olanalrinin 60 dan kucuk olanlarını ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void printCiftAltmısKucuk(List<Integer> list) {
        list.stream().filter(t -> t % 2 == 0 & t < 60).forEach(Lambda01::printEl);
    }

    //Functional Programming ile list elemanlarinin  tek olanalrini veya 20 dan buyuk
    // olanlarını ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void tekYirmidenbuyukPrint(List<Integer> list) {
        list.stream().filter(t ->t%2 == 1 ||t>20).forEach(Lambda01::printEl);

    }
    //Functional Programming ile list elemanlarinin  cift olanlarinin
    // karelerini ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void ciftKarePrint(List<Integer> list){
        list.
                stream().
                filter(Lambda01::ciftBul).
                map(t->t*t).
                forEach(Lambda01::printEl);
//map()--> bir ara islemde kullanilir.elemanları istenen isleme gore degistirmek update etmek icin kullanilir.
    }
    //Functional Programming ile list elemanlarinin  tek olanlarinin
    // kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak yazdiriniz

    public static void kupBirFazlaTekFunction(List<Integer> list){
        list.
                stream().
                filter(t->t%2==1).
                map(t->(t*t*t)+1).
                forEach(Lambda01::printEl);
    }
    //Functional Programming ile list elemanlarinin  cift olanlarinin
    // karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void karekokCiftfunctional(List<Integer> list){
        list.
                stream().
                filter(Lambda01::ciftBul).
                map(Math::sqrt).
                forEach(t->System.out.println(t+" "));
    }
    //list'in en buyuk elemanini yazdiriniz
    public static void maxElfunction(List<Integer> list){
     Optional<Integer> maxEl = list.stream().reduce(Math::max);
       System.out.println(maxEl);
        //reduce()-->azaltmak ... bir cok datayi tek bir dataya(max min carp top vs islemlerde) cevirmek icin kullanilir






























    }
}
