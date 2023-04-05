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
		<a href="artistes">Artistes</a>
		<a class="active" href="musiques">Musiques</a>
		<a href="genres">Genres</a>
		
		<form autocomplete="off" action="rechercher">
		 	<button type="submit"> <i class="fa fa-search"> </i></button>
			<input type="text" name="search" maxlength="30" placeholder="Rechercher...">					
		</form>
	</div>
	
	<body>	
		
		<div id="overlay">
			<div id="text">
				<p> Voulez-vous vraiment supprimer cette musique ? </p>
				<p>
					<a href="redirection?valeur=musique&parametre=${ nom }"> <button type="submit" style="width:150px; height:40px;"> Oui </button> </a>
					<button type="button" style="width:150px; height:40px;" onclick="off()"> Non </button>
				</p>
			</div>
		</div>
		
		<div class="center">
			
			<table style="margin-bottom: 30px;">
				<tr style="border-bottom: solid; font-size: 22px;">
					<td style="font-size: 22px;">
						<p> ${ nom } </p>
					</td>
					<td style="width:50px">
						<p> <a class="btn-group"><button type="button" onclick="on()"> Supprimer </button> </a> </p>
					</td>
					<td style="width:50px">
						<form action="modifier_musique?parametre=${ nom }" method="post">
							<a class="btn-group"> <button type="submit"> Modifier </button> </a>
						</form>
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
						<p> Album : ${ album } </p>
						<p> Durée : ${ duree } <p>
						<p> Date de sortie : ${ sortie } </p>
						<p> Artiste(s) : 
							<c:forEach begin="1" end="${ artistes.size() }" var="j">
								<a href="artiste?parametre=${ artistes.get(j-1) }" style="padding-right:10px;"> ${ artistes.get(j-1) } </a>
							</c:forEach>
						</p>
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
					<td colspan="3" style="font-size: 20px;">
						<p> Paroles </p>
					</td>
				</tr>
				<tr>
					<td colspan="3"> <p style="white-space: pre-line; text-align: center;"> ${ lyrics } </p> </td>
				</tr>
			</table>
		</div>				
	</body>
</html>