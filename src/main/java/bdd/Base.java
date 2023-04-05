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
	// CREATE DATABASE manag_agile
	protected String url = "jdbc:mysql://localhost:3306/manag_agile";
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
			
			String temp = "CREATE TABLE PRODUIT (nom varchar(200) NOT NULL,"
												+ "prix varchar(200),"
												+ "type varchar(200),"
												+ "contenance varchar(200),"
												+ "marque varchar(200),"
												+ "couleur varchar(8000),"
												+ "support varchar(200));";
			statement.executeUpdate(temp);
			temp = "CREATE TABLE USERS (nom varchar(200) NOT NULL,"
										+ "mdp varchar(200),"
										+ "type varchar(200),"
										+ "naissance varchar(200));";
			
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
	
	public void addProduit(String nom, String prix, String type, String contenance,String marque, String couleur, String support)
	{
		loaddatabase();
		try 
		{
			statement = connexion.createStatement();
			
			String temp = "INSERT INTO PRODUIT(nom, prix, type, contenance, marque, couleur, support) VALUES(?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement preparedStatement = connexion.prepareStatement(temp);
			preparedStatement.setString(1, nom);
			preparedStatement.setString(2, prix);
			preparedStatement.setString(3, type);
			preparedStatement.setString(4, contenance);
			preparedStatement.setString(5, marque);
			preparedStatement.setString(6, couleur);
			preparedStatement.setString(7, support);
			
			preparedStatement.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void delProduit(String nom)
	{
		loaddatabase();
		try 
		{
			statement = connexion.createStatement();
			
			String temp = "DELETE FROM PRODUIT WHERE nom = ?;";
			PreparedStatement preparedStatement = connexion.prepareStatement(temp);
			preparedStatement.setString(1, nom);
			
	        preparedStatement.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public List<String> recupererProduits()
	{
		List<String> retour = new ArrayList<String>();
		loaddatabase();
		
		try
		{
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT nom FROM PRODUIT;");
			while (resultat.next())
			{
				String produit = resultat.getString("nom");
				retour.add(produit);
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

	public List<String> infoProduit(String nom)
	{
		List<String> retour = new ArrayList<String>();
		loaddatabase();

		try
		{			
			String temp = "SELECT * FROM PRODUIT WHERE nom = ?;";
			PreparedStatement preparedStatement = connexion.prepareStatement(temp);
			preparedStatement.setString(1, nom);
			
	        resultat = preparedStatement.executeQuery();
			
	        while (resultat.next()) {
				String prix = resultat.getString("prix");
				retour.add(prix);
				
				String type = resultat.getString("type");
				retour.add(type);
				
				String contenance =  resultat.getString("contenance");
				retour.add(contenance);
				
				String marque =  resultat.getString("marque");
				retour.add(marque);
				
				String couleur =  resultat.getString("couleur");
				retour.add(couleur);
				
				String support =  resultat.getString("support");
				retour.add(support);
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

	public void addUser(String nom, String mdp, String type, String naissance)
	{	
		
		loaddatabase();
		try 
		{
			statement = connexion.createStatement();
			
			String temp = "INSERT INTO USERS(nom, mdp, type, naissance) VALUES(?,?,?,?);";			
			
			PreparedStatement preparedStatement = connexion.prepareStatement(temp);
			preparedStatement.setString(1, nom);
			preparedStatement.setString(2, mdp);
			preparedStatement.setString(3, type);
			preparedStatement.setString(4, naissance);
			
			preparedStatement.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public void delUser(String nom)
	{
		loaddatabase();
		try 
		{
			statement = connexion.createStatement();
			
			String temp = "DELETE FROM USERS WHERE nom = ?;";
			PreparedStatement preparedStatement = connexion.prepareStatement(temp);
			preparedStatement.setString(1, nom);
			
	        preparedStatement.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public List<String> recupererUsers()
	{
		List<String> retour = new ArrayList<String>();
		loaddatabase();
		
		try
		{
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT nom FROM USERS;");
			while (resultat.next())
			{
				String nom = resultat.getString("nom");
				retour.add(nom);
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
	
	public List<String> infoUsers(String nom)
	{
		List<String> retour = new ArrayList<String>();
		loaddatabase();

		try
		{			
			String temp = "SELECT * FROM USERS WHERE nom = ?;";
			PreparedStatement preparedStatement = connexion.prepareStatement(temp);
			preparedStatement.setString(1, nom);
			
	        resultat = preparedStatement.executeQuery();
			
	        while (resultat.next()) {
				String mdp = resultat.getString("mdp");
				retour.add(mdp);
				
				String type = resultat.getString("type");
				retour.add(type);
				
				String naissance =  resultat.getString("naissance");
				retour.add(naissance);
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
			String temp = "SELECT * FROM PRODUIT;";
			PreparedStatement preparedStatement = connexion.prepareStatement(temp);
			
	        resultat = preparedStatement.executeQuery();
			
	        while (resultat.next()) {
	        	
	        	compare_temp.clear();
	        	
				String nom = resultat.getString("nom");
				compare_temp.add(nom);
				
				for (String s : compare_temp) {
					if (retour.contains(nom) == false)
					{
						retour.add(soundex.difference(s, valeur) + "=" + nom + "=" + "nom_produit");
					}
	        	}
	        }
	        
	        /*
	        
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
	        
	        */
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
