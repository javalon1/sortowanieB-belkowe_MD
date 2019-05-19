package com.sda.algorytmy;


import java.util.Arrays;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        Random random = new Random();
/*      int max = 100;
        int min = -1;
        while (true) {
            int randomNumber = random.nextInt(max - min + 1) + min;
            System.out.println(randomNumber);
            if (randomNumber == min) {
                break;
            }
        }*/


        int[] tablica = new int[20];
        long startTime = System.currentTimeMillis();
        //Thread.sleep(1000);
        for (int i = 0; i < tablica.length; i++) {
            tablica[i] = random.nextInt(10000 + 1) - 5000;
        }
        System.out.println(Arrays.toString(tablica));
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Czas: " + totalTime);
        startTime = System.currentTimeMillis();
        sort(tablica);
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        System.out.println("Czas sortowania jednej petli: " + totalTime);

        //Sortowanie wersja pelna
        int loopCounter = 0;
        startTime = System.currentTimeMillis();
        for(int i = 0; i < tablica.length - 1; i++){
            int temp = 0;
            for (int j = 0; j < tablica.length - 1; j++){
                temp = tablica[i + 1];
                tablica[i + 1] = tablica[i];
                tablica[i] = temp;
                loopCounter++;
            }

        }
        System.out.println(Arrays.toString(tablica));
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        System.out.println("Czas sortowania: " + totalTime);
        System.out.println("Petle: " + loopCounter);



        //Sortowanie optymalizacja
        loopCounter = 0;
        startTime = System.currentTimeMillis();
        for(int i = 0; i < tablica.length - 1; i++){
            int temp = 0;
            for (int j = 0; j < tablica.length - i - 1; j++){ //Zmniejszanie zakresu iteracji o 1 po kazdym przebiegu petli
                if (tablica[i] > tablica[i + 1]) {
                    temp = tablica[i + 1];
                    tablica[i + 1] = tablica[i];
                    tablica[i] = temp;

                }
                loopCounter++;
            }

        }
        System.out.println(Arrays.toString(tablica));
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        System.out.println("Czas sortowania: " + totalTime);
        System.out.println("Petle: " + loopCounter);


        //Sortowanie nastepna optymalizacja
        loopCounter = 0;
        startTime = System.currentTimeMillis();

        for(int i = 0; i < tablica.length - 1; i++){
            boolean straznik = false;
            int temp = 0;
            for (int j = 0; j < tablica.length - i - 1; j++){ //Zmniejszanie zakresu iteracji o 1 po kazdym przebiegu petli
                if (tablica[i] > tablica[i + 1]) {
                    temp = tablica[i + 1];
                    tablica[i + 1] = tablica[i];
                    tablica[i] = temp;
                    straznik = true;
                }
                loopCounter++;
            }
            if(!straznik){ // ten zapis z ! robi roznice
                break;
            }

        }
        System.out.println(Arrays.toString(tablica));
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        System.out.println("Czas sortowania: " + totalTime);
        System.out.println("Petle: " + loopCounter);












    }

    public static int[] sort(int[] tab) {
        int temp = 0;
        for (int i = 0; i < tab.length - 1; i++) {
            if (tab[i] > tab[i + 1]) {
                temp = tab[i + 1];
                tab[i + 1] = tab[i];
                tab[i] = temp;
            }
        }
        System.out.println(Arrays.toString(tab));
        return tab;
    }
}
