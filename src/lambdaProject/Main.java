package lambdaProject;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Main {
    public static List<Ogrenci> ogrenciList = new ArrayList<>();
    public static void main(String[] args) {
        ogrenciListesi();
        notaGoreSirala(12,40);
        System.out.println("*************************");
        yasaGoreSirala();
        System.out.println("*************************");
        yasVeCinsiyeteGoreListele(28, 30, "kadin");
        System.out.println("*************************");
        ismeGoreSirala();
        System.out.println("*************************");
        soyIsmeGoreSirala();
        System.out.println("*************************");
        cinsiyeteGoreYaz();
        System.out.println("*************************");
        System.out.println(ortalamaHesapla());
    }

    private static void cinsiyeteGoreYaz() {
        ogrenciList.stream().sorted(Comparator.comparing(t -> t.getCinsiyet().substring(0, 1))).forEach(System.out::println);
    }

    private static void soyIsmeGoreSirala() {
        ogrenciList.stream().sorted(Comparator.comparing(t -> t.getSoyad().charAt(0))).forEach(System.out::println);
    }

    private static void ismeGoreSirala() {
        ogrenciList.stream().sorted(Comparator.comparing(t -> t.getAd().charAt(0))).forEach(System.out::println);
    }

    private static double ortalamaHesapla() {
        double reduce = ogrenciList.stream().
                mapToDouble(Ogrenci::getDiplomaNotu).
                reduce(0, Double::sum);
        return reduce / ogrenciList.size();
    }

    private static void yasVeCinsiyeteGoreListele(int altYas, int ustYas, String cinsiyet) {
        ogrenciList.stream().
                sorted(Comparator.comparing(Ogrenci::getDiplomaNotu).reversed()).
                skip(altYas-1).
                limit(ustYas-altYas+1).
                filter(t->t.getCinsiyet().equalsIgnoreCase("kadin")).
                map(Ogrenci::toString).
                forEach(System.out::println);
    }

    private static void yasaGoreSirala() {
        ogrenciList.stream().sorted(Comparator.comparing(Ogrenci::getYas)).forEach(System.out::println);
    }

    private static void notaGoreSirala(int enDusukNot,int enYuksekNot) {
        ogrenciList.stream().
                sorted(Comparator.comparing(Ogrenci::getDiplomaNotu).reversed()).
                skip(enDusukNot-1).
                limit(enYuksekNot-enDusukNot+1).
                forEach(System.out::println);

    }

    private static void ogrenciListesi() {
        ogrenciList.add(new Ogrenci("Ahmet","Can",30, 90.5 , "erkek"));
        ogrenciList.add(new Ogrenci("Ahmet","Yarba",25, 90 , "erkek"));
        ogrenciList.add(new Ogrenci("Ayse","Can",21, 82.5, "kadin"));
        ogrenciList.add(new Ogrenci("Merve","Aslan",30, 98, "kadin"));
        ogrenciList.add(new Ogrenci("Veli","Han",80, 35.5 , "erkek"));
        ogrenciList.add(new Ogrenci("Funda","Funda",24, 99.2, "kadin"));
    }

}
