package com.tp.steam.DAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.tp.steam.bean.Jeu;

/**
 * JeuxDao est la classe qui gère la partie base de données des jeux
 * Cette classe est caractérisée par les informations suivantes :
   
 * Description des principales fonctionnalités de la classe
 * Cette classe permet d'instancier un nombre de jeux manuellement
 * Description complémentaire, sur les attributs statiques par exemple
 * 
 * @author 4 cent 4
 * @version 1.0.0
 */
public class JeuxDao{
	private static List<Jeu> jeuList = new ArrayList<Jeu>();
	private static List<String> systemList = new ArrayList<String>();
	
	
    static {
    	systemList.add("Linux");systemList.add("Windows"); systemList.add("MacOS");
    	
    	jeuList.add(new Jeu("Far Cry", 20.0, "2019-08-21",systemList, "Gold Version"));
    	jeuList.add(new Jeu("Battlefield", 40.0, "2020-04-11",systemList, "Premium"));
    	jeuList.add(new Jeu("Fifa", 30.0, "2018-08-21",systemList, "Promotion"));
    	jeuList.add(new Jeu("Valorant", 20.0, "2020-02-05",systemList, "Epic"));
    	jeuList.add(new Jeu("League of Legends", 25.0, "2019-11-21",systemList, "LoL"));
    	jeuList.add(new Jeu("Dota", 12.5, "2014-06-23",systemList, "Old"));

    }

    
    /** 
     * <b>Fonction getAllJeu</b> 
     * 
     * @return Une liste List<Jeu> la liste complète des jeux
     */ 
	public static List<Jeu> getAllJeu() {
		
		return jeuList;
	}
	
	
}
