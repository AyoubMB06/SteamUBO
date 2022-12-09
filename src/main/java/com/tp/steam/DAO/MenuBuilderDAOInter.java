package com.tp.steam.DAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.Properties;

public interface MenuBuilderDAOInter {
	public Properties chargerFichierProprieties(final String cheminFichier) throws FileNotFoundException, IOException; 

}
