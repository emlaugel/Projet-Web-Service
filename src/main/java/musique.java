

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import bdd.Base;

public class musique extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Base b;
    private String musique;
    public musique() {
        super();
		b = new Base();

    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		musique = request.getParameter("parametre");
		/*
		List<String> not_found_testList = b.recupererMusiques(); 
		
		if (not_found_testList.contains(musique))
		{
			request.setAttribute("nom", musique);
			
			List<String> infos = b.infoMusique(musique);
			
			String album = infos.get(0);
			String duree = infos.get(1);
			String sortie = infos.get(2);
			
			String artiste = infos.get(3);
			List<String> artisteList = Arrays.asList(artiste.split("="));	
			
			String genre = infos.get(4);
			List<String> genreList = Arrays.asList(genre.split("="));	
			
			String lyrics = infos.get(5);
			
			request.setAttribute("album", album);
			request.setAttribute("duree", duree);
			request.setAttribute("sortie", sortie);
			request.setAttribute("artistes", artisteList);
			request.setAttribute("genres", genreList);
			request.setAttribute("lyrics", lyrics);
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/musique.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("not_found");
		}
		 */
	}
}
