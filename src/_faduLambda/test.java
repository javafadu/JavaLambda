package _faduLambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class test {

    // TASK : indexi tek sayi olan karakterleri yazdiran bir code create ediniz
    public static void main(String[] args) {

        String mtn="Lambda candir";

        String[] metin=mtn.split("");
        System.out.println(indexTeksayiYazdir(List.of(metin)));

    }

    public static  List<String> indexTeksayiYazdir(List<String> metin){
        return IntStream
                .range(0, metin.size()).
                filter(t -> t % 2 != 0).
                mapToObj(metin::get).
                collect(Collectors.toList());
    }

}
