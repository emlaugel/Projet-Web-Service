

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import bdd.Base;

public class musiques extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Base b;   
    private int rows;
	
    public musiques() {
        super();
        b = new Base();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//List<String> musiques = b.recupererMusiques();
		//rows = musiques.size();
		
		request.setAttribute("rows", rows);
		//request.setAttribute("musiques", musiques);
		
		String nom = request.getParameter("musique");
		
		//b.delMusique(nom);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/musiques.jsp").forward(request, response);
	}

}
