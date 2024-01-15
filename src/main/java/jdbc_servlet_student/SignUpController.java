package jdbc_servlet_student;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUpController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		String student_name = req.getParameter("student_name");
		String father_name = req.getParameter("father_name");
		String mother_name = req.getParameter("mother_name");
		String address = req.getParameter("address");
		long phone = Long.parseLong(req.getParameter("phone"));
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		Student student = new Student();
		student.setId(id);
		student.setStudent_name(student_name);
		student.setFather_name(father_name);
		student.setMother_name(mother_name);
		student.setAddress(address);
		student.setPhone(phone);
		student.setEmail(email);
		student.setPassword(password);
		
//		ServletContext context = getServletContext();
//		String school = context.getInitParameter("Sahyadri_School");
//		double fees=0;
//		
//		if (fees==36990) 
//		{
//			ServletConfig config = getServletConfig();
//			fees = Double.parseDouble(config.getInitParameter("one_shot"));
//		} 
//		else 
//		{
//			ServletConfig config = getServletConfig();
//			fees = Double.parseDouble(config.getInitParameter("installment"));
//		}
//	
//		fees += (cgst+sgst)*price;
//		product.setPrice(price);
		
		StudentCRUD crud = new StudentCRUD();
		try 
		{
			int result = crud.signUp(student);
			if (result !=0) 
			{
//				RequestDispatcher dispatcher = req.getRequestDispatcher("Success.html");
//				dispatcher.forward(req, resp);
				resp.sendRedirect("Login.html");
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}

