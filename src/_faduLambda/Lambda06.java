package _faduLambda;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda06 {

    public static void main(String[] args) throws IOException {
        //TASK 01 --> haluk.txt dosyasini okuyunuz.(Console'a yazdiriniz)
        System.out.println("\n*** haluk.txt dosyasini okuyunuz -->  ");
        Files.lines(Paths.get("src/_faduLambda/haluk.txt")). // Files class dan lines() method call edilerek
                                                                // girilen path deki datalar akisa alindi
                forEach(System.out::println); // akisa alinan datalar print edildi


        //TASK 02 --> haluk.txt dosyasini buyuk harflerle okuyunuz.(Console'a buyuk harflerle yazdiriniz)
        System.out.println("\n*** haluk.txt dosyasini buyuk harflerle okuyunuz -->  ");

            Path link = Path.of("src/_faduLambda/haluk.txt"); // link i variable a assign ettik

            // 1. yol :
        Files.lines(link).
                map(String::toUpperCase). // akisdaki datalar upper case e update (map) edildi
                forEach(System.out::println); // update edilen datalar print edildi

            // 2. yol :
            Stream<String> akis = Files.lines(link);
        akis.map(String::toUpperCase).forEach(System.out::println);


        //TASK 03 --> haluk.txt dosyasindaki ilk satiri kucuk harflerle yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki ilk satiri kucuk harflerle okuyunuz 01 -->  ");
            // 1.yol limit()
        Files.lines(link).limit(1).map(String::toLowerCase).forEach(System.out::println);
            // 2.yol findFirst()
        System.out.println(Files.lines(link).findFirst().map(String::toLowerCase));

        //TASK 04 --> haluk.txt dosyasinda "basari" kelimesinin kac satirda gectiginiz yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda basari kelimesinin kac satirda gectiginiz yazdiriniz -->  ");
        System.out.println(Files.lines(link).
                map(String::toLowerCase).
                filter(t -> t.contains("basari")).
                count());

        //TASK 05 --> haluk.txt dosyasindaki farkli kelimeleri  yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki farkli kelimeleri  yazdiriniz. -->  ");

        /*
        Stream.flatMap, ad??yla tahmin edilebilece??i gibi, bir map ve flat i??leminin birle??imidir.
        Bu, ilk ??nce elemanlar??n??za bir
        fonksiyon uygulad??????n??z ve daha sonra d??zle??tirdi??iniz anlam??na gelir.
        Stream.map yaln??zca ak?????? d??zle??tirmeden bir i??levi uygular.

        Bir ak??????n d??zle??tirme'in neyi i??erdi??ini anlamak i??in,
        "iki seviye" olan [ [1,2,3],[4,5,6],[7,8,9] ] gibi bir yap?? d??????n??n.
        Bunun d??zle??tirilmesi, "bir seviye" yap??s??nda d??n????t??r??lmesi anlam??na gelir: [ 1,2,3,4,5,6,7,8,9 ].
        flatMap y??ntemi, bir ak??????n her bir de??erini ba??ka bir ak????la de??i??tirmenizi sa??lar
        ve ard??ndan olu??turulan t??m ak????lar?? tek bir ak????a birle??tirir.

        */

        // 1. yol : distinct() ve list ile
        System.out.println(Files.lines(link).
                map(t -> t.split(" ")). // satirlardaki kelimeler array a atandin
                flatMap(Arrays::stream). // 2D arraydaki elemanlar tek eleman olarak akisa alindi
                distinct(). // akisdaki elemanlar tekrarsiz yapildi
                collect(Collectors.toList())); // akisdaki tekrarsiz elemanlar liste atandi

        // 2.yol : set ile
        System.out.println(Files.lines(link).
                map(t -> t.split(" ")). // satirlardaki kelimeler array a atandin
                flatMap(Arrays::stream). // 2D arraydaki elemanlar tek eleman olarak akisa alindi
                collect(Collectors.toSet()));

        //TASK 06 --> haluk.txt dosyasindaki tum kelimeleri natural order  yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki tum kelimeleri natural order  yazdiriniz. -->  ");
        Files.lines(link).
                map(t -> t.split(" ")). // line lari split ederek kelimelere bolduk
                flatMap(Arrays::stream). // 2D arraydaki elemanlar tek eleman olarak akisa alindi
                sorted().// natural order edildi
                forEach(System.out::println);


        //TASK 07 --> haluk.txt dosyasinda "basari" kelimesinin kac kere gectigini buyuk harf kucuk harf bag??ms??z yaziniz.
        System.out.println("\n*** haluk.txt dosyasinda basari kelimesinin kac kere gectigini  yazdiriniz. -->  ");
        System.out.println(Files.lines(link).
                map(t -> t.toLowerCase().split(" ")).
                flatMap(Arrays::stream).
                filter(t -> t.equals("basari")).
                count());

        //TASK 08 --> haluk.txt dosyasinda "a" harfi gecen kelimelerin sayisini ekrana yazdiran programi yaziniz
        System.out.println("\n*** haluk.txt dosyasinda a harfi gecen kelimelerin sayisini ekrana yazdiran programi yazdiriniz. -->  ");
        System.out.println(Files.lines(link).
                map(t -> t.split(" ")).
                flatMap(Arrays::stream).
                filter(t -> t.contains("a")).
                count());

        //TASK 09 --> haluk.txt dosyasinda icinde "a" harfi gecen kelimeleri yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda a harfi gecen kelimeler yazdiriniz. -->  ");
        Files.lines(link).
                map(t -> t.split(" ")).
                flatMap(Arrays::stream).
                filter(t -> t.contains("a")).
                forEach(System.out::println);


        //TASK 10 --> haluk.txt dosyasinda kac /farkl?? harf kullanildigini yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda kac /farkl?? harf kullanildigini  yazdiriniz. -->  ");
        System.out.println(Files.lines(link).
                map(t -> t.replaceAll("\\W",""). // satirlar \\W ifadesi a-z A-Z 0-9 disindakileri kapsar
                        replaceAll("\\d","").
                        split("")). // harf akisini saglar
                flatMap(Arrays::stream).
                distinct().
                count());

        //TASK 11 --> haluk.txt dosyasinda kac farkli kelime kullanildigini yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. -->  ");
        System.out.println(Files.lines(link).
                map(t -> t.replaceAll("[.!,:)\\-]",""). // satirlar \\W ifadesi a-z A-Z 0-9 disindakileri kapsar
                        replaceAll("\\d","").
                        split(" ")). // kelime akisini saglar
                        flatMap(Arrays::stream).
                distinct().
                count());

        // TASK 12 --> haluk.txt dosyasinda farkli kelimeleri print ediniz
        Files.lines(link).
                map(t -> t.replaceAll("[.!,:)\\-]",""). // satirlar \\W ifadesi a-z A-Z 0-9 disindakileri kapsar
                        replaceAll("\\d","").
                        split(" ")). // kelime akisini saglar
                flatMap(Arrays::stream).
                distinct().
                forEach(System.out::println);

    }
}
