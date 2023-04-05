

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.mysql.cj.util.StringUtils;

import bdd.Base;

public class modifier_produit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Base b;
	private String parametre;
	
    public modifier_produit() {
        super();
        b = new Base();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String nom = request.getParameter("nom");		
		String prix = request.getParameter("prix");
		String type = request.getParameter("type");
		String contenance = request.getParameter("contenance");
		String marque = request.getParameter("marque");
		String couleur = request.getParameter("couleur");
		String support = request.getParameter("support");
		
		//String T1 = parametre + nom + nom_reel + type + nationalite + sexe + naissance + status + debut + genres_musicaux + biographie;
		//request.setAttribute("T1", T1);
		
		b.delProduit(parametre);
		b.addProduit(nom, prix, type, contenance, marque, couleur, support);
		
		
		response.sendRedirect("produit?parametre=" + nom);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		parametre = request.getParameter("parametre");		
		
		request.setAttribute("nom", parametre);

		//List<String> genres = b.recupererGenres();
		//request.setAttribute("genres", genres);
		
		List<String> infos = b.infoProduit(parametre);
		
		String prix = infos.get(0);	
		String type = infos.get(1);	
		String contenance = infos.get(2);	
		String marque = infos.get(3);
		String couleur = infos.get(4);	
		String support = infos.get(5);	
		
		request.setAttribute("prix", prix);
		request.setAttribute("type", type);
		request.setAttribute("contenance", contenance);
		request.setAttribute("marque", marque);
		request.setAttribute("couleur", couleur);
		request.setAttribute("support", support);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/modifier_produit.jsp").forward(request, response);		
	}
}
