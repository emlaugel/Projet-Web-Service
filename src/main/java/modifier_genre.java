

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import bdd.Base;

public class modifier_genre extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Base b;
	private String parametre;
	
    public modifier_genre() {
        super();
        b = new Base();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String nom = request.getParameter("nom");		
		String informations = request.getParameter("informations");
		
		b.delGenre(parametre);
		b.addGenre(nom, informations);
		
		response.sendRedirect("genre?parametre=" + nom);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		parametre = request.getParameter("parametre");		

		request.setAttribute("nom", parametre);

		List<String> infos = b.infoGenre(parametre);
		
		String informations = infos.get(0);
		
		
		request.setAttribute("informations", informations);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/modifier_genre.jsp").forward(request, response);		
	}

}
