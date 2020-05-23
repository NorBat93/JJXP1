package com.wmi;

import java.io.*;

public class NadpisanieDanych {

    private String plik;
    private File wejsciowyPlik ;
    private File temp;

    public NadpisanieDanych( String plik){
        this.plik = plik;
        this.wejsciowyPlik = new File(plik);
        this.temp = new File(plik + ".tmp");
    }

    public void nadpisac(String pesel) throws IOException {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(this.temp));
            BufferedReader reader = new BufferedReader(new FileReader(this.plik));
            String line = null;

            while ((line = reader.readLine()) != null) {
                String peselFromFile = line.split(";")[3];
                if (!peselFromFile.equals(pesel)) {
                    pw.println(line);
                    pw.flush();
                }
            }
            pw.close();
            reader.close();
            usunOryginal();
            zmienNazwe();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void usunOryginal(){
        if (!wejsciowyPlik.delete()) {
            System.out.println("ERROR - Błąd usuwania pliku");
            return;
        }
    }
    private void zmienNazwe(){

        if (!temp.renameTo(this.wejsciowyPlik)) {
            System.out.println("ERROR - Błąd zmiany nazwy");
        }
    }
}
