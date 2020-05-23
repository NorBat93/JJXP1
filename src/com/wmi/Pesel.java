package com.wmi;

import java.util.*;

public class Pesel {

    public static boolean sprawdz(String pesel){
        boolean poprawny = true;
        int[] peselInt = konwersja(pesel);
        if( !sprawdzDlugosc(peselInt) ){
            poprawny = false;
        }
        if( !sprawdzCK(peselInt) ){
            poprawny = false;
        }
        return poprawny;
    }

    private static int[] konwersja(String pesel){
        int[] peselInt = new int[pesel.length()];
        for(int i = 0; i < pesel.length(); i++){
            peselInt[i] = Character.getNumericValue( pesel.charAt(i) );
        }
        return peselInt;
    }

    private static boolean sprawdzDlugosc(int[] pesel){
        if( pesel.length != 11 ){
            return false;
        } else {
            return true;
        }
    }

    private static boolean sprawdzCK(int[] pesel){
        int CK = pesel[10];
        int suma = 9*pesel[0] + 7*pesel[1] + 3*pesel[2] + 1*pesel[3] + 9*pesel[4] + 7*pesel[5] + 3*pesel[6] + 1*pesel[7] + 9*pesel[8] + 7*pesel[9];
        if( suma % 10 != CK ){
            return false;
        } else {
            return true;
        }
    }

}
