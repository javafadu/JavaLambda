package lambdaPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q06 {
    //Fonksiyonel Programlama ile [12, 9, 13, 4, 6, 2, 4, 12, 15] listesindeki tüm tek sayıları yazdırın
    //6 ile 14 arasindaki tum sayilarin karesini ekrana yazdiriniz
    //Listteki tek tamsayilarin karekoklerinin toplamini ekrana yazdiriniz
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(12, 9, 13, 4, 6, 2, 4, 12, 15));
        System.out.println(" ===== Task 01 =====");
        tekSayiYazdir(list);
        System.out.println("\n ===== Task 02 =====");
        altiOndortArasiKareToplami(list);
        System.out.println(" ===== Task 03 =====");
        tekSayiKarekokToplami(list);
    }

    // Task 01 -> //Fonksiyonel Programlama ile listedeki tüm tek sayıları yazdırın
    public static void tekSayiYazdir(List<Integer> list) {
        list.
                stream().
                filter(t -> t % 2 == 1).
                forEach(t -> System.out.print(t + " "));
    }

    // Task 02 --> 6 ile 14 arasindaki tum sayilarin karesini ekrana yazdiriniz
    public static void altiOndortArasiKareToplami(List<Integer> list) {
        System.out.println(list.
                stream().
                filter(t -> t > 6 && t < 14).
                map(t -> t * t).
                reduce(Integer::sum));
    }

    //Task 03 --> Listteki tek tamsayilarin karekoklerinin toplamini ekrana yazdiriniz
    public static void tekSayiKarekokToplami(List<Integer> list) {

        System.out.println(list.
                stream().
                filter(t -> t % 2 == 1).
                mapToDouble(Math::sqrt).
                sum());
                //.reduce(Double::sum));
    }
}
