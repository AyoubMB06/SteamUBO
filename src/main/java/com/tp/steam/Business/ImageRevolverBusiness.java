package com.tp.steam.Business;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.security.sasl.SaslException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Base64Utils;

import com.tp.steam.DAO.ImageRevolverDAO;
import com.tp.steam.DAO.ImageRevolverDAOInter;
import com.tp.steam.bean.SteamException;

/**
 * ImageRevolverBusiness est la classe qui définit le retour de chaque cas 
 * Cette classe est caractérisée par les informations suivantes :
   
 * Description des principales fonctionnalités de la classe
 * Traitement et conversion des données et implémentation du métier du service
 * Description complémentaire, sur les attributs statiques par exemple
 * 
 * @author 4 cent 4
 * @version 1.0.0
 */
public class ImageRevolverBusiness implements ImageRevolverBusinessInter {
	
	/** 
     * Injection de dépendances 
     */
	@Autowired
	ImageRevolverDAOInter dao;
	
	/** 
     * <b>Fonction loadImages</b> 
     * 
     * @param TypeRevolver 
     *     Un string passé en paramètre par l'utilisateur en fonction de son besoin de l'image 
     * @return Une liste Map<String,String> 
     * @throws SteamException 
     *     Element non fourni actuellement 
     */ 
	@Override
	public Map<String, String> loadImages(String TypeRevolver) throws SteamException {
		Map<String, byte[]> images=new HashMap<String,byte[]>();
		Map<String,String> images64=new HashMap<String,String>();
		if(TypeRevolver.equals("MAIN")) {
			images=dao.loadImagesMain();
			for (Map.Entry<String,byte[]> entry : images.entrySet())
			{
				images64.put(entry.getKey(), getIMageData(entry.getValue()));
			}

        }else if (TypeRevolver.equals("PROMO")) {
			images=dao.loadImagesPromo();
			for (Map.Entry<String,byte[]> entry : images.entrySet())
			{
				images64.put(entry.getKey(), getIMageData(entry.getValue()));
			}
        	

        }else  if (TypeRevolver.equals("OTHER")){
        	throw new SteamException("Actuellement Non supporter");

        }

		return images64;
	}

	/** 
     * <b>Fonction getIMageData</b> 
     * 
     * @param image 
     *     Une image passé en paramètre par l'utilisateur sous format de bytes 64
     * @return String de base 64 
     */  
	@Override
	public String getIMageData(byte[] image) {
		String base64 = Base64Utils.encodeToString(image);
		base64="data:image/png;base64,"+base64;
		return base64;
	}

	
	

}
