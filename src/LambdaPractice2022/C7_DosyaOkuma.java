package LambdaPractice2022;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
dosya eklemek icin 2 yol var
1) Files.lines(Path.of("path")  buradan stream e eklemek icin
Stream <String> satir=Files.lines(Path.of(".........."));
bu bize tekrardan stream tanimlamadan kullanmayi saglar
2) //Files.lines(Paths.get("..........")).  kullanilir
==========================================================
intellj dosya eklemek icin src => new=>file=>text diyoruz ve istedigimiz metni buraya kopyaliyoruz
bu dosyanin path almak icin dosyanin uzerine gelip sag tikliyoruz(burada dosya C7_TextFile)
sonrasinda copy path seciyoruz bundan sonra iki secenek var
1) absolute path seciyoruz yada
2) path from content root seciyoruz
her ikisinde de path kopyalamis oluyoruz

cevirirken EXCEPTION OLUSMASIN DIYE => throws IOException <= EKLEMELIYIZ
buda lines altinda kirmizi uyari veriyor uzerine tiklayinca kendiliginden oluyor
*/
public class C7_DosyaOkuma {

    public static void main(String[] args) throws IOException {


        //NOT PATH cift tirnak icine alinmali
        //artik stream e donustu methodlari kullanabiliriz
        Path satir = Path.of("src/LambdaPractice2022/C7_TextFile");

    // S1: Yazdiralim

        Files.lines(satir).forEach(t-> System.out.println(t));


    //S2: tum harflari buyuk harf ile yazdiralim

        Files.lines(satir).map(String::toUpperCase).forEach(t-> System.out.println(t));

    // S3: son satiri buyuk harfle yazdiralim
        Files.lines(satir).skip(4).map(String::toUpperCase).forEach(t-> System.out.println(t));

    //S4: 2.ve 3. satirlari yazdiralim

        Files.lines(satir).skip(1).limit(2).forEach(t-> System.out.println(t));
    //S5: kac tane "icin" kelimesi vardir



    //S6: tum kelimelerin tum kelimeleri natural order  yazdiriniz.
        Files.lines(satir).map(t-> t.split(" ")).flatMap(Arrays::stream).
                sorted().forEach(t-> System.out.println(t));

    // S7:  metinde kac tane "a"  vardir


    }

}
