package com.tp.steam.DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * MenuBuilderDAO est la classe qui gère la partie base de données (accès aux fichiers dans notre cas)
 * Cette classe est caractérisée par les informations suivantes :
   
 * Description des principales fonctionnalités de la classe
 * Cette classe permet de charger un fichier et le mettre en proprietes
 * Description complémentaire, sur les attributs statiques par exemple
 * 
 * @author 4 cent 4
 * @version 1.0.0
 */
public class MenuBuilderDAO implements MenuBuilderDAOInter {
	
	ClassLoader classLoader = getClass().getClassLoader();

	/** 
     * <b>Fonction chargerFichierProprieties</b> 
     * 
     * @return props de type Properties
     * @throws FileNotFoundException,  IOException
     *     Au cas où non chargement du fichier 
     */
	@Override
	public Properties chargerFichierProprieties(String cheminFichier) throws FileNotFoundException, IOException {
		InputStream inputStream  = MenuBuilderDAO.class.getClassLoader().getResourceAsStream(cheminFichier);
		Properties props = new Properties();
		props.load(inputStream);
		return props;
	}

}
