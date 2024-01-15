package jdbc_servlet_student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		StudentCRUD crud = new StudentCRUD();
		try {
			String dbPassword = crud.getStudent(email);
			PrintWriter out = resp.getWriter();
			if (dbPassword != null) {
				if (password.equals(dbPassword)) {
					// out.print("Login Success");
//					RequestDispatcher dispatcher = req.getRequestDispatcher("Home.html");
//					dispatcher.forward(req, resp);
					resp.sendRedirect("https://stackoverflow.com/");
				} else {
//					out.print("Login Failed");
//					RequestDispatcher dispatcher = req.getRequestDispatcher("Login.html");
//					dispatcher.forward(req, resp);
					resp.sendRedirect("Login.html");

				}

			} else {
//				out.print("User not found, Please Register!");
//				RequestDispatcher dispatcher = req.getRequestDispatcher("SignUp.html");
//				dispatcher.forward(req, resp);
				resp.sendRedirect("SignUp.html");
			}
		}

		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
