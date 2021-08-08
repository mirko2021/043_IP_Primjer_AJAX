package yatospace.app.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * API Sevlet and resolver. 
 * @author MV
 * @version 1.0
 */
@WebServlet("/APIServlet/*")
public class APIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public APIServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
