<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Artiste</title>
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
		<a href="ajouter_produit" style="float:right; font-size: 26px;"> <i class="fa fa-plus"></i> </a>
	</div>
	
	<body>
		<div class="center">
			<div id="overlay">
				<div id="text">
					<p> Artiste supprimé </p>
					<p>
						<a href="produits?produit=${ nom }"> <button type="submit" style="width:150px; height:40px;"> Oui </button> </a>
						<button type="button" style="width:150px; height:40px;" onclick="off()"> Non </button>
					</p>
				</div>
			</div>			


			<div class="btn-group">
				<table>
					<c:forEach begin="1" end="${ rows }" var="j">
						<tr>
							<th style="border-bottom: solid; border-width:1px;">
								<a class="btn-group" href="produit?parametre=${ produits.get(j-1) }"> <button>
									<table>
										<tr>
											<td style="padding-left:40px;">
												${ produits.get(j-1) }
											</td>
										</tr>
									</table>
								</button> </a>
							</th>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		
		
		
	</body>
</html>