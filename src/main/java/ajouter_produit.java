

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.apache.catalina.connector.Response;

import com.mysql.cj.util.StringUtils;

import bdd.Base;

public class ajouter_produit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Base b;
	private String nom, prix, type, contenance, marque, couleur, support;
	
	
    public ajouter_produit() {
        super();
        b = new Base();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		b.createdatabase();
		
		List<String> produits = b.recupererProduits();
		request.setAttribute("produits", produits);
		
		nom = request.getParameter("nom");
		prix = request.getParameter("prix");
		type = request.getParameter("type");
		contenance = request.getParameter("contenance");
		marque = request.getParameter("marque");
		couleur = request.getParameter("couleur");
		support = request.getParameter("support");
		
		if (StringUtils.isEmptyOrWhitespaceOnly(nom)) {
			nom = null;
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/ajouter_produit.jsp").forward(request, response);
			}
		
		else {
			response.setContentType("text/html");  
			PrintWriter pw = response.getWriter();  
			  
			response.sendRedirect("produit?parametre=" + nom);  
			  
			pw.close();  
			b.addProduit(nom, prix, type, contenance, marque, couleur, support);
		}
	}
}
