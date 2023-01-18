<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> Modifier genre </title>
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
	</div>
	
	<body>
		
		<div class="center">					
			
			<form method="get">
				<table>
					<tr>
						<td style="font-size: 28px;">
							<p> Modifier un genre </p>
						</td>
					</tr>
				</table>
			</table>
		
			<table>
				<tr>
					<td style="font-size: 22px;">
						<td>Nom : </td>
						<td> <input type="text" name="nom" value="${ nom }" style="width:100%"> </td>
					</td>
				</tr>
			</table>
				
			<table>
				<tr>
					<td style="font-size: 22px;">
						<p> Informations </p>
					</td>
				</tr>
			</table>
				<table>
					<textarea name="informations" maxlength="7990">${ informations }</textarea>
				</table>
				
				<table>
					<td>
						<input type="submit" value="Enregistrer">				
						<a href="genre?parametre=${ nom }"> <button type="button"> Annuler </button></a>
					</td>
				</table>
			</form>
		</div>		
	</body>
</html>