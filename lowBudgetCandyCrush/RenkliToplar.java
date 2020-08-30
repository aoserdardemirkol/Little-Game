package com.lowBudgetCandyCrush;

import java.util.Scanner;
import java.util.Random;

public class RenkliToplar {
    public static int[][] degerler = new int[8][4];
    public static int puan = 0;

    public static int[][] Hazırla() {
        Random rnd = new Random();
        int[][] matris = new int[8][4];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++)
                matris[i][j] = rnd.nextInt(3) + 1;
        }
        return matris;
    }

    public static int[][] Goster(int[][] degerler) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++)
                System.out.print(degerler[i][j] + "\t");

            System.out.println();
        }
        System.out.println("---------------------");
        return degerler;
    }

    public static int HamleKontrol(String x, String y) {
        int deger = 0;
        for (int i = 0; i < 2; i++) {
            int a = Integer.parseInt(x.substring(i, i + 1));
            int b = Integer.parseInt(y.substring(i, i + 1));

            if (i == 0 && a > 7 || a < 0 || b > 7 || b < 0)
                deger = 0;

            else if (i == 1 && a > 3 || a < 0 || b > 3 || b < 0)
                deger = 0;

            else if (a == b || a == b + 1 || b == a + 1)
                deger = 1;

            else {
                deger = 0;
                break;
            }
        }
        return deger;
    }

    public static void Oyna(int[][] degerler) {
        RenkliToplar abc = new RenkliToplar();

        Random rnd2 = new Random();
        int degertut1 , degertut2, degertut3, degertut4;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {

                if (j == 2) {
                    degertut1 = degerler[i][j - 2];
                    degertut2 = degerler[i][j - 1];
                    degertut3 = degerler[i][j];

                    if (degertut1 == degertut2 && degertut2 == degertut3) {
                        int a = rnd2.nextInt(3) + 1;
                        int a1 = rnd2.nextInt(3) + 1;
                        int a2 = rnd2.nextInt(3) + 1;

                        if (a == degerler[i][2]) {
                            while (a == degerler[i][2] && a1 == degerler[i][0] && a2 == degerler[i][1]) {
                                a = rnd2.nextInt(3) + 1;
                                a1 = rnd2.nextInt(3) + 1;
                                a2 = rnd2.nextInt(3) + 1;

                                if (a == a1 && a1 == a2) {
                                    while (a == degerler[i][2] && a1 == degerler[i][0] && a2 == degerler[i][1]) {
                                        a = rnd2.nextInt(3) + 1;
                                        a1 = rnd2.nextInt(3) + 1;
                                        a2 = rnd2.nextInt(3) + 1;
                                    }
                                }
                            }
                        }
                        degerler[i][2] = a;
                        degerler[i][0] = a1;
                        degerler[i][1] = a2;

                        abc.puan += 5;
                        Goster(degerler);

                    }
                } else if (j == 3) {
                    degertut4 = degerler[i][j];
                    degertut3 = degerler[i][j - 1];
                    degertut2 = degerler[i][j - 2];

                    if (degertut2 == degertut3 && degertut3 == degertut4) {
                        int b = rnd2.nextInt(3) + 1;
                        int b1 = rnd2.nextInt(3) + 1;
                        int b2 = rnd2.nextInt(3) + 1;

                        if (b == degerler[i][3]) {
                            while (b == degerler[i][3] && b1 == degerler[i][1] && b2 == degerler[i][2]) {
                                b = rnd2.nextInt(3) + 1;
                                b1 = rnd2.nextInt(3) + 1;
                                b2 = rnd2.nextInt(3) + 1;

                                if (b == b1 && b1 == b2) {
                                    while (b == degerler[i][3] && b1 == degerler[i][1] && b2 == degerler[i][2]) {
                                        b = rnd2.nextInt(3) + 1;
                                        b1 = rnd2.nextInt(3) + 1;
                                        b2 = rnd2.nextInt(3) + 1;
                                    }
                                }
                            }
                        }
                        degerler[i][3] = b;
                        degerler[i][1] = b1;
                        degerler[i][2] = b2;

                        abc.puan += 5;
                        Goster(degerler);
                    }

                }
            }
        }
    }


    public static int[][] yerdegis(int[][] degerler, String a, String b) {
        int degertut = 0, degertut2 = 0;
        int[][] konum = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int sayı1 = Integer.parseInt(a.substring(i, i + 1));
                int sayı2 = Integer.parseInt(b.substring(i, i + 1));
                if (j == 0)
                    konum[i][j] = sayı1;
                else
                    konum[i][j] = sayı2;
            }
        }
        degertut = degerler[konum[0][0]][konum[1][0]];
        degertut2 = degerler[konum[0][1]][konum[1][1]];
        degerler[konum[0][1]][konum[1][1]] = degertut;
        degerler[konum[0][0]][konum[1][0]] = degertut2;
        return degerler;
    }

    public static void main(String[] args) {
        RenkliToplar abc = new RenkliToplar();
        int[][] degerler = abc.degerler;
        degerler = Hazırla();
        Goster(degerler);
        Oyna(degerler);

        boolean kontrol = true;
        while (kontrol != false) {
            Scanner klavye = new Scanner(System.in);
            System.out.print("Değer Girin : ");
            String x = klavye.nextLine();
            System.out.print("Değer Girin : ");
            String y = klavye.nextLine();

            if (Integer.parseInt(x) == 100 && Integer.parseInt(y) == 100) {
                System.out.println("Oyun Bitti Puanınız : " + abc.puan);
                kontrol = false;
            }

            for (int i = 0; i < 2; i++) {
                int a = Integer.parseInt(x.substring(i, i + 1));
                int b = Integer.parseInt(y.substring(i, i + 1));
                int deger = HamleKontrol(x, y);

                if (deger == 0)
                    System.out.println("Hatalı Hamle");
                else if (deger == 1) {
                    yerdegis(degerler, x, y);
                    Oyna(degerler);
                }
            }
        }
    }
}