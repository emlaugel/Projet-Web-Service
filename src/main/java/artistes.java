

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.jsp.PageContext;

import java.io.IOException;
import java.util.List;

import javax.swing.JButton;

import bdd.Base;


public class artistes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Base b;
	private int rows;
	
    public artistes() {
        super();
        b = new Base();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		b.createdatabase();

		List<String> artistes = b.recupererArtistes();
		rows = artistes.size();
		
		request.setAttribute("rows", rows);
		request.setAttribute("artistes", artistes);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/artistes.jsp").forward(request, response);
	}
}
