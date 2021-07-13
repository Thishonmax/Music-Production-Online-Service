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




@WebServlet("/listHallBook")
public class HallBookingListServlet extends HttpServlet {
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
		List<HallsBooking> listRoomBooking = RoomsBookingDao.selectAllRoomBookings();
		//System.out.print(listUser);
		request.setAttribute("listRoomBooking", listRoomBooking);
		RequestDispatcher dispatcher = request.getRequestDispatcher("HallBookingList.jsp");
		dispatcher.forward(request, response);
		
	}

	

}