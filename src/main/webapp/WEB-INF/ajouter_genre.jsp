<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> Ajouter genre </title>
	</head>
		
	<%@include file = "menu.jsp"%>
	
	<div class="topnav">
		<a href="accueil">Accueil</a>
		<a href="artistes">Artistes</a>
		<a href="musiques">Musiques</a>
		<a href="genres">Genres</a>
		
		<form autocomplete="off" action="rechercher">
		 	<button type="submit"> <i class="fa fa-search"> </i></button>
			<input type="text" name="search" maxlength="30" placeholder="Rechercher...">					
		</form>
		
		<a href="ajouter_artiste" style="float:right;"> <i class="fa fa-plus" style="font-size: 26px;"></i> </a>
	</div>
	
	<body>
		
		<div class="center">
		
			<form method="post" action="ajouter_genre">
				<table>
					<tr>
						<td style="font-size: 28px;">
							<p> Ajouter un genre </p>
						</td>
					</tr>
					<tr>
						<td> Nom * : </td>
						<td> <input type="text" name="nom" style="width:100%"> </td>
					</tr>
					<tr style="font-size: 15px; line-height: 10px;">
						<td> * : champ obligatoire </td>
					</tr>
					<tr>
						<td style="font-size: 22px;">
							<p> Informations </p>
						</td>
					</tr>
					
				</table>
				<table>
					<textarea name="informations" maxlength="7990"></textarea>
				</table>
				
				<table>
					<input type="submit" value="Enregistrer">				
					<a href="genres"> <button type="button"> Annuler </button></a>
				</table>
			</form>
		</div>		
	</body>
</html>