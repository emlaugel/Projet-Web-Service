

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import com.mysql.cj.result.Field;

public class images extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public images() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String path = "/WEB-INF/images/question_mark.png";
		
		//Chargement d'une image depuis un emplacement sécurisé du serveur
        BufferedImage image = getImage(request.getRequestURI(), path);
        
        //Définition de l'en-tête de la réponse
        response.setContentType("image/png");
        
        //Sérialisation de l'image dans la réponse
        OutputStream out = response.getOutputStream();
        
        ImageIO.write(image, "PNG", out);
        out.close();
        
        
		path = "/WEB-INF/images/person_A.png";

        image = getImage(request.getRequestURI(), path);
        
        out = response.getOutputStream();
        
        ImageIO.write(image, "PNG", out);
        out.close();		
        //response.redirect
	}

	/** Méthode qui fournit une image **/
	private BufferedImage getImage(String uri, String path) throws IOException
	{
		return ImageIO.read(new File(getServletContext().getRealPath(path)));
	}

}
