package com.tp.steam.Business;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.tp.steam.bean.Jeu;

public interface MenuBuilderBusinessInter {
	
	public Map<String, List<String>> buildMenu(final String typeMenu) throws FileNotFoundException, IOException;
	public List<Jeu> rechercherJeux(final String criteria);

}
