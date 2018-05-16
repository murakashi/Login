

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;

/**
 * Servlet implementation class Buy
 */
@WebServlet("/buy")
public class Buy extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Buy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");

		String id = user.getId();

		String[] foods = request.getParameterValues("foods");

		String[] count = new String[foods.length];

		for(int i=0;i<count.length;i++) {
			count[i] = request.getParameter(foods[i]);
		}

		DBAccess db = new DBAccess();

		//フォーマットパターンを指定
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        Date d = new Date();

        String date = null;

        String max = null;

		for(int i=0;i<foods.length;i++) {
			max = db.select_Max();
			d = new Date();
			//System.out.println(sdf.format(date.getTime()));
			date = sdf.format(d.getTime());
			db.insert_Log(max,id,foods[i],count[i],date);
		}

		ArrayList<String[]> log_list = new ArrayList<String[]>();

		log_list = db.select_Log(id);

		session.setAttribute("log_list", log_list);

		RequestDispatcher rd = request.getRequestDispatcher("finish.jsp");

		rd.forward(request, response);
	}

}
