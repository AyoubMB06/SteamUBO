package com.tp.steam.bean;

import java.util.Date;
import java.util.List;

/**
 * Jeu est la classe qui gère le bean Jeu
 * Cette classe est caractérisée par les informations suivantes :
   
 * Description des principales fonctionnalités de la classe
 * Cette classe permet de définir le bean Jeu et son constructeur et ses getters et setters
 * Description complémentaire, sur les attributs statiques par exemple
 * 
 * @author 4 cent 4
 * @version 1.0.0
 */
public class Jeu {
	private String titre;
	private Double prix;
	private String date;
	private List<String> systeme;
	private String description;
	
	
	
	public Jeu(String titre, Double prix, String date, List<String> systeme, String description) {
		super();
		this.titre = titre;
		this.prix = prix;
		this.date = date;
		this.systeme = systeme;
		this.description = description;
	}

	public String getTitre() {
		return titre;
	}
	
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	public Double getPrix() {
		return prix;
	}
	
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public List<String> getSysteme() {
		return systeme;
	}
	
	public void setSysteme(List<String> systeme) {
		this.systeme = systeme;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Jeu [titre=" + titre + ", prix=" + prix + ", date=" + date + ", systeme=" + systeme + ", description="
				+ description + "]";
	}
	
	

}
