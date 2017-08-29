package com.example._static;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj rozmiar szachownicy: ");
        int rozmiar = scanner.nextInt();
        if (rozmiar <2) {
            System.out.println("Podano zly rozmiar tablicy");
            return;
        }
        //System.out.print("Podaj typ figury: ");
        //int typFigury = scanner.nextInt();

        System.out.print("Podaj wspolrzedne X: ");
        int kolumna = scanner.nextInt();
        if (kolumna <1 || kolumna > rozmiar) {
            System.out.println("Niepoprawna wspolrzedna X!");
            return;
        }

        System.out.print("Podaj wspolrzedne Y: ");
        int wiersz = scanner.nextInt();
        if (wiersz <1 || wiersz > rozmiar) {
            System.out.println("Niepoprawna wspolrzedna Y!");
            return;
        }

        int [][] ruchy_krol = {
                {-1, -1},
                {-1, 0},
                {-1, 1},
                {0, -1},
                {0,  1},
                {1, -1},
                {1,  0},
                {1,  1}
        };

        System.out.println("Dostępne pola dla króla przy umieszczeniu na kolumnie "+ kolumna + " i wierszu "+wiersz);
        krol(ruchy_krol,wiersz,kolumna,rozmiar);

        System.out.println("Dostępne pola dla wieży przy umieszczeniu na kolumnie "+ kolumna + " i wierszu "+wiersz);
        wieza(wiersz, kolumna, rozmiar);

        System.out.println("Dostępne pola dla gońca przy umieszczeniu na kolumnie "+ kolumna + " i wierszu "+wiersz);
        goniec(wiersz, kolumna, rozmiar);

        System.out.println("Dostępne pola dla hetmana przy umieszczeniu na kolumnie "+ kolumna + " i wierszu "+wiersz);
        hetman(wiersz, kolumna, rozmiar);
    }

    public static void krol(int[][] ruchy, int wiersz, int kolumna, int rozmiar) {
        for (int ruch = 0; ruch < ruchy.length; ++ruch) {
            int w = wiersz + ruchy[ruch][0];
            int k = kolumna + ruchy[ruch][1];
            if (sprawdz(w, rozmiar) && sprawdz(k, rozmiar)) {
                System.out.println("w: "+w+ " k: "+k );
            }
        }
    }

    public static void wieza(int wiersz, int kolumna, int rozmiar) {
        for (int i = 0; i < rozmiar; ++i) {
            if (i != wiersz) {
                System.out.println("w: "+i+" k: "+kolumna);
            }
        }
        for (int i = 0; i < rozmiar; ++i) {
            if (i!= kolumna) {
                System.out.println("w: "+wiersz+" k: "+i);
            }
        }
    }

    public static void goniec (int wiersz, int kolumna, int rozmiar) {
        int i = 1;
        //skos lewo dół
        while ((wiersz - i)>= 0 && (kolumna - i) >= 0 ) {
            int w = wiersz - i;
            int k = kolumna - i;
            System.out.println("w: "+w+ " k:"+k);
            i++;
        }
        i=1;
        //skos prawo góra
        while ((wiersz + i)< rozmiar && (kolumna + i) < rozmiar ) {
            int w = wiersz + i;
            int k = kolumna + i;
            System.out.println("w: "+w+ " k:"+k);
            i++;
        }
        i=1;
        //skos prawo dół
        while ((wiersz - i)>= 0 && (kolumna + i) < rozmiar ) {
            int w = wiersz - i;
            int k = kolumna + i;
            System.out.println("w: "+w+ " k:"+k);
            i++;
        }
        i=1;
        //skos lewo góra
        while ((wiersz + i) < rozmiar && (kolumna - i) >= 0 ) {
            int w = wiersz + i;
            int k = kolumna - i;
            System.out.println("w: "+w+ " k:"+k);
            i++;
        }
    }

    public static void hetman(int wiersz, int kolumna, int rozmiar) {
        //najpierw te same pola co dla wiezy
        wieza(wiersz,kolumna,rozmiar);
        //i jeszcze skosy czyli goniec
        goniec(wiersz,kolumna,rozmiar);
    }

    public static boolean sprawdz(int x, int rozmiar) {
        return x >= 0 && x < rozmiar;
    }
}
