package weddinghall.servlet.hallbooking;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import weddinghall.dao.HallsBookingDao;
import weddinghall.model.HallsBooking;




@WebServlet("/insertuserhallBook")
public class UserInsertBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HallsBookingDao RoomsBookingDao;
	
	public void init() {
		RoomsBookingDao = new HallsBookingDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		String user = request.getParameter("user");
		String nic = request.getParameter("nic");
		int mobile = Integer.parseInt(request.getParameter("mobile"));
		String email = request.getParameter("email");
		String checkin = (request.getParameter("checkin"));
		String checkout = (request.getParameter("checkout"));
		int noofrooms = Integer.parseInt(request.getParameter("noofrooms"));
		int members = Integer.parseInt(request.getParameter("members"));
		int advancedPayment = Integer.parseInt(request.getParameter("advancedPayment"));
		
		HallsBooking rm = new HallsBooking( user, nic, mobile,email,checkin,checkout,noofrooms,members,advancedPayment);
		try {
			RoomsBookingDao.insertRoomsBook(rm);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("listUserRoomBook");
	
	}

	

}