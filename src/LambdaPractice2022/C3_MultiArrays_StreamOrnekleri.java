package LambdaPractice2022;
//multi arrayleri cevirirken flatMap kullaniriz yapilis sekli iki turludur
//1) lamda kullanarak
// Arrays.stream(arr).flatMap(t->Arrays.stream(t))
//2) method ile
// Arrays.stream(arr).flatMap(Arrays::stream)
// BU SEKLIDE ARTIK TUM STREAM METHODLARI KULLANILABILIR

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class C3_MultiArrays_StreamOrnekleri {
    public static void main(String[] args) {
        String arr[][] = {
                {"Elma", "Muz"},
                {"Portakal", "Cilek", "Limon"},
                {"Havuc","Erik"}
        };


    }
    // S1 : tum elemanlari list yapalim



    // S2: E ile baslayan elemanlari double (elmaelma) olarak yazdiralim



    // S3: E ile baslayan elemanlari liste olarak yazdiralim



    //S4 : k ile bitenlerin sonuna '*' ekleyelim


}
