

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import bdd.Base;

public class genres extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Base b;
	private int rows;
       
    public genres() {
        super();
        b = new Base();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<String> genres = b.recupererGenres();
		rows = genres.size();
		
		request.setAttribute("rows", rows);
		request.setAttribute("genres", genres);
		
		String delete = request.getParameter("genre");
		b.delGenre(delete);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/genres.jsp").forward(request, response);
	}

}
