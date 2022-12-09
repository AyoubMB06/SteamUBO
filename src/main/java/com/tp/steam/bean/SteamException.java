package com.tp.steam.bean;

/**
 * SteamException est la classe qui gère les exceptions 
 * Cette classe est caractérisée par les informations suivantes :
   
 * Description des principales fonctionnalités de la classe
 * Cette classe permet de préciser une exception et générer son message
 * Description complémentaire, sur les attributs statiques par exemple
 * 
 * @author 4 cent 4
 * @version 1.0.0
 */
public class SteamException extends RuntimeException{
	public SteamException(String message)
	{
		super(message);
	}

}
