package com.wmi;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;


public class ListaMieszkancow {
    private static ListaMieszkancow instacja;
    private String plik;
    private static String separator = ";";
    private NadpisanieDanych nadpiswywanie;

    ListaMieszkancow(String plik) throws IOException{
        DateTimeFormatter czasFormat = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        LocalDateTime czasTeraz = LocalDateTime.now();
        this.plik = plik+"_"+czasFormat.format(czasTeraz)+".txt";
        this.nadpiswywanie = new NadpisanieDanych(this.plik);
        FileWriter writer = new FileWriter(this.plik, true);
        writer.close();
    }

    public void zapiszPlik(String miasto, String imie, String naziwsko, String pesel) throws IOException{
        this.nadpiswywanie.nadpisac(pesel);
        FileWriter zapis = new FileWriter(this.plik, true);
        zapis.write(miasto + separator + imie + separator + naziwsko + separator + pesel + "\n");
        zapis.close();
    }
    public static ListaMieszkancow instacja(String plik) throws IOException {
        if(instacja == null){
            instacja = new ListaMieszkancow(plik);
        }
        return instacja;
    }



}
