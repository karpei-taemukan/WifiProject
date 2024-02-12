package Servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sqlite.DB_Delete_openApi;

@WebServlet("/deleteHistory")
public class DeleteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			  
				String idx = req.getParameter("idx");
				
				System.out.println(idx);
				
				DB_Delete_openApi del = new DB_Delete_openApi();
				del.delete(Integer.parseInt(idx));
		}
}
