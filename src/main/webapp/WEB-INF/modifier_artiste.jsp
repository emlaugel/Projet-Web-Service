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
						<td style="border-bottom: solid; font-size:25px;">
							<p> Modifier un artiste </p>
						</td>
					</tr>
				</table>
				
				<table>
					<tr>
						<td>
							<table>
								<tr>
									<td> Nom réel : </td>
									<td> <input type="text" name="nom_reel" value="${ nom_reel }" style="width:100%"> </td>
								</tr>
								
								<tr>
									<td> Nom alternatif * : </td>
									<td> <input type="text" name="nom_alternatif" value="${ nom_alternatif }" style="width:100%"> </td>
								</tr>
								
								<tr>
									<td> Type : </td>
									<td>
										<select style="width:100%" name="type">
											<option value="Personne"> Personne </option>
											<option value="Groupe"> Groupe </option>
										</select>
									</td>
								</tr>
								
								<tr>
									<td> Nationalité : </td>
									<td> <input type="text" name="nationalite" value="${ nationalite }" style="width:100%"> </td>
								</tr>
								
								<tr>
									<td> Sexe : </td>
									<td>
										<select name="sexe" style="width:100%">
											<option value="Autre"> Autre </option>
											<option value="Homme"> Homme </option>
											<option value="Femme"> Femme </option>
										</select>
									</td>
								</tr>
								
								<tr>
									<td> Date de naissance : </td>
									<td> <input type="text" name="naissance" value="${ naissance }" style="width:100%"> </td>
								</tr>
								
								<tr>
									<td> Status : </td>
									<td> <input type="text" name="status" value="${ status }" style="width:100%"> </td>
								</tr>
								
								<tr>
									<td> Début : </td>
									<td> <input type="text" name="debut" value="${ debut }" style="width:100%"> </td>
								</tr>
								
								<tr>
									<td> Genre(s) musicaux : </td>
									<td>
										<select style="width:100%" name="genres_musicaux[]" multiple>
											<option> </option>
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
							<p> Biographie </p>
						</td>
					</tr>
				</table>
				<table>
					<textarea name="biographie" maxlength="2990">${ biographie }</textarea>
				</table>
				
				<table>
					<td>
						<input type="submit" value="Enregistrer">				
						<a href="artiste?parametre=${ nom_alternatif }"> <button type="button"> Annuler </button></a>
					</td>
				</table>
		</div>		
	</body>
</html>