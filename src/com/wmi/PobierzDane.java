package com.wmi;

import java.io.IOException;
import java.util.Scanner;

public class PobierzDane {
    private ListaMieszkancow listaMieszkancow;
    private Scanner scanner = new Scanner(System.in);

    public PobierzDane(String plik) throws IOException {
        listaMieszkancow =  ListaMieszkancow.instacja(plik);
    }

    public boolean pobierz() throws IOException{
        System.out.println("Podaj miasto: ");
        String miasto = scanner.nextLine();
        System.out.println("Podaj imie: ");
        String imie = scanner.nextLine();
        System.out.println("Podaj nazwisko: ");
        String nazwisko = scanner.nextLine();
        System.out.println("Podaj PESEL: ");
        String pesel = scanner.nextLine();

        if( !Pesel.sprawdz(pesel) ){
            System.out.println("ERROR - Błędny pesel");
            return false;
        }
        listaMieszkancow.zapiszPlik( miasto, imie, nazwisko, pesel );
        return true;


    }
}
