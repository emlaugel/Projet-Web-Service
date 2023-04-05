<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> Modifier artiste </title>
	</head>
		
	<%@include file = "menu.jsp"%>
	
	<div class="topnav">
		<a href="accueil">Accueil</a>
		<a href="produits">Produits</a>
		<a href="musiques">--Musiques</a>
		<a href="genres">--Genres</a>
		
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
						<td style="border-bottom: solid; font-size:25px;">
							<p> Modifier un produit </p>
						</td>
					</tr>
				</table>
				
				<table>
					<tr>
						<td>
							<table>
								<tr>
									<td> Nom * : </td>
									<td> <input type="text" name="nom" value="${ nom }" style="width:100%"> </td>
								</tr>
								
								<tr>
									<td> Prix : </td>
									<td> <input type="text" name="prix" value="${ prix }" style="width:100%"> </td>
								</tr>
								
								<tr>
									<td> Type : </td>
									<td> <input type="text" name="type" value="${ type }" style="width:100%"> </td>
								</tr>
								
								<tr>
									<td> Contenance : </td>
									<td> <input type="text" name="contenance" value="${ contenance }" style="width:100%"> </td>
								</tr>
								
								<tr>
									<td> Marque : </td>
									<td> <input type="text" name="marque" value="${ marque }" style="width:100%"> </td>
								</tr>
								
								<tr>
									<td> Couleur : </td>
									<td> <input type="text" name="couleur" value="${ couleur }" style="width:100%"> </td>
								</tr> 
								
								<tr>
									<td> Support : </td>
									<td>
										<select style="width:100%" name="support">
											<option value="Mur"> Mur </option>
											<option value="Toit"> Toit </option>
											<option value="Sol"> Sol </option>
										</select>
									</td>
								</tr>
							</table>
						</td>					
					</tr>
					<tr style="font-size: 15px; line-height: 10px;">
						<td> * : champ obligatoire </td>
					</tr>
				</table>
				<br>
				<table>
					<td>
						<input type="submit" value="Enregistrer">				
						<a href="produit?parametre=${ nom }"> <button type="button"> Annuler </button></a>
					</td>
				</table>
		</div>		
	</body>
</html>