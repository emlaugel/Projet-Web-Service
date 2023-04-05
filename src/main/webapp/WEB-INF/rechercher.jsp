<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Accueil</title>
	</head>
		
	<%@include file = "menu.jsp"%>
	
	<body>
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
		
		<div class="center">
			<p style="border-bottom: solid; font-size:25px;"> Recherches : ${ sujet } </p>
			
			<div class="btn-group">
				<table>
					<c:forEach begin="1" end="${ rows }" var="j">
						<tr>
							<th style="border-bottom: solid; border-width:1px;">
								<a class="btn-group" href="${ type.get(j-1) }?parametre=${ contenu.get(j-1) }"> <button>
									<table>
										<tr>
											<td style="padding-left:40px;">
												${ contenu.get(j-1) }
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