package lambdaTutorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambda04Printf {

        public static void main(String[] args) {
            Universite unv1 = new Universite("Ankara","Bilgisayar",256,52);
            Universite unv2 = new Universite("Istanbul","Matematik",322,77);
            Universite unv3 = new Universite("Izmir","Edebiyat",109,83);
            Universite unv4 = new Universite("Bursa","Makine",287,74);
            Universite unv5 = new Universite("Kayseri","Matematik",99,88);
            List<Universite> unvList = new ArrayList<Universite>(Arrays.asList(unv1,unv2,unv3,unv4,unv5));

            notOrtalamaKontrol(unvList);
            System.out.println("=======");
            ogrncSayiKontrol(unvList);
            System.out.println("=======");
            bolumMatKontrol(unvList);
            System.out.println("=======");
            ogrSayisinaGoreSirala(unvList);
            System.out.println("=======");
            notOrtalamasinaGoreSirala(unvList);
            System.out.println("=======");
            ogrSayiAzOlanIkinciUnv(unvList);
            System.out.println("=======");
            notOrt63BykOlnUnvOgrSyToplm(unvList);
            System.out.println("=======");
            ogrSay130danFzlaUnvNotOrtToplm(unvList);
            System.out.println("=======");
            matBolumSayisi(unvList);
            System.out.println("=======");
            ogrSay130NotOrtBykOlan(unvList);
            System.out.println("=======");
            ogrSay150azNotOrtKckOlan(unvList);
        }
        private static void yazdir(Universite u) {

            System.out.printf("%-10s %20s %20d %20d\n",u.getUniversite(),u.getBolum(),u.getOgrSayisi(),u.getNotOrt());
        }


        //task 01--> notOrt'larinin 74' den buyuk oldg kontrol eden pr create ediniz.
        public static void notOrtalamaKontrol(List<Universite> unvList){
            System.out.println("Task 1 : Not ortalamasi 74'den fazla olan universiteler");
            System.out.printf("%-10s %20s %20s %20s\n","Universite","Bolum","Ogrenci Sayisi","Not Ortalamasi");
            unvList.
                    stream().
                    filter(t-> t.getNotOrt()>74).
                    forEach(Lambda04Printf::yazdir);
        }

        //task 02-->ogrc sayilarinin   110 den az olmadigini  kontrol eden pr create ediniz.
        public static void ogrncSayiKontrol(List<Universite> unvList){
            System.out.println("Task 2 : Ogrenci sayisi 110'dan fazla olan universiteler");
            System.out.printf("%-10s %20s %20s %20s\n","Universite","Bolum","Ogrenci Sayisi","Not Ortalamasi");
            unvList.
                    stream().
                    filter(t-> t.getOgrSayisi()>110).
                    forEach(Lambda04Printf::yazdir);
        }

        //task 03-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.
        public static void bolumMatKontrol(List<Universite> unvList){
            System.out.println("Task 3 : Matematik bolumu olan universiteler");
            System.out.printf("%-10s %20s %20s %20s\n","Universite","Bolum","Ogrenci Sayisi","Not Ortalamasi");
            unvList.
                    stream().
                    filter(t-> t.getBolum().equalsIgnoreCase("Matematik")).
                    forEach(Lambda04Printf::yazdir);
        }

        //task 04-->universite'leri ogr sayilarina gore b->k siralayiniz.
        public static void ogrSayisinaGoreSirala(List<Universite> unvList){
            System.out.println("Task 4 : Ogrenci sayisina gore universiteler : buyukten kucuge");
            System.out.printf("%-10s %20s %20s %20s\n","Universite","Bolum","Ogrenci Sayisi","Not Ortalamasi");
            unvList.
                    stream().
                    sorted(Comparator.comparingInt(Universite::getOgrSayisi).reversed()).
                    forEach(Lambda04Printf::yazdir);

        }

        //task 05-->universite'leri notOrt gore  b->k siralayip ilk 3 'unu print ediniz.
        public static void notOrtalamasinaGoreSirala(List<Universite> unvList){
            System.out.println("Task 5 : Not ortalamasina gore ilk 3 universiteler : buyukten kucuge");
            System.out.printf("%-10s %20s %20s %20s\n","Universite","Bolum","Ogrenci Sayisi","Not Ortalamasi");
            unvList.
                    stream().
                    sorted(Comparator.comparingInt(Universite::getNotOrt)).
                    skip(2).sorted(Comparator.comparingInt(Universite::getNotOrt).reversed()).
                    forEach(Lambda04Printf::yazdir);

        }

        //task 06--> ogrc sayisi en az olan 2. universite'yi  print ediniz.
        public static void ogrSayiAzOlanIkinciUnv(List<Universite> unvList){
            System.out.println("Task 6 : Ogrenci sayisi en az olan 2. universite");
            System.out.println(unvList.
                    stream().
                    sorted(Comparator.comparingInt(Universite::getOgrSayisi)).skip(1).findFirst().get());

        }

        //task 07--> notOrt 63 'den buyuk olan universite'lerin ogrc sayilarini toplamini print ediniz
        public static void notOrt63BykOlnUnvOgrSyToplm(List<Universite> unvList){
            System.out.println("Task 7 : Not ortalamasi 63 'den buyuk olan universitelerin ogrenci sayilari toplami");
            System.out.println(
                    unvList.
                            stream().
                            filter(t->t.getNotOrt()>63).
                            map(Universite::getOgrSayisi).reduce(Integer::sum).get());

        }

        //task 08--> Ogrenci sayisi 130'dan buyuk olan universite'lerin notOrt'larinin ortalamasini bulunuz.
        public static void ogrSay130danFzlaUnvNotOrtToplm(List<Universite> unvList){
            System.out.println("Task 8 : Ogrenci sayisi 130'dan buyuk olan universite'lerin not ortalamalarinin ortalamasi");
            System.out.println(
                    unvList.
                            stream().
                            filter(t->t.getOgrSayisi()>130).
                            mapToInt(Universite::getNotOrt).average().getAsDouble());

        }
        //task 09-->"matematik" bolumlerinin sayisini  print ediniz.
        public static void matBolumSayisi(List<Universite> unvList){
            System.out.println("Task 9 : Matematik bolumu olan universite sayisi");
            System.out.println(
                    unvList.
                            stream().
                            filter(t->t.getBolum().equalsIgnoreCase("Matematik")).
                            count());

        }
        //task 10-->Ogrenci sayilari 130'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz
        public static void ogrSay130NotOrtBykOlan(List<Universite> unvList){
            System.out.println("Task 10 : Ogrenci sayisi 130'dan fazla olan universitelerin en buyuk not ortalamasi");
            System.out.println(
                    unvList.
                            stream().
                            filter(t->t.getOgrSayisi()>130).
                            max(Comparator.comparingInt(Universite::getNotOrt)).get());

        }
        //task 11-->Ogrenci sayilari 150'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.
        public static void ogrSay150azNotOrtKckOlan(List<Universite> unvList){
            System.out.println("Task 11 Ogrenci sayisi 150'den az olan universitelerin en kucuk not ortalamasi");
            System.out.println(
                    unvList.
                            stream().
                            filter(t->t.getOgrSayisi()<150).
                            min(Comparator.comparingInt(Universite::getNotOrt)).get());

        }
}
