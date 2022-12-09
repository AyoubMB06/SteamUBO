package com.tp.steam.Service;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tp.steam.Business.ImageRevolverBusiness;
import com.tp.steam.Business.ImageRevolverBusinessInter;

/**
 * ImageRevolverService est la classe qui gère la partie service de l'image
 * Cette classe est caractérisée par les informations suivantes :
   
 * Description des principales fonctionnalités de la classe
 * Cette classe permet de définir la signature du service et contrôle l'ensemble des paramètres en entrée
 * Description complémentaire, sur les attributs statiques par exemple
 * 
 * @author 4 cent 4
 * @version 1.0.0
 */
@RestController
public class ImageRevolverService  {
	
	/** 
     * Injection de dépendances 
     */
	@Autowired
	ImageRevolverBusinessInter buisness;

	/** 
     * <b>Fonction loadImages</b> 
     * 
     * @param TypeRevolver 
     *     Un string passé en paramètre par l'utilisateur en fonction de son besoin de l'image 
     * @return Une liste Map<String,String> 
     */  
	@RequestMapping(value= "/imageRevolver/{typeRevolver}")
	public Map<String, String> loadImages(@PathVariable("typeRevolver") String TypeRevolver) {
		System.out.println(TypeRevolver);
		return buisness.loadImages(TypeRevolver);
	}
	
	
	
	

}
