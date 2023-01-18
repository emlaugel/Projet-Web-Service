

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.mysql.cj.util.StringUtils;

import bdd.Base;

public class ajouter_genre extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Base b;
	
    public ajouter_genre() {
        super();
        b = new Base();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		b.createdatabase();

		String nom = request.getParameter("nom");
		
		String infos = request.getParameter("informations");	
		
		if (StringUtils.isEmptyOrWhitespaceOnly(nom)) {
			nom = null;
			this.getServletContext().getRequestDispatcher("/WEB-INF/ajouter_genre.jsp").forward(request, response);
		}
		else {
			response.setContentType("text/html");  
			PrintWriter pw = response.getWriter();  
			response.sendRedirect("genres");    
			pw.close(); 
			b.addGenre(nom, infos);
		}
	}

}
