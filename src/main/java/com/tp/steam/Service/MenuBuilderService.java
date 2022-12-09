package com.tp.steam.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tp.steam.Business.MenuBuilderBusiness;
import com.tp.steam.Business.MenuBuilderBusinessInter;
import com.tp.steam.bean.Jeu;

/**
 * MenuBuilderService est la classe qui gère la partie service du menu
 * Cette classe est caractérisée par les informations suivantes :
   
 * Description des principales fonctionnalités de la classe
 * Cette classe permet de définir la signature du service et contrôle l'ensemble des paramètres en entrée du menu et jeu
 * Description complémentaire, sur les attributs statiques par exemple
 * 
 * @author 4 cent 4
 * @version 1.0.0
 */
@RestController
public class MenuBuilderService {
	
	/** 
     * Injection de dépendances 
     */
	@Autowired
	MenuBuilderBusinessInter business;
	
	/** 
     * <b>Fonction buildMenu</b> 
     * 
     * @param typeMenu 
     *     Un string passé en paramètre par l'utilisateur en fonction de son besoin du menu 
     * @return Une liste Map<String, List<String>> 
     */  
	@RequestMapping(value= "/MenuBuilder/{typeMenu}")
	public Map<String, List<String>> buildMenu(@PathVariable("typeMenu") String typeMenu) throws FileNotFoundException, IOException
	{
		return business.buildMenu(typeMenu);
		
	}
	
	/** 
     * <b>Fonction rechercherJeux</b> 
     * 
     * @param criteria 
     *     Un string passé en paramètre par l'utilisateur en fonction de son besoin du jeu 
     * @return Une liste List<Jeu> 
     */ 
	@RequestMapping(value= "/rechercherJeux/{crtieria}")
	public List<Jeu> rechercherJeux(@PathVariable("crtieria") final String criteria)
	{
		return business.rechercherJeux(criteria);
		
	}

}
