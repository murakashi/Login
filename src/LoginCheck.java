
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
 * Servlet implementation class LoginCheck
 */
@WebServlet("/loginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginCheck() {
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
		HttpSession session = request.getSession();

		String flag = (String) session.getAttribute("flag");

		if (flag == null) {
			RequestDispatcher rd = request.getRequestDispatcher("login");
			rd.forward(request, response);
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");

		String pass = request.getParameter("pass");

		String flag = null;

		HttpSession session = request.getSession();

		RequestDispatcher rd;

		User user = new User();

		user.setId(id);
		user.setPass(pass);

		DBAccess db = new DBAccess();

		ArrayList<String[]> list = new ArrayList<String[]>();

		list = db.login(id, pass);

		String kengen = db.get_Kengen(id, pass);

		String master = request.getParameter("master");

		if (list.size() == 0) {//ログイン失敗の場合
			flag = "NG";
			session.setAttribute("flag", flag);
			rd = request.getRequestDispatcher("loginNG.jsp");
		} else if(list.size() == 1 && kengen.equals("0")) {//一般権限でログイン成功の場合
			/***************ユーザのログイン情報を受け渡す**************/
			String[] arr = list.get(0);
			user.setName(arr[2]);
			user.setAdress(arr[3]);
			session.setAttribute("user", user);
			flag = "OK";
			session.setAttribute("flag", flag);

			/*****************商品情報を渡す************************/
			ArrayList<String[]> s_list = new ArrayList<String[]>();

			s_list = db.select_SyohinTop();//商品マスタからセレクト

			session.setAttribute("s_list",s_list);

			rd = request.getRequestDispatcher("loginOK.jsp");
		}else {//管理者で成功の場合


			/***************ユーザのログイン情報を受け渡す**************/
			String[] arr = list.get(0);
			user.setName(arr[2]);
			user.setAdress(arr[3]);
			session.setAttribute("user", user);
			flag = "OK";
			session.setAttribute("flag", flag);

			/*********管理者閲覧用のデータを受け渡す***********/
			ArrayList<String[]> buy_list =  db.select_buyList();

			String sum = db.get_Sum();

			session.setAttribute("sum", sum);

			session.setAttribute("buy_list", buy_list);

			rd = request.getRequestDispatcher("master.jsp");
		}

		rd.forward(request, response);
	}

}
