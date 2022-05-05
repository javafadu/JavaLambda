package lambdaTutorial;

import java.util.stream.IntStream;

public class Lambda05 {
    public static void main(String[] args) {
        System.out.println("TASK 01 amele topla-->" + toplaAmele(10));
        System.out.println("TASK 01 cincix topla-->" + toplaCincix(10));
        System.out.println("   ***   ");

        System.out.println("TASK 02 -->" + toplaCift(10));//2+4+6+8+10 =30
        System.out.println("   ***   ");

        System.out.println("TASK 03 -->" + toplaIlkXCift(10));//2+4+6+...+18+20=110
        System.out.println("   ***   ");

        System.out.println("TASK 04 -->" + toplaIlkXTek(10));//1+3+5+...+19=100
        System.out.println("   ***   ");

        System.out.println("TASK 05 -->");
        ikininIlkXKuvvetPrint(7);
        System.out.println("   ***   ");

        System.out.println("TASK 06 -->");
        isteneSayiIlkXKuvvetPrint(4, 3);
        System.out.println("   ***   ");
        isteneSayiIlkXKuvvetPrint(3, 4);
        System.out.println("   ***   ");


        System.out.println("TASK 07 -->" + istenenSayiFactorial(5));//1*2*3*...*5=120
        System.out.println("   ***   ");

        System.out.println("TASK 08 -->" + xKuvveti(4, 3));//64
        System.out.println("TASK 08 -->" + xKuvveti(3, 4));//81
        System.out.println("   ***   ");

    }

    //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar tamsayilari toplayan bir program create ediniz.

    //Structured(AMELE) Programming

    public static int toplaAmele(int x) {
        int toplam = 0;
        for (int i = 1; i <= x; i++) {
            toplam += i;
        }
        return toplam;
    }

    //Functional(cincix) Programming
    public static int toplaCincix(int x) {
        return IntStream.
                range(1, x + 1).//1 den x'e kadar(x dahil x+1 hariç) int degerler akısa alındı
                        sum();//akısdaki int degerler toplandı
    }

    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.

    public static int toplaCift(int x) {
        return IntStream.
                rangeClosed(1, x).//1 den x'e kadar(x dahil) int degerler akısa alındı
                        filter(Lambda01::ciftBul).//akısdaki çift int degerler filtrelendi
                        sum();//akısdaki int degerler toplandı
    }
    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.

    public static int toplaIlkXCift(int x) {
        return IntStream.
                iterate(2, t -> t + 2).//2 den sonsuza  kadar elemanları 2 artırarak akısa alır -->2,4,6,8,10...
                        limit(x).//akısdaki ilk x int degeri akısa alır
                        sum();//akısdaki int degerler toplandı
        //iterate(seed, repeat action) --> seed'den başlayarak repeat action'a göre  sonsuza kadar elemanları akısa kıyar
    }

    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.
    public static int toplaIlkXTek(int x) {
        return IntStream.
                iterate(1, t -> t + 2).//1 den sonsuza  kadar elemanları 2 artırarak akısa alır -->1,3,5,7,9...
                        limit(x).//akısdaki ilk x int degeri akısa alır
                        sum();//akısdaki int degerler toplandı

        //iterate(seed, repeat action) --> seed'den başlayarak repeat action'a göre  sonsuza kadar elemanları akısa kıyar
    }

    //TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi  create ediniz.

    public static void ikininIlkXKuvvetPrint(int x) {
        IntStream.
                iterate(2, t -> t * 2).//2 den sonsuza  kadar elemanları 2 ile carparak akısa alır -->2,4,8,16,32...
                limit(x).//akısdaki ilk x int degeri akısa alır
                forEach(Lambda01::yazdir);//akısdaki int degerler toplandı

        //iterate(seed, repeat action) --> seed'den başlayarak repeat action'a göre  sonsuza kadar elemanları akısa kıyar
    }
    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.

    public static void isteneSayiIlkXKuvvetPrint(int isteneSayi, int x) {
        IntStream.
                iterate(isteneSayi, t -> t * isteneSayi).//2 den sonsuza  kadar elemanları 2 ile carparak akısa alır -->2,4,8,16,32...
                limit(x).//akısdaki ilk x int degeri akısa alır
                forEach(Lambda01::yazdir);//akısdaki int degerler toplandı

        //iterate(seed, repeat action) --> seed'den başlayarak repeat action'a göre  sonsuza kadar elemanları akısa kıyar
    }

    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.
    public static int istenenSayiFactorial(int x) {
        return IntStream.
                rangeClosed(1, x).
                //reduce(Math::multiplyExact).
                        reduce(1, (t, u) -> t * u);
    }

    //TASK 08 --> Istenilen bir sayinin  x. kuvvetini ekrana yazdiran programi  create ediniz.
    public static int xKuvveti(int istenenSayi, int x) {
        return IntStream.
                iterate(istenenSayi, t -> t * istenenSayi).
                limit(x).reduce(0, (t, u) -> u);
         // return Math.pow(istenenSayi,x);
    }

}
