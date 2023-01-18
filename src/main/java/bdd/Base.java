package bdd;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.language.*;

public class Base
{
	protected Connection connexion;
	protected Statement statement = null;
	protected ResultSet resultat = null;
	protected String id = "root";
	protected String password = "Plume2002!";
	protected String url = "jdbc:mysql://localhost:3306/javaee";
	// Pour avoir le port de MySQL (3306), entrez la commande :
	//							show global variables like 'port'
	
	public void loaddatabase()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e) {}
		
		try 
		{
			connexion = DriverManager.getConnection(url, id, password);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public String createdatabase()
	{
		String retour = "";
		loaddatabase();
		try 
		{
			statement = connexion.createStatement();
			
			String temp = "CREATE TABLE MUSIQUES (nom varchar(200) NOT NULL, album varchar(200),"
												+ "duree varchar(200), sortie varchar(200), "
												+ "artiste varchar(200), genre varchar(200),"
												+ "lyrics varchar(8000));";
			statement.executeUpdate(temp);
			temp = "CREATE TABLE ARTISTES (nom_alternatif varchar(200) NOT NULL,"
										+ "nom_reel varchar(200),"
										+ "type varchar(200), nationalite varchar(200),"
										+ "sexe varchar(200), naissance varchar(200),"
										+ "status varchar(200), debut varchar(200),"
										+ "genres_musicaux varchar(200), biographie varchar(3000));";
			
			statement.executeUpdate(temp);
			temp = "CREATE TABLE GENRES (nom varchar(200) NOT NULL, infos varchar(8000));";
			statement.executeUpdate(temp);
			// varchar peut aller jusqu'a 65535 octets depuis MySQL 5.5
			
			retour = "Base de données créée";
		}
		catch (SQLSyntaxErrorException e)
		{
			retour = "Base de données déjà existante";
		}
		catch (SQLException e) {
			e.printStackTrace();
			retour = "Erreur lors de la création de la base de données";
		}
		

		return retour;
	}
	
	public void addMusique(String nom, String album, String duree, String sortie,String artiste, String genre, String lyrics)
	{
		loaddatabase();
		try 
		{
			statement = connexion.createStatement();
			
			String temp = "INSERT INTO MUSIQUES(nom, album, duree, sortie, artiste, genre, lyrics) VALUES(?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement preparedStatement = connexion.prepareStatement(temp);
			preparedStatement.setString(1, nom);
			preparedStatement.setString(2, album);
			preparedStatement.setString(3, duree);
			preparedStatement.setString(4, sortie);
			preparedStatement.setString(5, artiste);
			preparedStatement.setString(6, genre);
			preparedStatement.setString(7, lyrics);
			
			preparedStatement.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void delMusique(String nom)
	{
		loaddatabase();
		try 
		{
			statement = connexion.createStatement();
			
			String temp = "DELETE FROM musiques WHERE nom = ?;";
			PreparedStatement preparedStatement = connexion.prepareStatement(temp);
			preparedStatement.setString(1, nom);
			
	        preparedStatement.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public List<String> recupererMusiques()
	{
		List<String> retour = new ArrayList<String>();
		loaddatabase();
		
		try
		{
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT nom FROM MUSIQUES;");
			while (resultat.next())
			{
				String musique = resultat.getString("nom");
				retour.add(musique);
			}
			
		}
		catch (SQLException e)
		{
			try
			{
				if (resultat != null) { resultat.close(); }
				if (resultat != null) { statement.close(); }
				if (resultat != null) { connexion.close(); }
			}
			catch (SQLException ignore) {}
		}
		return retour;
	}

	public List<String> infoMusique(String nom)
	{
		List<String> retour = new ArrayList<String>();
		loaddatabase();

		try
		{			
			String temp = "SELECT * FROM musiques WHERE nom = ?;";
			PreparedStatement preparedStatement = connexion.prepareStatement(temp);
			preparedStatement.setString(1, nom);
			
	        resultat = preparedStatement.executeQuery();
			
	        while (resultat.next()) {
				String album = resultat.getString("album");
				retour.add(album);
				
				String duree = resultat.getString("duree");
				retour.add(duree);
				
				String sortie =  resultat.getString("sortie");
				retour.add(sortie);
				
				String artiste =  resultat.getString("artiste");
				retour.add(artiste);
				
				String genre =  resultat.getString("genre");
				retour.add(genre);
				
				String lyrics =  resultat.getString("lyrics");
				retour.add(lyrics);
	        }
		}
		catch (SQLException e)
		{
			try
			{
				if (resultat != null) { resultat.close(); }
				if (resultat != null) { statement.close(); }
				if (resultat != null) { connexion.close(); }
			}
			catch (SQLException ignore) {}
			catch (NullPointerException ignore) {}
		}
		
		return retour;
	}
	
	
	
	public void addArtiste(String nom_alternatif, String nom_reel, String type, String nationalite, String sexe, String naissance, String status, String debut, String genres_musicaux, String biographie)
	{	
		
		loaddatabase();
		try 
		{
			statement = connexion.createStatement();
			
			String temp = "INSERT INTO ARTISTES(nom_alternatif, nom_reel, type, nationalite, sexe, naissance, status, debut, genres_musicaux, biographie) VALUES(?,?,?,?,?,?,?,?,?,?);";			
			
			PreparedStatement preparedStatement = connexion.prepareStatement(temp);
			preparedStatement.setString(1, nom_alternatif);
			preparedStatement.setString(2, nom_reel);
			preparedStatement.setString(3, type);
			preparedStatement.setString(4, nationalite);
			preparedStatement.setString(5, sexe);
			preparedStatement.setString(6, naissance);
			preparedStatement.setString(7, status);
			preparedStatement.setString(8, debut);
			preparedStatement.setString(9, genres_musicaux);
			preparedStatement.setString(10, biographie);
			
			preparedStatement.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public void delArtiste(String nom_alternatif)
	{
		loaddatabase();
		try 
		{
			statement = connexion.createStatement();
			
			String temp = "DELETE FROM artistes WHERE nom_alternatif = ?;";
			PreparedStatement preparedStatement = connexion.prepareStatement(temp);
			preparedStatement.setString(1, nom_alternatif);
			
	        preparedStatement.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public List<String> recupererArtistes()
	{
		List<String> retour = new ArrayList<String>();
		loaddatabase();
		
		try
		{
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT nom_alternatif FROM ARTISTES;");
			while (resultat.next())
			{
				String artiste = resultat.getString("nom_alternatif");
				retour.add(artiste);
			}
			
		}
		catch (SQLException e)
		{
			try
			{
				if (resultat != null) { resultat.close(); }
				if (resultat != null) { statement.close(); }
				if (resultat != null) { connexion.close(); }
			}
			catch (SQLException ignore) {}
		}
		
		return retour;
	}
	
	public List<String> infoArtiste(String nom_alternatif)
	{
		List<String> retour = new ArrayList<String>();
		loaddatabase();

		try
		{			
			String temp = "SELECT * FROM artistes WHERE nom_alternatif = ?;";
			PreparedStatement preparedStatement = connexion.prepareStatement(temp);
			preparedStatement.setString(1, nom_alternatif);
			
	        resultat = preparedStatement.executeQuery();
			
	        while (resultat.next()) {
				String nom_reel = resultat.getString("nom_reel");
				retour.add(nom_reel);
				
				String type = resultat.getString("type");
				retour.add(type);
				
				String nationalite =  resultat.getString("nationalite");
				retour.add(nationalite);
				
				String sexe =  resultat.getString("sexe");
				retour.add(sexe);
				
				String naissance =  resultat.getString("naissance");
				retour.add(naissance);
				
				String status =  resultat.getString("status");
				retour.add(status);
				
				String debut =  resultat.getString("debut");
				retour.add(debut);
				
				String genres_musicaux =  resultat.getString("genres_musicaux");
				retour.add(genres_musicaux);
				
				String biographie =  resultat.getString("biographie");
				retour.add(biographie);
	        }
		}
		catch (SQLException e)
		{
			try
			{
				if (resultat != null) { resultat.close(); }
				if (resultat != null) { statement.close(); }
				if (resultat != null) { connexion.close(); }
			}
			catch (SQLException ignore) {}
			catch (NullPointerException ignore) {}
		}
		
		return retour;
	}
	

	
	public void addGenre(String nom, String infos)
	{	
		loaddatabase();
		try 
		{
			statement = connexion.createStatement();
			
			String temp = "INSERT INTO GENRES(nom, infos) VALUES(?, ?);";
			PreparedStatement preparedStatement = connexion.prepareStatement(temp);
			preparedStatement.setString(1, nom);
			preparedStatement.setString(2, infos);
			
			preparedStatement.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void delGenre(String nom)
	{
		loaddatabase();
		try 
		{
			statement = connexion.createStatement();
			
			String temp = "DELETE FROM genres WHERE nom = ?;";
			PreparedStatement preparedStatement = connexion.prepareStatement(temp);
			preparedStatement.setString(1, nom);
			
	        preparedStatement.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public List<String> recupererGenres()
	{
		List<String> retour = new ArrayList<String>();
		loaddatabase();
		
		try
		{
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT nom FROM GENRES;");
			while (resultat.next())
			{
				String artiste = resultat.getString("nom");
				retour.add(artiste);
			}
			
		}
		catch (SQLException e)
		{
			try
			{
				if (resultat != null) { resultat.close(); }
				if (resultat != null) { statement.close(); }
				if (resultat != null) { connexion.close(); }
			}
			catch (SQLException ignore) {}
		}
		
		return retour;
	}
	
	public List<String> infoGenre(String nom)
	{
		List<String> retour = new ArrayList<String>();
		loaddatabase();

		try
		{			
			String temp = "SELECT * FROM genres WHERE nom = ?;";
			PreparedStatement preparedStatement = connexion.prepareStatement(temp);
			preparedStatement.setString(1, nom);
			
	        resultat = preparedStatement.executeQuery();
			
	        while (resultat.next()) {
				String infos = resultat.getString("infos");
				retour.add(infos);
	        }
		}
		catch (SQLException e)
		{
			try
			{
				if (resultat != null) { resultat.close(); }
				if (resultat != null) { statement.close(); }
				if (resultat != null) { connexion.close(); }
			}
			catch (SQLException ignore) {}
			catch (NullPointerException ignore) {}
		}
		
		return retour;
	}
	
	public List<String> rechercher(String valeur) throws EncoderException
	{
		List<String> retour = new ArrayList<String>();
		List<String> compare_temp = new ArrayList<>();
		
		Soundex soundex = new Soundex();
		loaddatabase();

		try
		{	
			String temp = "SELECT * FROM artistes;";
			PreparedStatement preparedStatement = connexion.prepareStatement(temp);
			
	        resultat = preparedStatement.executeQuery();
			
	        while (resultat.next()) {
	        	
	        	compare_temp.clear();
	        	
				String nom_alternatif = resultat.getString("nom_alternatif");
				compare_temp.add(nom_alternatif);
				
				for (String s : compare_temp) {
					if (retour.contains(nom_alternatif) == false)
					{
						retour.add(soundex.difference(s, valeur) + "=" + nom_alternatif + "=" + "artiste");
					}
	        	}
	        }
	        
	        //
	        
	        temp = "SELECT * FROM genres;";
			preparedStatement = connexion.prepareStatement(temp);
			
	        resultat = preparedStatement.executeQuery();
			
	        while (resultat.next()) {
	        	compare_temp.clear();

	        	String nom = resultat.getString("nom");
	        	compare_temp.add(nom);
				
				for (String s : compare_temp) {
					if (!retour.contains(nom))
					{
						retour.add(soundex.difference(s, valeur) + "=" + nom + "=" + "genre");
					}
	        	}
	        }
	        
	        //
	        
	        temp = "SELECT * FROM musiques;";
			preparedStatement = connexion.prepareStatement(temp);
			
	        resultat = preparedStatement.executeQuery();
	        
	        while (resultat.next()) {
	        	compare_temp.clear();

	        	String nom = resultat.getString("nom");
	        	compare_temp.add(nom);
				
				for (String s : compare_temp) {
					if (!retour.contains(nom))
					{
						retour.add(soundex.difference(s, valeur) + "=" + nom + "=" + "musique");
					}
	        	}
	        }
		}
		catch (SQLException e)
		{
			try
			{
				if (resultat != null) { resultat.close(); }
				if (resultat != null) { statement.close(); }
				if (resultat != null) { connexion.close(); }
			}
			catch (SQLException ignore) {}
			catch (NullPointerException ignore) {}
		}
		
		return retour;
	}

}
