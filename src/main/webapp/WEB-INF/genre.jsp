<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${ genre }</title>
	</head>
		
	<%@include file = "menu.jsp"%>
	
	<body>
		<div class="topnav">
			<a href="accueil">Accueil</a>
			<a href="artistes">Artistes</a>
			<a href="musiques">Musiques</a>
			<a class="active" href="genres">Genres</a>
			
			<form autocomplete="off" action="rechercher">
			 	<button type="submit"> <i class="fa fa-search"> </i></button>
				<input type="text" name="search" maxlength="30" placeholder="Rechercher...">					
			</form>
		</div>
		
		<div id="overlay">
			<div id="text">
				<p> Voulez-vous vraiment supprimer ce genre ? </p>
				<p>
					<a href="redirection?valeur=genre&parametre=${ genre }"> <button type="submit" style="width:150px; height:40px;"> Oui </button> </a>
					<button type="button" style="width:150px; height:40px;" onclick="off()"> Non </button>
				</p>
			</div>
		</div>
		
		<div class="center">
			<table style="margin-bottom: 30px;">
				<tr style="border-bottom: solid; font-size: 22px;">
					<td>
						<p> ${ genre } </p>
					</td>
					<td style="width:50px">
						<p> <a class="btn-group"><button type="button" onclick="on()"> Supprimer </button> </a> </p>
					</td>
					<td style="width:50px">
						<p>
							<form action="modifier_genre?parametre=${ genre }" method="post">
								<a class="btn-group"> <button type="submit"> Modifier </button> </a>
							</form>
						</p>
					</td>
				</tr>
			</table>
		
			<table>
				<tr style="line-height:0; border-bottom: solid; border-width: 1px;">
					<td style="font-size: 20px;">
						<p> Informations </p>
					</td>
				</tr>
			</table>
			<table style="font-size: 20px;">
				<td colspan="3"> <p style="white-space: pre-line"> ${ informations } </p> </td>
			</table>
		</div>		
		
	</body>
</html>