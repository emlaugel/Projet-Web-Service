<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${ nom }</title>
	</head>
		
	<%@include file = "menu.jsp"%>
	
	<div class="topnav">
		<a href="accueil">Accueil</a>
		<a class="active" href="produits">Produits</a>
		<a href="musiques">--Musiques</a>
		<a href="genres">--Genres</a>
		
		<form autocomplete="off" action="rechercher">
		 	<button type="submit"> <i class="fa fa-search"> </i></button>
			<input type="text" name="search" maxlength="30" placeholder="Rechercher...">					
		</form>
	</div>
	
	<body>	
		
		<div id="overlay">
			<div id="text">
				<p> Voulez-vous vraiment supprimer ce produit ? </p>
				<p>
					<a href="redirection?valeur=produit&parametre=${ nom }"> <button type="submit" style="width:150px; height:40px;"> Oui </button> </a>
					<button type="button" style="width:150px; height:40px;" onclick="off()"> Non </button>
				</p>
			</div>
		</div>
		
		<div class="center">
			
			<table style="margin-bottom: 30px;">
				<tr style="line-height:0; border-bottom: solid; font-size: 22px;">
					<td>
						<p> ${ nom } </p>
					</td>
					<td style="width:50px">
						<p> <a class="btn-group"><button type="button" onclick="on()"> Supprimer </button> </a> </p>
					</td>
					<td style="width:50px">
						<p>
							<form action="modifier_produit?parametre=${ nom }" method="post">
								<a class="btn-group"> <button type="submit"> Modifier </button> </a>
							</form>
						</p>
					</td>
				</tr>
			</table>
			
			<table style="margin-bottom: 30px;">
				<tr style="line-height:0; border-bottom: solid; border-width: 1px;">
					<td style="font-size: 20px;">
						<p> Informations </p>
					</td>
				</tr>
				<tr style="line-height:5px; font-size: 18px;">
					<td colspan="2">
						<p> Nom : ${ nom }</p>
						<p> Prix : ${ prix } </p>
						<p> Type : ${ type } <p>
						<p> Contenance : ${ contenance } </p>
						<p> Marque : ${ marque }</p>
						<p> Couleur : ${ couleur }</p>
						<p> Support : ${ support }</p>
					</td>
				</tr>
			</table>
		</div>		
	</body>
</html>