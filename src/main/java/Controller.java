import java.io.IOException;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		int mobile=Integer.parseInt(request.getParameter("mobile"));
		int room_no=Integer.parseInt(request.getParameter("room_no"));
		String entry=request.getParameter("entry");
		int stay=Integer.parseInt(request.getParameter("stay"));
		
		
		
		PrintWriter out=response.getWriter();
		out.println("Registerd Sussesfully...!!!");
		out.println(name);
		out.println(email);
		out.println(mobile);
		out.println(room_no);
		out.println(entry);
		out.println(stay);
		System.out.println("-->");
		
		response.setHeader("Cache-Control", "no-cache, no-store");
	    response.setHeader("Pragma", "no-cache");

	    request.getSession().invalidate();
	     RequestDispatcher rd = request.getRequestDispatcher("thank.html");
	       rd.forward(request, response);
		
		hotelBean htb=new hotelBean();
		htb.setName(name);
		htb.setEmail(email);
		htb.setMobile(mobile);
		htb.setRoom_no(room_no);
		htb.setEntry(entry);
		htb.setStay(stay);
		
		HotelDAO hdao=new HotelDAO();
		
		try {
			hdao.insertDetails(htb);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("Data.jsp");
		
		
	}

}
