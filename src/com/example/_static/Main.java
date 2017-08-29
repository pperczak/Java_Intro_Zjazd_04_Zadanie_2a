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

        //int wiersz = 2, kolumna = 5;
        int wynik = 0;

        int [][] ruchy_skoczek = {
                {-2,  1},
                {-1,  2},
                { 1,  2},
                { 2,  1},
                { 2, -1},
                { 1, -2},
                {-1, -2},
                {-2, -1}
        };

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
        System.out.println("Dostępne pola dla skoczka przy umieszczeniu na "+ kolumna + " "+wiersz);
        dostepne_pola(ruchy_skoczek,wiersz,kolumna,rozmiar);

        System.out.println("Dostępne pola dla króla przy umieszczeniu na "+ kolumna + " "+wiersz);
        dostepne_pola(ruchy_krol,wiersz,kolumna,rozmiar);

        System.out.println("Dostępne pola dla wieży przy umieszczeniu na "+ kolumna + " "+wiersz);
        wieza(wiersz, kolumna, rozmiar);

        System.out.println("Dostępne pola dla gońca przy umieszczeniu na "+ kolumna + " "+wiersz);
        goniec(wiersz, kolumna, rozmiar);


    }

    public static void dostepne_pola(int[][] ruchy, int wiersz, int kolumna, int rozmiar) {
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

        while ((wiersz - i)>= 0 && (kolumna - i) >= 0 ) {
            int w = wiersz - i;
            int k = kolumna - i;
            System.out.println("Dostepne pola, w: "+w+ " k:"+k);
            i++;
        }
        i=1;

        while ((wiersz + i)< rozmiar && (kolumna + i) < rozmiar ) {
            int w = wiersz + i;
            int k = kolumna + i;
            System.out.println("Dostepne pola, w: "+w+ " k:"+k);
            i++;
        }
        i=1;

        while ((wiersz - i)>= 0 && (kolumna + i) < rozmiar ) {
            int w = wiersz - i;
            int k = kolumna + i;
            System.out.println("Dostepne pola, w: "+w+ " k:"+k);
            i++;
        }
        i=1;

        while ((wiersz + i) < rozmiar && (kolumna - i) >= 0 ) {
            int w = wiersz + i;
            int k = kolumna - i;
            System.out.println("Dostepne pola, w: "+w+ " k:"+k);
            i++;
        }


    }

    public static void hetman(int wiersz, int kolumna, int rozmiar) {
        //najpierw te same pola co dla wiezy
        wieza(wiersz,kolumna,rozmiar);
        //i jeszcze skosy

    }


    public static boolean sprawdz(int x, int rozmiar) {
        return x >= 0 && x < rozmiar;
    }
}
