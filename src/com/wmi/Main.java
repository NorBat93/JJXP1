package com.wmi;
import java.io.IOException;
import java.util.Scanner;
import com.wmi.ListaMieszkancow;


public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Projekt 1 - JJX");

        PobierzDane dane = new PobierzDane("test");
        dane.pobierz();
        dane.pobierz();
        dane.pobierz();
        dane.pobierz();

    }
}
