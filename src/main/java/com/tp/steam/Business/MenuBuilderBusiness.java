package com.tp.steam.Business;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;

import com.tp.steam.DAO.JeuxDao;
import com.tp.steam.DAO.MenuBuilderDAO;
import com.tp.steam.DAO.MenuBuilderDAOInter;
import com.tp.steam.bean.Jeu;
import com.tp.steam.bean.SteamException;

/**
 * MenuBuilderBusiness est la classe qui définit le menu à afficher
 * Cette classe est caractérisée par les informations suivantes :
   
 * Description des principales fonctionnalités de la classe
 * Traitement et conversion des menus et implémentation du métier du service
 * Description complémentaire, sur les attributs statiques par exemple
 * 
 * @author 4 cent 4
 * @version 1.0.0
 */
public class MenuBuilderBusiness implements MenuBuilderBusinessInter{
	
	/** 
     * Injection de dépendances 
     */
	@Autowired
	private MenuBuilderDAOInter dao;
	private String menu = "";
	private String subMenu = "";
	private String[] separatedMenu;
	private List<String> separatedSubMenuList;
	private Double prix;


	/** 
     * <b>Fonction buildMenu</b> 
     * 
     * @param typeMenu 
     *     Un string passé en paramètre par l'utilisateur en fonction de son besoin du menu 
     * @return Une liste LinkedHashMap<String,List<String>>
     * @throws SteamException 
     *     Menu introuvable 
     */ 
	@Override
	public Map<String, List<String>> buildMenu(String typeMenu) throws FileNotFoundException, IOException {
		
		 Map<String,List<String>> menuMap = new LinkedHashMap<String,List<String>>();

		try {
		
		if(typeMenu.equals("MAIN"))
		{
			menuMap=ExtractPropreties("menu.main");
			
		}
		else if(typeMenu.equals("TAGS"))
		{
			menuMap=ExtractPropreties("menu.tags");
		}
		else if(typeMenu.equals("GENRE"))
		{
			menuMap=ExtractPropreties("menu.genres");

		}
		else {
			throw new SteamException("Paramètre invalide");
		}
		
		}catch (Exception e) {
			e.printStackTrace();
			throw new SteamException("Menu introuvable"); 
		}
		return menuMap;
		
	}
	
	
	/** 
     * <b>Fonction ExtractPropreties</b> 
     * 
     * @param prop 
     *     Un string passé en paramètre par l'utilisateur pour définir les propriétés 
     * @return Une liste LinkedHashMap<String,List<String>> 
     */ 
	public Map<String, List<String>> ExtractPropreties(String prop) throws FileNotFoundException, IOException
	{
		 Map<String,List<String>> menuMap = new LinkedHashMap<String,List<String>>();
		Properties props= dao.chargerFichierProprieties("menu.properties");

		menu=props.getProperty(prop);
		separatedMenu= menu.split("\\|");
		if (separatedMenu.length > 0) {
			for(int i=0;i< separatedMenu.length;i++)
			{
				separatedSubMenuList=new ArrayList<>(Arrays.asList(separatedMenu[i].split(";")));
				if(separatedSubMenuList.size() > 1)
				{
					subMenu=separatedSubMenuList.get(0);
					separatedSubMenuList.remove(0);
					menuMap.put(subMenu, separatedSubMenuList);
				}
				else 
				{
					menuMap.put(separatedSubMenuList.get(0), new ArrayList<String>());
				}
			}
		}
		
		
		return menuMap;
		
	}
	
	/** 
     * <b>Fonction rechercherJeux</b> 
     * 
     * @param criteria 
     *     Un string passé en paramètre par l'utilisateur en fonction de son besoin du jeu 
     * @return Une liste ArrayList<Jeu>
     */
	public List<Jeu> rechercherJeux(final String criteria)
	{
		List<Jeu> jeuList = JeuxDao.getAllJeu();
		List<Jeu> jeuSearchList = new ArrayList<Jeu>();
		boolean isConvertable=true;
		
		
		try {
		 prix=Double.parseDouble(criteria);
		}catch (NumberFormatException e) {
			isConvertable=false;
		}
		System.out.println(prix);
		
		
		for(Jeu jeu : jeuList)
		{
			System.out.println(jeu.getPrix() == prix);
			
			if(jeu.getTitre().contains(criteria))
				jeuSearchList.add(jeu);
			else if (isConvertable && jeu.getPrix().equals(prix))
				jeuSearchList.add(jeu);
			else if (jeu.getDate().equals(criteria))
				jeuSearchList.add(jeu);
			else if (jeu.getDescription().equals(criteria))
				jeuSearchList.add(jeu);
			
			for( String system :jeu.getSysteme())
			{
				if(system.contains(criteria))
					jeuSearchList.add(jeu);
			}
		}
		return jeuSearchList;
	}
	
	
	
	

}
