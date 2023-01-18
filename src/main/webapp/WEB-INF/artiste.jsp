<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${ nom_alternatif }</title>
	</head>
		
	<%@include file = "menu.jsp"%>
	
	<div class="topnav">
		<a href="accueil">Accueil</a>
		<a class="active" href="artistes">Artistes</a>
		<a href="musiques">Musiques</a>
		<a href="genres">Genres</a>
		
		<form autocomplete="off" action="rechercher">
		 	<button type="submit"> <i class="fa fa-search"> </i></button>
			<input type="text" name="search" maxlength="30" placeholder="Rechercher...">					
		</form>
	</div>
	
	<body>	
		
		<div id="overlay">
			<div id="text">
				<p> Voulez-vous vraiment supprimer cet artiste ? </p>
				<p>
					<a href="redirection?valeur=artiste&parametre=${ nom_alternatif }"> <button type="submit" style="width:150px; height:40px;"> Oui </button> </a>
					<button type="button" style="width:150px; height:40px;" onclick="off()"> Non </button>
				</p>
			</div>
		</div>
		
		<div class="center">
			
			<table style="margin-bottom: 30px;">
				<tr style="line-height:0; border-bottom: solid; font-size: 22px;">
					<td>
						<p> ${ nom_alternatif } </p>
					</td>
					<td style="width:50px">
						<p> <a class="btn-group"><button type="button" onclick="on()"> Supprimer </button> </a> </p>
					</td>
					<td style="width:50px">
						<p>
							<form action="modifier_artiste?parametre=${ nom_alternatif }" method="post">
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
						<p> Nom réel : ${ nom_reel }</p>
						<p> Nom alternatif : ${ nom_alternatif } </p>
						<p> Type : ${ type } <p>
						<p> Nationalité : ${ nationalite } </p>
						<p> Sexe : ${ sexe }</p>
						<p> Date de naissance : ${ naissance }</p>
						<p> Status : ${ status }</p>
						<p> Début : ${ debut }</p>
						<p> Genre(s) musicaux : 
							<c:forEach begin="1" end="${ genres.size() }" var="j">
								<p style="padding-left:100px;"> <a href="genre?parametre=${ genres.get(j-1) }"> ${ genres.get(j-1) } </a> </p>
							</c:forEach>
						</p>
					</td>
				</tr>
			</table>
			
			<table>
				<tr style="line-height:0; border-bottom: solid; border-width: 1px;">
					<td style="font-size: 20px;">
						<p> Biographie </p>
					</td>
				</tr>
				<tr>
					<td colspan="3"> <p style="white-space: pre-line; font-size: 18px;"> ${ biographie } </p> </td>
				</tr>
			</table>
		</div>		
	</body>
</html>