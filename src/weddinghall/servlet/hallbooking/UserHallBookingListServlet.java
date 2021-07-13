package weddinghall.servlet.hallbooking;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import weddinghall.dao.HallsBookingDao;
import weddinghall.model.HallsBooking;




@WebServlet("/listUserhallBook")
public class UserHallBookingListServlet extends HttpServlet {
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
		
		
	Cookie c1[] = request.getCookies();
		
		System.out.println("Cookies get");
		System.out.println(c1[0].getValue());
		String loginuser=c1[0].getValue();
		System.out.println("Request");	
		
		String action = request.getServletPath();
		List<HallsBooking> listRoomBooking = RoomsBookingDao.selectAllRoomBookingsByUser(loginuser);
		//System.out.print(listUser);
		request.setAttribute("listRoomBooking", listRoomBooking);
		RequestDispatcher dispatcher = request.getRequestDispatcher("UserHallBookList.jsp");
		dispatcher.forward(request, response);
		
	}

	

}