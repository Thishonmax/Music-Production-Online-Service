package weddinghall.servlet.hall;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import weddinghall.dao.HallsDao;
import weddinghall.model.Halls;


@WebServlet("/listhalls")
public class HallListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HallsDao RoomsDao;

	public void init() {
		RoomsDao = new HallsDao();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		List<Halls> listRooms = RoomsDao.selectAllRooms();
		
		// System.out.print(listUser);
		request.setAttribute("listRooms", listRooms);
		RequestDispatcher dispatcher = request.getRequestDispatcher("HallList.jsp");
		dispatcher.forward(request, response);
		
	}

	
}