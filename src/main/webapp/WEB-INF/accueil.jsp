<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Accueil</title>
	</head>
		
	<%@include file = "menu.jsp"%>
	
	<div class="topnav">
		<a class="active" href="accueil">Accueil</a>
		<a href="artistes">Artistes</a>
		<a href="musiques">Musiques</a>
		<a href="genres">Genres</a>
		
		<form autocomplete="off" action="rechercher">
		 	<button type="submit"> <i class="fa fa-search"> </i></button>
			<input type="text" name="search" maxlength="30" placeholder="Rechercher...">					
		</form>
	</div>
	
	<body>
		
		
		<div class="center" style="height:800px;">
			<p> Descriptif du projet : </p>
			
			<p> 
				Ce projet a pour but de créer un service web communiquant
				avec une base de données MySQL et fournissant à  travers
				différentes méthodes, des informations générales sur une
				ou plusieurs musiques telles que :
			</p>
				
			<p>
				- Son nom <br>
				- Son artiste <br>
				- Son/ses genres <br>
				- Ses lyrics
			</p>
				
			<p>
				Toutes ces informations seront stockées dans la base de données
				et pourront être récupurées à tout moment
			</p>
		</div>
		
		
	</body>
	
	
	
</html>