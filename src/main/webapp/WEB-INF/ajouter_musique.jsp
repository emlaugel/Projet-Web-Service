<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> Ajouter musique </title>
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
		
			<form method="post" action="ajouter_musique">
				<table>
					<tr>
						<td style="font-size: 28px;">
							<p> Ajouter une musique </p>
						</td>
					</tr>
				</table>
				
				<table>
					<tr>
						<td>
							<table>
								<tr>
									<td> Nom * : </td>
									<td> <input type="text" name="nom" style="width:100%"> </td>
								</tr>
								
								<tr>
									<td> Album : </td>
									<td> <input type="text" name="album" style="width:100%"> </td>
								</tr>
								
								<tr>
									<td> Durée : </td>
									<td> <input type="text" name="duree" style="width:100%"> </td>
								</tr>
								
								<tr>
									<td> Date de sortie : </td>
									<td> <input type="text" name="sortie" style="width:100%"> </td>
								</tr>
								
								<tr>
									<td> Artiste : </td>
									<td>
										<select style="width:100%" name="artiste">
											<option> </option>
											<c:forEach begin="1" end="${ artistes.size() }" var="j">
													<option> ${ artistes.get(j-1) } </option>
											</c:forEach>
										</select>
									</td>
								</tr>
								<tr>
									<td> Artiste(s) : </td>
									<td>
										<select style="width:100%" name="artistes[]" multiple>
											<option> </option>
												<c:forEach begin="1" end="${ artistes.size() }" var="j">
													<option> ${ artistes.get(j-1) } </option>
												</c:forEach>
										</select>
									</td>
								</tr>
								
								<tr>
									<td> Genre(s) musicaux : </td>
									<td>
										<select style="width:100%" name="genres_musicaux[]" multiple>
											<option> - </option>
												<c:forEach begin="1" end="${ genres.size() }" var="j">
													<option> ${ genres.get(j-1) } </option>
												</c:forEach>
										</select>
									</td>
								</tr>
								<tr>
									<td colspan="3" style="text-align:right; font-size: 15px;"> Maintenir Ctrl pour choisir plusieurs genres </td>
								</tr>
							</table>
						</td>					
					</tr>
					<tr style="font-size: 15px; line-height: 10px;">
						<td> * : champ obligatoire </td>
					</tr>
				</table>
				
				<table>
					<tr>
						<td style="font-size: 22px;">
							<p> Paroles </p>
						</td>
					</tr>
				</table>
				<table>
					<textarea name="lyrics" maxlength="2990"></textarea>
				</table>
				
				<table>
					<input type="submit" value="Enregistrer">				
					<a href="musiques"> <button type="button"> Annuler </button></a>
				</table>
			</form>
		</div>		
	</body>
</html>