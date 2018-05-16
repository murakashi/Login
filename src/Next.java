

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Next
 */
@WebServlet("/next")
public class Next extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Next() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String offset = request.getParameter("offset");

		DBAccess db = new DBAccess();

		ArrayList<String[]> s_list = new ArrayList<String[]>();

		if(offset.equals("1")) {
			s_list = db.select_SyohinTop();
		}else {
			s_list = db.select_SyohinNext(offset);
		}

		session.setAttribute("s_list", s_list);

		RequestDispatcher rd = request.getRequestDispatcher("loginOK.jsp");

		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		String offset = request.getParameter("offset");

		DBAccess db = new DBAccess();

		ArrayList<String[]> s_list = new ArrayList<String[]>();

		if(offset.equals("1")) {
			s_list = db.select_SyohinTop();
		}else {
			s_list = db.select_SyohinNext(offset);
		}

		session.setAttribute("s_list", s_list);

		RequestDispatcher rd = request.getRequestDispatcher("loginOK.jsp");

		rd.forward(request, response);
	}

}
