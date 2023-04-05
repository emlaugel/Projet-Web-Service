

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.language.*;

import bdd.Base;

public class rechercher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Base b;
	
    public rechercher() {
        super();
        b = new Base();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String search = request.getParameter("search");
		request.setAttribute("sujet", search);
		
		String first, second;
		
		first = request.getParameter("first");
		second = request.getParameter("second");
		
		List<String> content_list = new ArrayList<String>();
		List<String> type_list = new ArrayList<String>();
		
		try {
			content_list = sort(b.rechercher(search)).get(0);
			type_list = sort(b.rechercher(search)).get(1);
		} catch (EncoderException e1) {
			e1.printStackTrace();
		}
		
		request.setAttribute("contenu", content_list);
		request.setAttribute("type", type_list);
		request.setAttribute("rows", content_list.size());
		
		Soundex s = new Soundex();
		
		int val = 0;
		
		try {
			val = s.difference(first, second);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		b.createdatabase();

		this.getServletContext().getRequestDispatcher("/WEB-INF/rechercher.jsp").forward(request, response);
	}
	
	private List<List<String>> sort(List<String> input){	
		List<List<String>> retour = new ArrayList<List<String>>();
		
		String temp;
		for (int i = 0; i < input.size(); i++) {
            for (int j = i + 1; j < input.size(); j++) {
               
                // to compare one string with other strings
                if (input.get(i).compareTo(input.get(j)) < 0) {
                    // swapping
                    temp = input.get(i);
                    input.set(i, input.get(j));
                    input.set(j, temp);
                }
            }
        }
		
		List<String> temp_1 = new ArrayList<String>();
		List<String> temp_2 = new ArrayList<String>();

		for (String s : input)
		{
			String[] ss = s.split("=");
			String content = ss[1];
			
			temp_1.add(content);
			temp_2.add(ss[2]);
		}
		
		retour.add(temp_1);
		retour.add(temp_2);
		
		return retour;
	}
}
