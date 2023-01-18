

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import bdd.Base;

public class genre extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Base b;   
	
    public genre() {
        super();
        b = new Base();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String genre = request.getParameter("parametre");
		
		List<String> not_found_testList = b.recupererGenres(); 
		
		if (not_found_testList.contains(genre))
		{
			request.setAttribute("genre", genre);
			
			List<String> infos = b.infoGenre(genre);
			
			String informations = infos.get(0);
			
			request.setAttribute("informations", informations);
	
			this.getServletContext().getRequestDispatcher("/WEB-INF/genre.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("not_found");
		}
	}
}
