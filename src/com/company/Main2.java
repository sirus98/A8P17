package com.company;

import com.company.manager.ManagerCorredors;
import com.company.manager.ManagerCorredors2;
import com.company.manager.ManagerEquips;
import com.company.manager.ManagerEquips2;
import com.company.model.Corredor;
import com.company.model.Equip;
import com.company.view.PantallaMenuPrincipal;

public class Main2 {

    public static void main(String[] args) {
//        Equip equip = new Equip("EquipoX");
//        ManagerCorredors2.inscriureCorredor("Carlos", equip);
//        ManagerCorredors2.inscriureCorredor("Cdasdas", equip);

//        Corredor corredor=  ManagerCorredors2.obtenirCorredor(2008);
//        System.out.println(corredor.id + " "+ corredor.nom+ " "+corredor.idEquip);

//        boolean corredor =  ManagerCorredors2.existeixCorredor("Carlos");
//        System.out.println(corredor);


//        int corredor =  ManagerCorredors2.obtenirNumeroCorredorsPerNom("Carlos");
//        System.out.println(corredor);
        Equip equip = new Equip("pedro");
        //ManagerCorredors2.modificarNomCorredor(1001,"Pedro");
        ManagerCorredors2.modificarEquipCorredor(1001, equip);

//        ManagerCorredors2.obtenirLlistaCorredors();

//        ManagerEquips2.inscriureEquip("Pedro");

    }
}
