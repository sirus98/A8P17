package com.company.manager;

import com.company.model.Corredor;
import com.company.model.Equip;

import java.io.*;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;

import static java.lang.Integer.parseInt;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class ManagerCorredors2 {
    static Corredor[] corredors = new Corredor[100];


    //V
    public static Corredor inscriureCorredor(String nom, Equip equip){
        if(equip == null){
            return null;
        }

        try {
            FileWriter kk = new FileWriter("corredores.txt",true);
            kk.write(nom);
            kk.write(":");
            kk.write(String.valueOf(equip.id));
            kk.write(":");
            kk.write(String.valueOf(1000+1 +"\n"));

            kk.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("No se pudo abrir el fichero");
        }
        return null;
    }
    //V
    public static Corredor obtenirCorredor(int id){
        try {
             BufferedReader fileReader = new BufferedReader( new FileReader("corredores.txt"));
             String linea;
             while((linea = fileReader.readLine()) != null){
                 String[] partes = linea.split(":");
                 if (id == parseInt(partes[1])){
                     Corredor corredor = new Corredor(partes[0], parseInt(partes[2]));
                     corredor.id = id;
                     return corredor;

                 }
             }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

//    public static Corredor[] obtenirLlistaCorredors(){
//        Corredor[] llistaCorredors = new Corredor[obtenirNumeroCorredors()];
//
//        try {
//            BufferedReader fileReader = new BufferedReader( new FileReader("corredores.txt"));
//            String linea;
//            while((linea = fileReader.readLine()) != null){
//                String[] partes = linea.split(":");
//                    Corredor corredor = new Corredor(partes[0], Integer.parseInt(partes[2]));
//
//                    return corredor;
//
//
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//        return null;
//    }

    public static Corredor[] buscarCorredorsPerNom(String nom){
        Corredor[] llistaCorredors = new Corredor[obtenirNumeroCorredorsPerNom(nom)];

        int j = 0;
        for (int i = 0; i < corredors.length; i++) {
            if(corredors[i] != null && corredors[i].nom.toLowerCase().contains(nom.toLowerCase())){
                llistaCorredors[j] = corredors[i];
                j++;
            }
        }

        return llistaCorredors;
    }

    //V
    public static boolean existeixCorredor(String nom){
        try {
            BufferedReader fileReader = new BufferedReader( new FileReader("corredores.txt"));
            String linea;
            while((linea = fileReader.readLine()) != null){
                String[] partes = linea.split(":");
                if (nom.equals(partes[0])){

                    return true;

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return false;
    }

    public static void modificarNomCorredor(int id, String nouNom){
        try {
            BufferedReader fileReader = new BufferedReader( new FileReader("corredores.txt"));
            FileWriter fileWriter = new FileWriter("corredores2.txt",true);

            String linea;
            while((linea = fileReader.readLine()) != null){
                String[] partes = linea.split(":");
                if(Integer.parseInt(partes[2]) == id){
                    fileWriter.write(nouNom);
                    fileWriter.write(":");
                    fileWriter.write(partes[1]);
                    fileWriter.write(":");
                    fileWriter.write(String.valueOf(id));
                    fileWriter.write("\n");
                }
                else {
                    fileWriter.write(linea);
                }
            }
            fileWriter.close();
            fileReader.close();
            Files.move(FileSystems.getDefault().getPath("corredores2.txt"),FileSystems.getDefault().getPath("corredores.txt"), REPLACE_EXISTING);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void modificarEquipCorredor(int id, Equip nouEquip){
        try {
            BufferedReader fileReader = new BufferedReader( new FileReader("corredores.txt"));
            FileWriter fileWriter = new FileWriter("corredores2.txt",true);

            String linea;
            while((linea = fileReader.readLine()) != null){
                String[] partes = linea.split(":");
                if(Integer.parseInt(partes[2]) == id){
                    fileWriter.write(partes[0]);
                    fileWriter.write(":");
                    fileWriter.write(String.valueOf(nouEquip.id));
                    fileWriter.write(":");
                    fileWriter.write(String.valueOf(id));
                    fileWriter.write("\n");
                }
                else {
                    fileWriter.write(linea);
                }
            }
            fileWriter.close();
            fileReader.close();
            Files.move(FileSystems.getDefault().getPath("corredores2.txt"),FileSystems.getDefault().getPath("corredores.txt"), REPLACE_EXISTING);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void esborrarCorredor(int id){
        for (int i = 0; i < corredors.length; i++) {
            if(corredors[i] != null && corredors[i].id == id){
                corredors[i] = null;
            }
        }
    }

    private static int obtenirUltimIdCorredor(){
        int maxId = 0;
        for (int i = 0; i < corredors.length; i++) {
            if(corredors[i] != null && corredors[i].id > maxId){
                maxId = corredors[i].id;
            }
        }

        return maxId;
    }
    //V
    public static int obtenirNumeroCorredors(){
        int cuenta=0;
        try {
            BufferedReader fileReader = new BufferedReader( new FileReader("corredores.txt"));
            String linea;
            while((linea = fileReader.readLine()) != null){
                String[] partes = linea.split(":");
                cuenta++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return cuenta;
    }
    //V
    public static int obtenirNumeroCorredorsPerNom(String nom){
        int cuenta=0;
        try {
            BufferedReader fileReader = new BufferedReader( new FileReader("corredores.txt"));
            String linea;
            while((linea = fileReader.readLine()) != null){
                String[] partes = linea.split(":");
                if (nom.equals(partes[0])) {
                    cuenta++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return cuenta;
    }
}
