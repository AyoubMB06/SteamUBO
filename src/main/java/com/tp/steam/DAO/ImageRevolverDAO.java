package com.tp.steam.DAO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

/**
 * ImageRevolverDAO est la classe qui gère la partie base de données (accès aux fichiers dans notre cas)
 * Cette classe est caractérisée par les informations suivantes :
   
 * Description des principales fonctionnalités de la classe
 * Cette classe permet de prendre une image en entrée et la convertir en format 64 bytes
 * Description complémentaire, sur les attributs statiques par exemple
 * 
 * @author 4 cent 4
 * @version 1.0.0
 */
public class ImageRevolverDAO implements ImageRevolverDAOInter {
	
	/** 
     * Définition du routage du dossier Main 
     */
	private static final String mainPath = "img/revolver/main";
	/** 
     * Définition du routage du dossier Promo 
     */
	private static final String promoPath = "img/revolver/promo";
	/** 
     * Définition du routage de l'image whiteImage 
     */
	private static final String whiteImage = "img/WhiteImage.jpg";

	ClassLoader classLoader = getClass().getClassLoader();
	
	/** 
     * <b>Fonction loadImagesMain</b> 
     * 
     * @return Une liste HashMap<String, byte[]> qui permet de stocker le nom d'image et sa conversion en byte 64 du dossier MAIN
     * @throws IOException 
     *     Fichier qui n'est pas convertit en 64bytes 
     */ 
	@Override
	public Map<String, byte[]> loadImagesMain() {
		
		
		Map<String, byte[]> mainImages= new HashMap<String, byte[]>();
		File dir = new File(classLoader.getResource(mainPath).getFile());
		File[] images = dir.listFiles();
		 if (images.length > 0) {
			    for (File image : images) {
			    	 try {
						byte[] bytes = Files.readAllBytes(image.toPath());
						mainImages.put(image.getName(), bytes);
					} catch (IOException e) {
						e.printStackTrace();
					}

			    }
		 }
		 else
		 {
			 File image = new File(classLoader.getResource(whiteImage).getFile());
			 try {
				mainImages.put(image.getName(),Files.readAllBytes(image.toPath()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		 }
		 return mainImages;
	}

	/** 
     * <b>Fonction loadImagesPromo</b> 
     * 
     * @return Une liste HashMap<String, byte[]> qui permet de stocker le nom d'image et sa conversion en byte 64 du dossier PROMO
     * @throws IOException 
     *     Fichier qui n'est pas convertit en 64bytes 
     */
	@Override
	public Map<String, byte[]> loadImagesPromo() {
		
		Map<String, byte[]> promoImages= new HashMap<String, byte[]>();
		
		File dir = new File(classLoader.getResource(promoPath).getFile());
		File[] images = dir.listFiles();
		 if (images.length > 0) {
			    for (File image : images) {
			    	 try {
						byte[] bytes = Files.readAllBytes(image.toPath());
						promoImages.put(image.getName(), bytes);
					} catch (IOException e) {
						e.printStackTrace();
					}
			    }  
		 }
		 else
		 {
			 File image = new File(classLoader.getResource(whiteImage).getFile());
			 try {
				 promoImages.put(image.getName(),Files.readAllBytes(image.toPath()));

			} catch (IOException e) {
				e.printStackTrace();
			}
		 }
		 return promoImages;
	}
	

	
	
	
	

}
