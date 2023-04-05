<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> Ajouter produit </title>
	</head>
		
	<%@include file = "menu.jsp"%>
	
	<div class="topnav">
		<a href="accueil">Accueil</a>
		<a href="produits">Produits</a>
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
				<table style="margin-bottom: 30px;">
					<tr style="line-height:0; border-bottom: solid;">
						<td style="font-size: 22px;">
							<p> Ajouter un produit </p>
						</td>
					</tr>
				</table>
				
				<table style="line-height:0; margin-bottom: 30px;">
					<tr style="line-height:0; border-bottom: solid; border-width: 1px;">
						<td style="font-size: 20px;">
							<p> Informations </p>
						</td>
					</tr>
					<tr style="line-height:5px; font-size: 18px;">
						<td>
							<table>
								<tr>
									<td> Nom * : </td>
									<td> <input type="text" name="nom" style="width:100%"> </td>
								</tr>
								
								<tr>
									<td> Prix : </td>
									<td> <input type="text" name="prix" style="width:100%"> </td>
								</tr>
								
								<tr>
									<td> Type : </td>
									<td> <input type="text" name="type" style="width:100%"> </td>
									
								</tr>
								
								<tr>
									<td> Contenance : </td>
									<td> <input type="text" name="contenance" style="width:100%"> </td>
								</tr>
								
								<tr>
									<td> Marque : </td>
									<td> <input type="text" name="marque" style="width:100%"> </td>
								</tr>
								
								<tr>
									<td> Couleur : </td>
									<td> <input type="text" name="couleur" style="width:100%"> </td>
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
				
				
				<table>
					<td>
						<input type="submit" value="Enregistrer">				
						<a href="produits"> <button type="button"> Annuler </button></a>
					</td>
				</table>
			</form>
		</div>		
	</body>
</html>