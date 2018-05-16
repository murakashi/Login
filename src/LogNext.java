
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;

/**
 * Servlet implementation class LogNext
 */
@WebServlet("/logNext")
public class LogNext extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogNext() {
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

		ArrayList<String[]> log_list = new ArrayList<String[]>();

		User user = (User)session.getAttribute("user");

		String id = user.getId();

		if(offset.equals("1")) {
			log_list = db.select_Log(id);
		}else {
			log_list = db.select_LogNext(id,offset);
		}

		session.setAttribute("log_list", log_list);

		RequestDispatcher rd = request.getRequestDispatcher("buylog.jsp");

		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
