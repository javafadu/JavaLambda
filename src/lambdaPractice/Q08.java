package lambdaPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Q08 {
    // 7 ile bolunebilen ilk 10 tamsayinin toplamini ekrana yazdiriniz.
    public static void main(String[] args) {
        //1.way
        System.out.println(IntStream
                .rangeClosed(1, 70)//1ile 70arasindaki sayilari yzdirmaya yarar
                .filter(t -> 7 == 0)
                .sum());

        //2.way
        System.out.println(IntStream
                .iterate(7, t -> t + 7)//7den baslayip 7ser 7ser
                .limit(10)
                .sum());

    }
}
