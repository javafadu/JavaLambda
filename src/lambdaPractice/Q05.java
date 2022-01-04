package lambdaPractice;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Q05 {
    //         {"A", "B", "D", "C", "B", "A", "A", "B", "B"} gibi bir array oluşturun;
//         Tekrarlanan öğeleri konsolda yazdırın
    public static void main(String[] args) {
    //  List<String> list = new ArrayList<String>(Arrays.asList("A", "B", "D", "C", "B", "A", "A", "B", "B"));
        String arr[] = {"A", "B", "C", "B", "D", "A", "B", "B"};
        List<String> list = Arrays.asList(arr);
        list.stream()
                .filter(t -> Collections.frequency(list, t) > 1)
                .collect(Collectors.toSet())
                .forEach(t -> System.out.println(t));
    }


}

